package com.scg.model;

/**
 * Created by KIMU on 2016. 6. 30..
 */
public class Message {

    private String title;    //몸싸커 팀게시판 글
    private String content;  //유저명 : 등록글
    private String message;  //메세지
    private String key1;
    private String key2;

    public Message(){};

    public Message(String title, String content, String message) {
        this.title = title;
        this.content = content;
        this.message = message;
    }

    public Message(String title, String content, String message, String key1, String key2) {
        this.title = title;
        this.content = content;
        this.message = message;
        this.key1 = key1;
        this.key2 = key2;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", message='" + message + '\'' +
                ", key1='" + key1 + '\'' +
                ", key2='" + key2 + '\'' +
                '}';
    }
}
