package com.scg.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-06-15.
 */
public class InstructorPointHistory {

    private int  pointhistoryid;
    private int  instructorid;
    private int  teamvideopoint;
    private int  teamwordpoint;
    private int  pubvideopoint;
    private int  pubwordpoint;
    private int  teamjoinpoint;

    private int  pubpasspoint;
    private int  teampasspoint;

    private Date creationdate;
    private Date updatedate;
    private String change_creationdate;
    private String change_updatedate;

    public InstructorPointHistory(){}

    public int getPubpasspoint() {
        return pubpasspoint;
    }

    public void setPubpasspoint(int pubpasspoint) {
        this.pubpasspoint = pubpasspoint;
    }

    public int getTeampasspoint() {
        return teampasspoint;
    }

    public void setTeampasspoint(int teampasspoint) {
        this.teampasspoint = teampasspoint;
    }

    public int getTeamjoinpoint() {
        return teamjoinpoint;
    }

    public void setTeamjoinpoint(int teamjoinpoint) {
        this.teamjoinpoint = teamjoinpoint;
    }

    public int getPointhistoryid() {
        return pointhistoryid;
    }

    public void setPointhistoryid(int pointhistoryid) {
        this.pointhistoryid = pointhistoryid;
    }

    public int getInstructorid() {
        return instructorid;
    }

    public void setInstructorid(int instructorid) {
        this.instructorid = instructorid;
    }

    public int getTeamvideopoint() {
        return teamvideopoint;
    }

    public void setTeamvideopoint(int teamvideopoint) {
        this.teamvideopoint = teamvideopoint;
    }

    public int getTeamwordpoint() {
        return teamwordpoint;
    }

    public void setTeamwordpoint(int teamwordpoint) {
        this.teamwordpoint = teamwordpoint;
    }

    public int getPubvideopoint() {
        return pubvideopoint;
    }

    public void setPubvideopoint(int pubvideopoint) {
        this.pubvideopoint = pubvideopoint;
    }

    public int getPubwordpoint() {
        return pubwordpoint;
    }

    public void setPubwordpoint(int pubwordpoint) {
        this.pubwordpoint = pubwordpoint;
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

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getChange_updatedate() {
        if(updatedate != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
            change_updatedate= dateFormat.format(updatedate);
            return change_updatedate;
        }else{
            return change_updatedate;
        }
    }

    public void setChange_updatedate(String change_updatedate) {
        this.change_updatedate = change_updatedate;
    }

    @Override
    public String toString() {
        return "InstructorPointHistory{" +
                "pointhistoryid=" + pointhistoryid +
                ", instructorid=" + instructorid +
                ", teamvideopoint=" + teamvideopoint +
                ", teamwordpoint=" + teamwordpoint +
                ", pubvideopoint=" + pubvideopoint +
                ", pubwordpoint=" + pubwordpoint +
                ", teamjoinpoint=" + teamjoinpoint +
                ", creationdate=" + creationdate +
                ", updatedate=" + updatedate +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", change_updatedate='" + change_updatedate + '\'' +
                '}';
    }
}
