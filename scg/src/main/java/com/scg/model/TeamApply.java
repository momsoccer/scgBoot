package com.scg.model;

import com.scg.api.common.LevelEval;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-06-24.
 */
public class TeamApply {

    private int applyid;
    private int teamid;
    private int instructorid;
    private int uid;
    private String description;
    private String approval;
    private String enabled;
    private String reply;
    private String username;
    private String teamname;
    private Date creationdate;
    private Date updatedate;
    private String change_creationdate;
    private String change_updatedate;

    private int totalscore;
    private int level;
    private String userimge;

    public String getUserimge() {
        return userimge;
    }

    public void setUserimge(String userimge) {
        this.userimge = userimge;
    }

    public TeamApply(){}

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

    @Override
    public String toString() {
        return "TeamApply{" +
                "applyid=" + applyid +
                ", teamid=" + teamid +
                ", instructorid=" + instructorid +
                ", uid=" + uid +
                ", description='" + description + '\'' +
                ", approval='" + approval + '\'' +
                ", enabled='" + enabled + '\'' +
                ", reply='" + reply + '\'' +
                ", username='" + username + '\'' +
                ", teamname='" + teamname + '\'' +
                ", creationdate=" + creationdate +
                ", updatedate=" + updatedate +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", change_updatedate='" + change_updatedate + '\'' +
                '}';
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public int getApplyid() {
        return applyid;
    }

    public void setApplyid(int applyid) {
        this.applyid = applyid;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
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

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
