package com.scg.model.Common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-08-08.
 */
public class FavoriteMission {
    private int favoriteid;
    private int uid;
    private int missionid;
    private Date date;
    private String change_date;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;

    public FavoriteMission() {
    }

    public FavoriteMission(int favoriteid, int uid, int missionid, Date date, String change_date, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5) {
        this.favoriteid = favoriteid;
        this.uid = uid;
        this.missionid = missionid;
        this.date = date;
        this.change_date = change_date;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
    }

    public int getFavoriteid() {
        return favoriteid;
    }

    public void setFavoriteid(int favoriteid) {
        this.favoriteid = favoriteid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getMissionid() {
        return missionid;
    }

    public void setMissionid(int missionid) {
        this.missionid = missionid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getChange_date() {
        if(date != null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
            change_date = format.format(date);
            return change_date;
        }else{
            return change_date;
        }

    }

    public void setChange_date(String change_date) {
        this.change_date = change_date;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    @Override
    public String toString() {
        return "FavoriteMission{" +
                "favoriteid=" + favoriteid +
                ", uid=" + uid +
                ", missionid=" + missionid +
                ", date=" + date +
                ", change_date='" + change_date + '\'' +
                ", attribute1='" + attribute1 + '\'' +
                ", attribute2='" + attribute2 + '\'' +
                ", attribute3='" + attribute3 + '\'' +
                ", attribute4='" + attribute4 + '\'' +
                ", attribute5='" + attribute5 + '\'' +
                '}';
    }
}
