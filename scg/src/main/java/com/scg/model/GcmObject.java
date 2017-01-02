package com.scg.model;

/**
 * Created by KIMU on 2016. 6. 30..
 */
public class GcmObject {
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Message getData() {
        return data;
    }

    public void setData(Message data) {
        this.data = data;
    }

    private String to;
    private Message data;

    public GcmObject(String to,Message data) {
        this.to = to;
        this.data = data;
    }
}
