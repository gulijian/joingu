package com.gulj.assembly.redis;

/**
 * @author gulj
 * @create 2017-05-24 下午5:03
 **/
public class EmailAssemblyBo {


    private String from;//发送者
    private String to;//接收者
    private String subject;//主题
    private String text;//内容


    public EmailAssemblyBo() {
    }

    public EmailAssemblyBo(String from, String to, String subject, String text) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
