package com.scg.model;

import com.scg.api.common.FormatDateSign;
import com.scg.api.common.LevelEval;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-07-30.
 */
public class MyBookMark {

    private int bookid;
    private int uid;
    private int usermissionid;
    private Date creationdate;
    private String change_creationdate;
    private int level;
    private String username;
    private String userimge;
    private int totalscore;
    private String formatDataSign;
    private String teamname;

    public MyBookMark(){}

    public MyBookMark(int bookid, int uid, int usermissionid) {
        this.bookid = bookid;
        this.uid = uid;
        this.usermissionid = usermissionid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUsermissionid() {
        return usermissionid;
    }

    public void setUsermissionid(int usermissionid) {
        this.usermissionid = usermissionid;
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

    public int getLevel() {
        LevelEval levelEval = new LevelEval(totalscore);
        return levelEval.levelEvalMethod();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserimge() {
        return userimge;
    }

    public void setUserimge(String userimge) {
        this.userimge = userimge;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }

    public String getFormatDataSign() {
        return FormatDateSign.formatTimeString(creationdate);
    }

    public void setFormatDataSign(String formatDataSign) {
        this.formatDataSign = formatDataSign;
    }

    @Override
    public String toString() {
        return "MyBookMark{" +
                "bookid=" + bookid +
                ", uid=" + uid +
                ", usermissionid=" + usermissionid +
                ", creationdate=" + creationdate +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", level=" + level +
                ", username='" + username + '\'' +
                ", userimge='" + userimge + '\'' +
                ", totalscore=" + totalscore +
                ", formatDataSign='" + formatDataSign + '\'' +
                '}';
    }
}
