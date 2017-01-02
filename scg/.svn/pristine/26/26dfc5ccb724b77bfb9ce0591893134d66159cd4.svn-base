package com.scg.insvideoboard;

import com.scg.api.common.FormatDateSign;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-09-21.
 */
public class InsVideoVo {

    private int videoid;
    private int instructorid;
    private int teamid;
    private String subject;
    private String content;
    private String youtubeaddr;
    private Date creationdate;
    private int likecount;
    private int commentcount;
    private String filename;

    //nonDb
    private String insname;
    private String insimage;
    private String teamname;
    private String change_creationdate;
    private String formatDataSign;
    private int filecount;
    private int linecount;

    //painig
    private int limit;
    private int offset;

    public InsVideoVo() {}

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLinecount() {
        return linecount;
    }

    public void setLinecount(int linecount) {
        this.linecount = linecount;
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

    public String getInsimage() {
        return insimage;
    }

    public void setInsimage(String insimage) {
        this.insimage = insimage;
    }

    @Override
    public String toString() {
        return "InsVideoVo{" +
                "videoid=" + videoid +
                ", instructorid=" + instructorid +
                ", teamid=" + teamid +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", youtubeaddr='" + youtubeaddr + '\'' +
                ", creationdate=" + creationdate +
                ", likecount=" + likecount +
                ", insname='" + insname + '\'' +
                ", insimage='" + insimage + '\'' +
                ", teamname='" + teamname + '\'' +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", formatDataSign='" + formatDataSign + '\'' +
                ", filecount=" + filecount +
                ", limit=" + limit +
                ", offset=" + offset +
                '}';
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    public int getInstructorid() {
        return instructorid;
    }

    public void setInstructorid(int instructorid) {
        this.instructorid = instructorid;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
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

    public String getInsname() {
        return insname;
    }

    public void setInsname(String insname) {
        this.insname = insname;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
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

    public int getFilecount() {
        return filecount;
    }

    public void setFilecount(int filecount) {
        this.filecount = filecount;
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
}
