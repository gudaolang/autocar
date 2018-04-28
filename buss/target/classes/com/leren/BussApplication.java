package com.leren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


//java -jar xxx.jar --server.port=8888
//@SpringBootApplication(scanBasePackages = {"com.leren.entity", "com.leren.controller","com.leren.base","com.leren.exception"})
//@ComponentScan(value = {"com.leren.entity", "com.leren.controller"})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class BussApplication {
    public static void main(String[] args) {
        SpringApplication.run(BussApplication.class, args);
    }
}
