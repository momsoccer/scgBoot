package com.scg.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-09-11.
 * 신고하기 테이블 및 Vo
 */
public class Report {

    private int id;
    private String type;
    private String reason;
    private int uid;
    private int publisherid;
    private String content;
    private Date creationdate;
    private String flag;  //지급플래그
    private String change_creationdate;
    //Non DB
    private String username;  //신고한 사람
    private String publisheruser; //신고당한 사람
    private String uploadcount;
    private String pointcount;

    private String teamname;


    public Report(){}

    public String getUploadcount() {
        return uploadcount;
    }

    public void setUploadcount(String uploadcount) {
        this.uploadcount = uploadcount;
    }

    public String getPointcount() {
        return pointcount;
    }

    public void setPointcount(String pointcount) {
        this.pointcount = pointcount;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", reason='" + reason + '\'' +
                ", uid=" + uid +
                ", publisherid=" + publisherid +
                ", content='" + content + '\'' +
                ", creationdate=" + creationdate +
                ", flag='" + flag + '\'' +
                ", username='" + username + '\'' +
                ", publisheruser='" + publisheruser + '\'' +
                '}';
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPublisheruser() {
        return publisheruser;
    }

    public void setPublisheruser(String publisheruser) {
        this.publisheruser = publisheruser;
    }
}
