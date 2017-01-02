package com.scg.insvideoboard;

import com.scg.api.common.FormatDateSign;
import com.scg.api.common.LevelEval;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-09-21.
 */
public class InsVideoLikeVo {

    private int likeid;
    private int uid;
    private int videoid;
    private Date creationdate;

    private String username;
    private String userimage;
    private int totalscore;
    private int level;
    private String teamname;
    private String teamid;
    private String change_creationdate;
    private String formatDataSign;

    public InsVideoLikeVo(){}

    @Override
    public String toString() {
        return "InsVideoLikeVo{" +
                "likeid=" + likeid +
                ", uid=" + uid +
                ", videoid=" + videoid +
                ", creationdate=" + creationdate +
                ", username='" + username + '\'' +
                ", totalscore=" + totalscore +
                ", level=" + level +
                ", teamname='" + teamname + '\'' +
                ", teamid='" + teamid + '\'' +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", formatDataSign='" + formatDataSign + '\'' +
                '}';
    }

    public int getLikeid() {
        return likeid;
    }

    public void setLikeid(int likeid) {
        this.likeid = likeid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
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

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
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
}
