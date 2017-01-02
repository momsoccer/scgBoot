package com.scg.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-06-23.
 */
public class UserMissionEval {

    private int evalid;
    private int usermissionid;
    private int uid;
    private int instructorid;
    private String coment;
    private int  score;
    private Date creationdate;
    private String change_creationdate;

    //dbflag
    private String queryflag;

    public UserMissionEval(){}



    public int getEvalid() {
        return evalid;
    }

    public void setEvalid(int evalid) {
        this.evalid = evalid;
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

    public int getInstructorid() {
        return instructorid;
    }

    public void setInstructorid(int instructorid) {
        this.instructorid = instructorid;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public String getQueryflag() {
        return queryflag;
    }

    public void setQueryflag(String queryflag) {
        this.queryflag = queryflag;
    }
}
