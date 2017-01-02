package com.scg.wep.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-11-21.
 */
public class MissionPassVo {

    private String teamname;
    private String username;
    private String missiontypename;
    private String missionname;
    private String description;
    private String precon;
    private String videoaddr;
    private String youtubeaddr;
    private String inscomment;
    private String failuredisp;
    private String status;
    private String passflag;
    private int usermissionid;
    private String useryoutubeaddr;
    private String uservideoaddr;
    private int passid;
    private int seq;
    private Date creationdate;
    private String change_creationdate;
    private int uid;
    private int missionid;

    public String getFailuredisp() {
        return failuredisp;
    }

    public void setFailuredisp(String failuredisp) {
        this.failuredisp = failuredisp;
    }

    public int getMissionid() {
        return missionid;
    }

    public void setMissionid(int missionid) {
        this.missionid = missionid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMissiontypename() {
        return missiontypename;
    }

    public void setMissiontypename(String missiontypename) {
        this.missiontypename = missiontypename;
    }

    public String getMissionname() {
        return missionname;
    }

    public void setMissionname(String missionname) {
        this.missionname = missionname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrecon() {
        return precon;
    }

    public void setPrecon(String precon) {
        this.precon = precon;
    }

    public String getVideoaddr() {
        return videoaddr;
    }

    public void setVideoaddr(String videoaddr) {
        this.videoaddr = videoaddr;
    }

    public String getYoutubeaddr() {
        return youtubeaddr;
    }

    public void setYoutubeaddr(String youtubeaddr) {
        this.youtubeaddr = youtubeaddr;
    }

    public String getInscomment() {
        return inscomment;
    }

    public void setInscomment(String inscomment) {
        this.inscomment = inscomment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassflag() {
        return passflag;
    }

    public void setPassflag(String passflag) {
        this.passflag = passflag;
    }

    public int getUsermissionid() {
        return usermissionid;
    }

    public void setUsermissionid(int usermissionid) {
        this.usermissionid = usermissionid;
    }

    public String getUseryoutubeaddr() {
        return useryoutubeaddr;
    }

    public void setUseryoutubeaddr(String useryoutubeaddr) {
        this.useryoutubeaddr = useryoutubeaddr;
    }

    public String getUservideoaddr() {
        return uservideoaddr;
    }

    public void setUservideoaddr(String uservideoaddr) {
        this.uservideoaddr = uservideoaddr;
    }

    public int getPassid() {
        return passid;
    }

    public void setPassid(int passid) {
        this.passid = passid;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
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
