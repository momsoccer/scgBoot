package com.scg.model;

import com.scg.api.common.FormatDateSign;
import com.scg.api.common.LevelEval;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sungbo on 2016-09-08.
 * 라인 및 헤더를 동시에 사용하는 Vo
 * */
public class MomBoard {

    //header
    private int boardid;
    private int uid;
    private String boardtype;
    private String subject;
    private String content;
    private Date creationdate;
    private Date updatedate;
    private int boardtypeid;
    private String pubtype;
    private String change_creationdate;
    private String formatDataSign;
    private String change_updatedate;
    private String category;
    private String youtubeaddr;

    //line
    private int lineid;
    private int likeid;
    private int fileid;
    private String filename;
    private String fileaddr;

    //nonDb
    private String username;
    private String userimg;
    private int level;
    private int totalscore;
    private int teamid;
    private String teamname;

    private int commentcount;
    private int likecount;

    private int limit;
    private int offset;
    private int pagenum;
    private int filecount;

    public String getYoutubeaddr() {
        return youtubeaddr;
    }

    public void setYoutubeaddr(String youtubeaddr) {
        this.youtubeaddr = youtubeaddr;
    }

    public int getFilecount() {
        return filecount;
    }

    public void setFilecount(int filecount) {
        this.filecount = filecount;
    }

    private List<MomBoardFile> boardFiles;

    public List<MomBoardFile> getBoardFiles() {
        return boardFiles;
    }

    public void setBoardFiles(List<MomBoardFile> boardFiles) {
        this.boardFiles = boardFiles;
    }

    public MomBoard(){}


    @Override
    public String toString() {
        return "MomBoard{" +
                "boardid=" + boardid +
                ", uid=" + uid +
                ", boardtype='" + boardtype + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", creationdate=" + creationdate +
                ", updatedate=" + updatedate +
                ", boardtypeid=" + boardtypeid +
                ", pubtype='" + pubtype + '\'' +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", change_updatedate='" + change_updatedate + '\'' +
                ", formatDataSign='" + formatDataSign + '\'' +
                ", category='" + category + '\'' +
                ", lineid=" + lineid +
                ", likeid=" + likeid +
                ", fileid=" + fileid +
                ", filename='" + filename + '\'' +
                ", fileaddr='" + fileaddr + '\'' +
                ", username='" + username + '\'' +
                ", userimg='" + userimg + '\'' +
                ", level=" + level +
                ", totalscore=" + totalscore +
                ", teamid=" + teamid +
                ", teamname='" + teamname + '\'' +
                ", commentcount=" + commentcount +
                ", likecount=" + likecount +
                ", limit=" + limit +
                ", offset=" + offset +
                ", pagenum=" + pagenum +
                '}';
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
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
            change_updatedate = dateFormat.format(updatedate);
            return change_updatedate;
        }else{
            return change_updatedate;
        }
    }

    public void setChange_updatedate(String change_updatedate) {
        this.change_updatedate = change_updatedate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getFormatDataSign() {
        return FormatDateSign.formatTimeString(creationdate);
    }

    public void setFormatDataSign(String formatDataSign) {
        this.formatDataSign = formatDataSign;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public int getBoardid() {
        return boardid;
    }

    public void setBoardid(int boardid) {
        this.boardid = boardid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getBoardtype() {
        return boardtype;
    }

    public void setBoardtype(String boardtype) {
        this.boardtype = boardtype;
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

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public int getBoardtypeid() {
        return boardtypeid;
    }

    public void setBoardtypeid(int boardtypeid) {
        this.boardtypeid = boardtypeid;
    }

    public String getPubtype() {
        return pubtype;
    }

    public void setPubtype(String pubtype) {
        this.pubtype = pubtype;
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

    public int getLineid() {
        return lineid;
    }

    public void setLineid(int lineid) {
        this.lineid = lineid;
    }

    public int getLikeid() {
        return likeid;
    }

    public void setLikeid(int likeid) {
        this.likeid = likeid;
    }

    public int getFileid() {
        return fileid;
    }

    public void setFileid(int fileid) {
        this.fileid = fileid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileaddr() {
        return fileaddr;
    }

    public void setFileaddr(String fileaddr) {
        this.fileaddr = fileaddr;
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

    public int getLevel() {
        LevelEval levelEval = new LevelEval(totalscore);

        return levelEval.levelEvalMethod();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }
}
