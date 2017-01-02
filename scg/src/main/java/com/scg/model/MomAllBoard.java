package com.scg.model;

import com.scg.api.common.FormatDateSign;
import com.scg.api.common.LevelEval;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sungbo on 2016-09-18.
 */
public class MomAllBoard {

    private int allboardid;
    private int uid;
    private String insflag;
    private String subject;
    private String content;
    private String youtubeaddr;
    private Date creationdate;
    private String change_creationdate;
    private String formatDataSign;

    private String username;
    private String userimg;

    private int totalscore;
    private int level;

    private List<MomBoardFile> boardFiles;


    @Override
    public String toString() {
        return "MomAllBoard{" +
                "allboardid=" + allboardid +
                ", uid=" + uid +
                ", insflag='" + insflag + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", youtubeaddr='" + youtubeaddr + '\'' +
                ", creationdate=" + creationdate +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", formatDataSign='" + formatDataSign + '\'' +
                ", username='" + username + '\'' +
                ", userimg='" + userimg + '\'' +
                ", totalscore=" + totalscore +
                ", level=" + level +
                ", boardFiles=" + boardFiles +
                '}';
    }

    public int getAllboardid() {
        return allboardid;
    }

    public void setAllboardid(int allboardid) {
        this.allboardid = allboardid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getInsflag() {
        return insflag;
    }

    public void setInsflag(String insflag) {
        this.insflag = insflag;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getYoutubeaddr() {
        return youtubeaddr;
    }

    public void setYoutubeaddr(String youtubeaddr) {
        this.youtubeaddr = youtubeaddr;
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

    public String getFormatDataSign() {
        return FormatDateSign.formatTimeString(creationdate);
    }

    public void setFormatDataSign(String formatDataSign) {
        this.formatDataSign = formatDataSign;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
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

    public List<MomBoardFile> getBoardFiles() {
        return boardFiles;
    }

    public void setBoardFiles(List<MomBoardFile> boardFiles) {
        this.boardFiles = boardFiles;
    }
}
