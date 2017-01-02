package com.scg.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-06-24.
 */
public class Team {
    private int teamid;
    private int instructorid;
    private String name;
    private String emblem;
    private String description;
    private String enabled;
    private String approveflag;
    private String instructorname;
    private Date creationdate;
    private Date updatedate;
    private String insname;
    private String insimg;

    private String change_creationdate;
    private String change_updatedate;

    public Team(){}



    public String getInsname() {
        return insname;
    }

    public void setInsname(String insname) {
        this.insname = insname;
    }

    public String getInsimg() {
        return insimg;
    }

    public void setInsimg(String insimg) {
        this.insimg = insimg;
    }

    public String getInstructorname() {
        return instructorname;
    }

    public void setInstructorname(String instructorname) {
        this.instructorname = instructorname;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }

    public int getInstructorid() {
        return instructorid;
    }

    public void setInstructorid(int instructorid) {
        this.instructorid = instructorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
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

    public String getChange_updatedate() {
        if(creationdate != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
            change_updatedate = dateFormat.format(updatedate);
            return change_updatedate;
        }else{
            return change_updatedate;
        }
    }

    public void setChange_updatedate(String change_updatedate) {
        this.change_updatedate = change_updatedate;
    }

    public String getApproveflag() {
        return approveflag;
    }

    public void setApproveflag(String approveflag) {
        this.approveflag = approveflag;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamid=" + teamid +
                ", instructorid=" + instructorid +
                ", name='" + name + '\'' +
                ", emblem='" + emblem + '\'' +
                ", description='" + description + '\'' +
                ", enabled='" + enabled + '\'' +
                ", approveflag='" + approveflag + '\'' +
                ", instructorname='" + instructorname + '\'' +
                ", creationdate=" + creationdate +
                ", updatedate=" + updatedate +
                ", insname='" + insname + '\'' +
                ", insimg='" + insimg + '\'' +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", change_updatedate='" + change_updatedate + '\'' +
                '}';
    }
}
