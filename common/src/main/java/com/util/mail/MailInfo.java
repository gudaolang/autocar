package com.util.mail;

/**
 * Description: base
 * Created by lee on 2018/6/25 18:39
 */
public class MailInfo {


    private String subject;

    private String content;

    private String[] attachFileNames;

    private String iwallHost;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getAttachFileNames() {
        return attachFileNames;
    }

    public void setAttachFileNames(String[] attachFileNames) {
        this.attachFileNames = attachFileNames;
    }

    public String getIwallHost() {
        return iwallHost;
    }

    public void setIwallHost(String iwallHost) {
        this.iwallHost = iwallHost;
    }
}
