package com.scg.model.Common;

import java.util.Date;

/**
 * Created by sungbo on 2016-08-14.
 */
public class Mominfo {

    private int id;
    private String subject;
    private String type;
    private String content;
    private Date date;
    private String enabled;

    Mominfo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Mominfo{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", enabled='" + enabled + '\'' +
                '}';
    }
}
