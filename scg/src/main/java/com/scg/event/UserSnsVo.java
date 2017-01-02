package com.scg.event;

import java.util.Map;

/**
 * Created by sungbo on 2016-11-22.
 */
public class UserSnsVo {

    private String id;
    private Map<String,String> properties;

    public UserSnsVo(){};

    public UserSnsVo(String id, Map<String, String> properties) {
        this.id = id;
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "UserSnsVo{" +
                "id='" + id + '\'' +
                ", properties=" + properties +
                '}';
    }
}
