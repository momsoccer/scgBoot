package com.scg.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-06-11.
 */
public class SpBalanceLine {

    private int lineid;
    private int headerid;
    private String type;
    private String pointtypedisp;
    private int previousamount;
    private int inamount;
    private int outamount;
    private int lastamount;
    private String description;
    private int missionid;
    private int pointid;
    private int uid;
    private Date creationdate;
    private String change_creationdate;

    public SpBalanceLine(){}

    @Override
    public String toString() {
        return "SpBalanceLine{" +
                "lineid=" + lineid +
                ", headerid=" + headerid +
                ", type='" + type + '\'' +
                ", pointtypedisp='" + pointtypedisp + '\'' +
                ", previousamount=" + previousamount +
                ", inamount=" + inamount +
                ", outamount=" + outamount +
                ", lastamount=" + lastamount +
                ", description='" + description + '\'' +
                ", missionid=" + missionid +
                ", pointid=" + pointid +
                ", uid=" + uid +
                ", creationdate=" + creationdate +
                ", change_creationdate='" + change_creationdate + '\'' +
                '}';
    }

    public String getPointtypedisp() {
        return pointtypedisp;
    }

    public void setPointtypedisp(String pointtypedisp) {
        this.pointtypedisp = pointtypedisp;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getLineid() {
        return lineid;
    }

    public void setLineid(int lineid) {
        this.lineid = lineid;
    }

    public int getHeaderid() {
        return headerid;
    }

    public void setHeaderid(int headerid) {
        this.headerid = headerid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPreviousamount() {
        return previousamount;
    }

    public void setPreviousamount(int previousamount) {
        this.previousamount = previousamount;
    }

    public int getInamount() {
        return inamount;
    }

    public void setInamount(int inamount) {
        this.inamount = inamount;
    }

    public int getOutamount() {
        return outamount;
    }

    public void setOutamount(int outamount) {
        this.outamount = outamount;
    }

    public int getLastamount() {
        return lastamount;
    }

    public void setLastamount(int lastamount) {
        this.lastamount = lastamount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMissionid() {
        return missionid;
    }

    public void setMissionid(int missionid) {
        this.missionid = missionid;
    }

    public int getPointid() {
        return pointid;
    }

    public void setPointid(int pointid) {
        this.pointid = pointid;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getChange_creationdate() {
        if(creationdate != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
            change_creationdate = dateFormat.format(creationdate);
            return change_creationdate;
        }else{
            return change_creationdate;
        }
    }

    public void setChange_creationdate(String change_creationdate) {
        this.change_creationdate = change_creationdate;
    }
}
