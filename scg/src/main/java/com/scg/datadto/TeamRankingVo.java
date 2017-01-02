package com.scg.datadto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-09-11.
 */
public class TeamRankingVo {

    private String teamname;
    private int teamid;
    private int instructorid;
    private String emblem;
    private String insimg;
    private String insname;
    private Date creationdate;
    private int totalscore;
    private String change_creationdate;
    private int querycount;

    public TeamRankingVo(){}

    public int getQuerycount() {
        return querycount;
    }

    public void setQuerycount(int querycount) {
        this.querycount = querycount;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
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

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public String getInsimg() {
        return insimg;
    }

    public void setInsimg(String insimg) {
        this.insimg = insimg;
    }

    public String getInsname() {
        return insname;
    }

    public void setInsname(String insname) {
        this.insname = insname;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }

    public String getChange_creationdate() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        change_creationdate = dateFormat.format(creationdate);
        return change_creationdate;
    }

    public void setChange_creationdate(String change_creationdate) {
        this.change_creationdate = change_creationdate;
    }

    @Override
    public String toString() {
        return "TeamRankingVo{" +
                "teamname='" + teamname + '\'' +
                ", teamid=" + teamid +
                ", instructorid=" + instructorid +
                ", emblem='" + emblem + '\'' +
                ", insimg='" + insimg + '\'' +
                ", insname='" + insname + '\'' +
                ", creationdate=" + creationdate +
                ", totalscore=" + totalscore +
                ", change_creationdate='" + change_creationdate + '\'' +
                '}';
    }
}
