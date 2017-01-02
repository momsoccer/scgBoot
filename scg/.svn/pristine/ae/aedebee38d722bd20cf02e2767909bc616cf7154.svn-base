package com.scg.model.Common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-08-08.
 */
public class MissionHistory {

    private int historyid;
    private int uid;
    private int missionid;
    private int escapepoint;
    private String change_date;
    private Date date;
    private String opentype;

    public MissionHistory() {
    }

    public int getHistoryid() {
        return historyid;
    }

    public void setHistoryid(int historyid) {
        this.historyid = historyid;
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

    public int getEscapepoint() {
        return escapepoint;
    }

    public void setEscapepoint(int escapepoint) {
        this.escapepoint = escapepoint;
    }

    public String getChange_date() {
        if(date != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
            change_date = dateFormat.format(date);
            return change_date;
        }else{
            return change_date;
        }
    }

    public void setChange_date(String change_date) {
        this.change_date = change_date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOpentype() {
        return opentype;
    }

    public void setOpentype(String opentype) {
        this.opentype = opentype;
    }
}
