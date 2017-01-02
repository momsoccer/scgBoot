package com.scg.model;

/**
 * Created by sungbo on 2016-06-16.
 */
public class PointManagement {

    private int pointid;
    private String typecode;
    private String typedescription;
    private int point;
    private String lang;
    private String enabled;
    private String sign;
    private int missionid;
    private int getpoint;
    private int escapepoint;

    public PointManagement(){}

    public int getPointid() {
        return pointid;
    }

    public void setPointid(int pointid) {
        this.pointid = pointid;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypedescription() {
        return typedescription;
    }

    public void setTypedescription(String typedescription) {
        this.typedescription = typedescription;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getMissionid() {
        return missionid;
    }

    public void setMissionid(int missionid) {
        this.missionid = missionid;
    }

    public int getGetpoint() {
        return getpoint;
    }

    public void setGetpoint(int getpoint) {
        this.getpoint = getpoint;
    }

    public int getEscapepoint() {
        return escapepoint;
    }

    public void setEscapepoint(int escapepoint) {
        this.escapepoint = escapepoint;
    }
}
