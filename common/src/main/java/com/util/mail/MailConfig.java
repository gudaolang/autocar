package com.util.mail;

import java.util.Properties;

/**
 * Description: base
 * Created by lee on 2018/6/25 18:43
 */
public class MailConfig {

    /**
     * 发送邮件服务器ip
     */
    private String mailServerHost;
    /**
     * 端口
     */
    private String mailServerPort = "25";

    private String fromAddress;

    private String toAddress;

    private String userName;

    private String password;

    private boolean validate = false;

    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s2.intern());
    }

    public Properties getProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", this.mailServerHost);
        props.put("mail.smtp.port", this.mailServerPort);
        props.put("mail.smtp.auth", validate);
        return props;
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }
}
