package com.scg.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-06-16.
 */
public class UserDailyHistory {

    private int dailyhistoryid;
    private int uid;
    private String description;
    private String yyyymmdd;
    private Date creationdate;
    private String change_creationdate;
    private String result;

    //출첵 확인 메서드


    public UserDailyHistory(){}

    public UserDailyHistory(int dailyhistoryid, int uid, String description, String yyyymmdd, Date creationdate, String change_creationdate, String result) {
        this.dailyhistoryid = dailyhistoryid;
        this.uid = uid;
        this.description = description;
        this.yyyymmdd = yyyymmdd;
        this.creationdate = creationdate;
        this.change_creationdate = change_creationdate;
        this.result = result;
    }

    public int getDailyhistoryid() {
        return dailyhistoryid;
    }

    public void setDailyhistoryid(int dailyhistoryid) {
        this.dailyhistoryid = dailyhistoryid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYyyymmdd() {
        return yyyymmdd;
    }

    public void setYyyymmdd(String yyyymmdd) {
        this.yyyymmdd = yyyymmdd;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
