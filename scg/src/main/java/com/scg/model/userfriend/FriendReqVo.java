package com.scg.model.userfriend;

import com.scg.api.common.LevelEval;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-07-12.
 * 친구요청 및 친구 정보 관련 DTO
 */
public class FriendReqVo {

    private int applyid;
    private int uid;
    //use query
    private String username;
    private String teamname;
    private int usermissioncount;
    private int score;
    private int followercount;
    private int followingcount;

    private int mecommentcount;
    private int commentcount;
    private int level;
    private String profileimgurl;
    private Date creationdate;
    private String change_creationdate;
    private String flag;

    public FriendReqVo(){}

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getApplyid() {
        return applyid;
    }

    public void setApplyid(int applyid) {
        this.applyid = applyid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public int getUsermissioncount() {
        return usermissioncount;
    }

    public void setUsermissioncount(int usermissioncount) {
        this.usermissioncount = usermissioncount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFollowercount() {
        return followercount;
    }

    public void setFollowercount(int followercount) {
        this.followercount = followercount;
    }

    public int getFollowingcount() {
        return followingcount;
    }

    public void setFollowingcount(int followingcount) {
        this.followingcount = followingcount;
    }

    public int getMecommentcount() {
        return mecommentcount;
    }

    public void setMecommentcount(int mecommentcount) {
        this.mecommentcount = mecommentcount;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }

    public int getLevel() {
        LevelEval v = new LevelEval(score);
        return v.levelEvalMethod();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getProfileimgurl() {
        return profileimgurl;
    }

    public void setProfileimgurl(String profileimgurl) {
        this.profileimgurl = profileimgurl;
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
