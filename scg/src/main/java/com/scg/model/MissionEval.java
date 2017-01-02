package com.scg.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-06-21.
 * 시드 미션에 대해 유저들이 평가를 한다.
 * 일정을 잡아 점수가 낮거나 어려운 미션들을 조절한다
 */
public class MissionEval {

    private int evalid;
    private int missionid;
    private int uid;
    private String comment;
    private int userscore;
    private Date creationdate;
    private String change_creationdate;

    public MissionEval(){}

    public MissionEval(int evalid, int missionid, int uid, String comment, int userscore, Date creationdate, String change_creationdate) {
        this.evalid = evalid;
        this.missionid = missionid;
        this.uid = uid;
        this.comment = comment;
        this.userscore = userscore;
        this.creationdate = creationdate;
        this.change_creationdate = change_creationdate;
    }

    public int getEvalid() {
        return evalid;
    }

    public void setEvalid(int evalid) {
        this.evalid = evalid;
    }

    public int getMissionid() {
        return missionid;
    }

    public void setMissionid(int missionid) {
        this.missionid = missionid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserscore() {
        return userscore;
    }

    public void setUserscore(int userscore) {
        this.userscore = userscore;
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
