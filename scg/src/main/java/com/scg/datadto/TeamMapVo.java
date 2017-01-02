package com.scg.datadto;

/**
 * Created by sungbo on 2016-08-16.
 */
public class TeamMapVo {

    private int count;
    private String type;

    public TeamMapVo(){}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TeamMapVo{" +
                "count=" + count +
                ", type='" + type + '\'' +
                '}';
    }
}
