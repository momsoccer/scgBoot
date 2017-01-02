package com.scg.model;

import com.scg.api.common.LevelEval;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-08-29.
 */
public class MissionPass {

    private int passid;
    private int seq;
    private int uid;
    private int instructorid;

    private int missionid;
    private int usermissionid;

    private String status;
    private String passflag;
    private String failuredisp;
    private String inscomment;

    private Date creationdate;
    private Date updatedate;

    private String change_creationdate;
    private String change_updatedate;

    private String evaltype;
    private int cashpoint;
    private String missiontype;

    //non DB
    private String insname;
    private String username;
    private String insimge;
    private String userimge;
    private String passgrade;
    private String missionPassFlag;
    private String teamname;
    private String missionname;
    private int totalscore;
    private int level;
    private String uservideo;
    private String missionvideo;

    public MissionPass(){}

    @Override
    public String toString() {
        return "MissionPass{" +
                "passid=" + passid +
                ", seq=" + seq +
                ", uid=" + uid +
                ", instructorid=" + instructorid +
                ", missionid=" + missionid +
                ", usermissionid=" + usermissionid +
                ", status='" + status + '\'' +
                ", passflag='" + passflag + '\'' +
                ", failuredisp='" + failuredisp + '\'' +
                ", inscomment='" + inscomment + '\'' +
                ", creationdate=" + creationdate +
                ", updatedate=" + updatedate +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", change_updatedate='" + change_updatedate + '\'' +
                ", evaltype='" + evaltype + '\'' +
                ", cashpoint=" + cashpoint +
                ", insname='" + insname + '\'' +
                ", username='" + username + '\'' +
                ", insimge='" + insimge + '\'' +
                ", userimge='" + userimge + '\'' +
                ", passgrade='" + passgrade + '\'' +
                ", missionPassFlag='" + missionPassFlag + '\'' +
                '}';
    }

    public String getMissiontype() {
        return missiontype;
    }

    public void setMissiontype(String missiontype) {
        this.missiontype = missiontype;
    }

    public String getUservideo() {
        return uservideo;
    }

    public void setUservideo(String uservideo) {
        this.uservideo = uservideo;
    }

    public String getMissionvideo() {
        return missionvideo;
    }

    public void setMissionvideo(String missionvideo) {
        this.missionvideo = missionvideo;
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

    public String getMissionname() {
        return missionname;
    }

    public void setMissionname(String missionname) {
        this.missionname = missionname;
    }

    public String getMissionPassFlag() {
        return missionPassFlag;
    }

    public void setMissionPassFlag(String missionPassFlag) {
        this.missionPassFlag = missionPassFlag;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getEvaltype() {
        return evaltype;
    }

    public int getCashpoint() {
        return cashpoint;
    }

    public void setCashpoint(int cashpoint) {
        this.cashpoint = cashpoint;
    }

    public void setEvaltype(String evaltype) {
        this.evaltype = evaltype;
    }

    public String getPassgrade() {
        return passgrade;
    }

    public void setPassgrade(String passgrade) {
        this.passgrade = passgrade;
    }

    public String getInsname() {
        return insname;
    }

    public void setInsname(String insname) {
        this.insname = insname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInsimge() {
        return insimge;
    }

    public void setInsimge(String insimge) {
        this.insimge = insimge;
    }

    public String getUserimge() {
        return userimge;
    }

    public void setUserimge(String userimge) {
        this.userimge = userimge;
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

    public int getMissionid() {
        return missionid;
    }

    public void setMissionid(int missionid) {
        this.missionid = missionid;
    }

    public int getUsermissionid() {
        return usermissionid;
    }

    public void setUsermissionid(int usermissionid) {
        this.usermissionid = usermissionid;
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

    public String getFailuredisp() {
        return failuredisp;
    }

    public void setFailuredisp(String failuredisp) {
        this.failuredisp = failuredisp;
    }

    public String getInscomment() {
        return inscomment;
    }

    public void setInscomment(String inscomment) {
        this.inscomment = inscomment;
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
}
