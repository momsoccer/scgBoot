package com.scg.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-06-01.
 */
public class Instructor {

    private int instructorid;
    private String email;
    private String password;
    private String name;
    private String profileimgurl;
    private String profile;
    private String description;
    private String phone;
    private int location;
    private int pointhistoryid;
    private String feedbackflag;
    private String apppushflag;
    private int commontokenid;
    private String serialnumber;
    private String fcmtoken;
    private Date creationdate;
    private String change_creationdate;
    private int uid;
    private String teamname;
    private String emblem;
    private Date teamcreationdate;
    private String change_teamcreationdate;
    private int teamid;

    private int membercount;
    private int totalscore;

    private int queryRow;
    private String orderbytype;  // 대량목록 조회시 sort 순서 해당 컬럼에 한해서 사용

    public Instructor(){}

    public int getMembercount() {
        return membercount;
    }

    public void setMembercount(int membercount) {
        this.membercount = membercount;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }

    public int getQueryRow() {
        return queryRow;
    }

    public void setQueryRow(int queryRow) {
        this.queryRow = queryRow;
    }

    public String getOrderbytype() {
        return orderbytype;
    }

    public void setOrderbytype(String orderbytype) {
        this.orderbytype = orderbytype;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }


    public int getPointhistoryid() {
        return pointhistoryid;
    }

    public void setPointhistoryid(int pointhistoryid) {
        this.pointhistoryid = pointhistoryid;
    }

    public String getFeedbackflag() {
        return feedbackflag;
    }

    public void setFeedbackflag(String feedbackflag) {
        this.feedbackflag = feedbackflag;
    }

    public String getApppushflag() {
        return apppushflag;
    }

    public void setApppushflag(String apppushflag) {
        this.apppushflag = apppushflag;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCommontokenid() {
        return commontokenid;
    }

    public void setCommontokenid(int commontokenid) {
        this.commontokenid = commontokenid;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getFcmtoken() {
        return fcmtoken;
    }

    public void setFcmtoken(String fcmtoken) {
        this.fcmtoken = fcmtoken;
    }

    public String getProfileimgurl() {
        return profileimgurl;
    }

    public void setProfileimgurl(String profileimgurl) {
        this.profileimgurl = profileimgurl;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public Date getTeamcreationdate() {
        return teamcreationdate;
    }

    public void setTeamcreationdate(Date teamcreationdate) {
        this.teamcreationdate = teamcreationdate;
    }

    public String getChange_teamcreationdate() {

        if(teamcreationdate != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
            change_creationdate = dateFormat.format(teamcreationdate);
            return change_teamcreationdate;
        }else{
            return change_teamcreationdate;
        }

    }

    public void setChange_teamcreationdate(String change_teamcreationdate) {
        this.change_teamcreationdate = change_teamcreationdate;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorid=" + instructorid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", profileimgurl='" + profileimgurl + '\'' +
                ", profile='" + profile + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", location=" + location +
                ", pointhistoryid=" + pointhistoryid +
                ", feedbackflag='" + feedbackflag + '\'' +
                ", apppushflag='" + apppushflag + '\'' +
                ", commontokenid=" + commontokenid +
                ", serialnumber='" + serialnumber + '\'' +
                ", fcmtoken='" + fcmtoken + '\'' +
                ", creationdate=" + creationdate +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", uid=" + uid +
                ", teamname='" + teamname + '\'' +
                ", emblem='" + emblem + '\'' +
                ", teamcreationdate=" + teamcreationdate +
                ", change_teamcreationdate='" + change_teamcreationdate + '\'' +
                ", teamid=" + teamid +
                ", membercount=" + membercount +
                ", totalscore=" + totalscore +
                ", queryRow=" + queryRow +
                ", orderbytype='" + orderbytype + '\'' +
                '}';
    }
}
