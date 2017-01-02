package com.scg.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-06-20.
 */
public class FeedHistory {

    private int feedbackhistoryid;
    private int feedbackid;
    private int cashpoint;
    private int missionid;
    private int usermissionid;
    private int uid;
    private int frequency;
    private int instructorid;
    private Date creationdate;
    private String change_creationdate;

    public FeedHistory(){}

    public FeedHistory(int uid) {
        this.uid = uid;
    }

    public FeedHistory(int feedbackhistoryid, int feedbackid, int cashpoint, int missionid, int usermissionid, int uid, int frequency, int instructorid, Date creationdate, String change_creationdate) {
        this.feedbackhistoryid = feedbackhistoryid;
        this.feedbackid = feedbackid;
        this.cashpoint = cashpoint;
        this.missionid = missionid;
        this.usermissionid = usermissionid;
        this.uid = uid;
        this.frequency = frequency;
        this.instructorid = instructorid;
        this.creationdate = creationdate;
        this.change_creationdate = change_creationdate;
    }

    public int getFeedbackhistoryid() {
        return feedbackhistoryid;
    }

    public void setFeedbackhistoryid(int feedbackhistoryid) {
        this.feedbackhistoryid = feedbackhistoryid;
    }

    public int getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(int feedbackid) {
        this.feedbackid = feedbackid;
    }

    public int getCashpoint() {
        return cashpoint;
    }

    public void setCashpoint(int cashpoint) {
        this.cashpoint = cashpoint;
    }

    public int getMissionid() {
        return missionid;
    }

    public void setMissionid(int missionid) {
        this.missionid = missionid;
    }

    public int getUsermissionid() {
        return usermissionid;
    }

    public void setUsermissionid(int usermissionid) {
        this.usermissionid = usermissionid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getInstructorid() {
        return instructorid;
    }

    public void setInstructorid(int instructorid) {
        this.instructorid = instructorid;
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

    @Override
    public String toString() {
        return "FeedHistory{" +
                "feedbackhistoryid=" + feedbackhistoryid +
                ", feedbackid=" + feedbackid +
                ", cashpoint=" + cashpoint +
                ", missionid=" + missionid +
                ", usermissionid=" + usermissionid +
                ", uid=" + uid +
                ", frequency=" + frequency +
                ", instructorid=" + instructorid +
                ", creationdate=" + creationdate +
                ", change_creationdate='" + change_creationdate + '\'' +
                '}';
    }
}
