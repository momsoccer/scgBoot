package com.scg.model;

import com.scg.api.common.FormatDateSign;
import com.scg.api.common.LevelEval;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-08-01.
 */
public class Board {

    private int boardid;
    private int usermissionid;
    private int uid;
    private int writeuid;
    private String username;
    private String teamname;
    private String profileimgurl;
    private String comment;
    private Date creationdate;
    private Date updatedate;
    private String change_creationdate;
    private String change_updatedate;
    private int totalscore;
    private int level;
    private String formatDataSign;

    private String missiontype;

    public Board(){}

    public String getMissiontype() {
        return missiontype;
    }

    public void setMissiontype(String missiontype) {
        this.missiontype = missiontype;
    }

    public String getFormatDataSign() {
          return FormatDateSign.formatTimeString(creationdate);
    }

    public void setFormatDataSign(String formatDataSign) {
        this.formatDataSign = formatDataSign;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }

    public int getLevel() {
        LevelEval levelEval = new LevelEval(totalscore);
        return levelEval.levelEvalMethod();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public int getBoardid() {
        return boardid;
    }

    public void setBoardid(int boardid) {
        this.boardid = boardid;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileimgurl() {
        return profileimgurl;
    }

    public void setProfileimgurl(String profileimgurl) {
        this.profileimgurl = profileimgurl;
    }

    public int getWriteuid() {
        return writeuid;
    }

    public void setWriteuid(int writeuid) {
        this.writeuid = writeuid;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardid=" + boardid +
                ", usermissionid=" + usermissionid +
                ", uid=" + uid +
                ", writeuid=" + writeuid +
                ", username='" + username + '\'' +
                ", teamname='" + teamname + '\'' +
                ", profileimgurl='" + profileimgurl + '\'' +
                ", comment='" + comment + '\'' +
                ", creationdate=" + creationdate +
                ", updatedate=" + updatedate +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", change_updatedate='" + change_updatedate + '\'' +
                '}';
    }
}
