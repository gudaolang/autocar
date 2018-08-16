package com.util.mq;

import com.google.common.collect.Maps;
import com.rabbitmq.client.*;
import com.util.MapUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Description: base
 * Created by lee on 2018/7/4 13:58
 */
public class MqClient {


    public static final String userName = "guest";
    public static final String pwd = "guest";

    /**
     * 获取mq连接
     *
     * @return connection mqConnection
     */
    public static Connection getConn() throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        ConnectionFactory factory = new ConnectionFactory();

        // factory设置 或 factory.setUri("amqp://guest:guest@localhost:15672//");
        //guest
        factory.setUsername(userName);
        factory.setPassword(pwd);
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(15672);

        return factory.newConnection();
    }

    public static void main(String[] args) throws URISyntaxException, KeyManagementException, TimeoutException, NoSuchAlgorithmException, IOException {

        Connection conn = getConn();

        Channel channel = conn.createChannel();

        String routingKey = "routingKey";
        String exchangeName = "exchangeName";
        channel.exchangeDeclare(exchangeName, "direct", true);
        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind(queueName, exchangeName, routingKey);

        //持久化消息
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);

        //获取队列状态
        AMQP.Queue.DeclareOk response = channel.queueDeclarePassive(queueName);

        //返回队列中处于就绪状态的消息数量
        int msgNums = response.getMessageCount();
        //返回队列使用消费者数量
        int consumerNums = response.getConsumerCount();

        //服务端无响应队列(只能通过轮询检测队列以及消息状态)
        channel.queueDeclareNoWait(queueName, true, false, false, null);

        //队列删除
        channel.queueDelete(queueName);
        //只有队列为空时,才可删除
        channel.queueDelete(queueName, false, true);

        //没有任何消费者时 方可删除
        channel.queueDelete(queueName, true, false);

        //删除队列所有消息
        channel.queuePurge(queueName);

        // **消息发布 start**
        byte[] bodyMsg = "hello,world".getBytes();
        channel.basicPublish(exchangeName, routingKey, null, bodyMsg);
        boolean blMandatory = true;
        channel.basicPublish(exchangeName, routingKey, blMandatory, MessageProperties.PERSISTENT_TEXT_PLAIN, bodyMsg);

        //发布消息带上发布者信息
        channel.basicPublish(exchangeName, routingKey,
                new AMQP.BasicProperties.Builder()
                        .contentType("text/plain")
                        .deliveryMode(2)
                        .priority(1).userId("userId").build(), bodyMsg);

        //自定义消息头
        Map<String, Object> headers = Maps.newHashMapWithExpectedSize(3);
        MapUtils.addToMap(headers, "token", "token_XX");
        channel.basicPublish(exchangeName, routingKey,
                new AMQP.BasicProperties.Builder().headers(headers).build(), bodyMsg);

        //发布带有过期时间的消息
        channel.basicPublish(exchangeName, routingKey,
                new AMQP.BasicProperties.Builder().expiration("6000").build(), bodyMsg);
        //共享信道 信道池(channel pool) => springAMQP

        // **消息发布 end**

        // **消费消息 start**

    }

}
