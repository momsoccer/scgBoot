package com.scg.datadto;

import com.scg.api.common.LevelEval;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sungbo on 2016-09-06.
 */
public class UserMainVo {

    private int uid;
    private int instructorid;
    private int missionid;
    private int usermissionid;
    private String username;
    private String insname;
    private String teamname;
    private String profileimgurl;

    private String missiontype;
    private String missionname;
    private String description;
    private String uservideo;
    private String missionvideo;
    private int grade;
    private int passgrade;
    private int sequence;
    private String passflag;

    private int feedbackcount;
    private int boardcount;
    private int totalscore;
    private int bookmarkcount;
    private int missionpasscount;

    private Date creationdate;
    private String change_creationdate;

    private String usersubject;
    private String userdescription;

    private int teamid;
    private int level;

    //query condition
    private String condition;

    //pageing
    private int limit;
    private int offset;
    private String friendcheck;
    private String teamcheck;
    private String passyescheck;
    private String passnocheck;

    //언어팩
    private String cnname;
    private String cndescription;
    private String cnprecon;

    private String enname;
    private String endescription;
    private String enprecon;

    @Override
    public String toString() {
        return "UserMainVo{" +
                "uid=" + uid +
                ", instructorid=" + instructorid +
                ", missionid=" + missionid +
                ", usermissionid=" + usermissionid +
                ", username='" + username + '\'' +
                ", insname='" + insname + '\'' +
                ", teamname='" + teamname + '\'' +
                ", profileimgurl='" + profileimgurl + '\'' +
                ", missiontype='" + missiontype + '\'' +
                ", missionname='" + missionname + '\'' +
                ", description='" + description + '\'' +
                ", uservideo='" + uservideo + '\'' +
                ", missionvideo='" + missionvideo + '\'' +
                ", grade=" + grade +
                ", passgrade=" + passgrade +
                ", sequence=" + sequence +
                ", passflag='" + passflag + '\'' +
                ", feedbackcount=" + feedbackcount +
                ", boardcount=" + boardcount +
                ", totalscore=" + totalscore +
                ", bookmarkcount=" + bookmarkcount +
                ", missionpasscount=" + missionpasscount +
                ", creationdate=" + creationdate +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", usersubject='" + usersubject + '\'' +
                ", userdescription='" + userdescription + '\'' +
                ", teamid=" + teamid +
                ", level=" + level +
                ", condition='" + condition + '\'' +
                ", limit=" + limit +
                ", offset=" + offset +
                ", friendcheck='" + friendcheck + '\'' +
                ", teamcheck='" + teamcheck + '\'' +
                ", passyescheck='" + passyescheck + '\'' +
                ", passnocheck='" + passnocheck + '\'' +
                ", cnname='" + cnname + '\'' +
                ", cndescription='" + cndescription + '\'' +
                ", cnprecon='" + cnprecon + '\'' +
                ", enname='" + enname + '\'' +
                ", endescription='" + endescription + '\'' +
                ", enprecon='" + enprecon + '\'' +
                ", typename=" + typename +
                ", listCount=" + listCount +
                '}';
    }

    //in 조회 조건을 위한....
    private List<String> typename;
    private int listCount;

    public List<String> getTypename() {
        return typename;
    }

    public void setTypename(List<String> typename) {
        this.typename = typename;
    }

    public int getListCount() {
        return listCount;
    }

    public void setListCount(int listCount) {
        this.listCount = listCount;
    }

    public UserMainVo(){}

    public String getFriendcheck() {
        return friendcheck;
    }

    public void setFriendcheck(String friendcheck) {
        this.friendcheck = friendcheck;
    }

    public String getTeamcheck() {
        return teamcheck;
    }

    public void setTeamcheck(String teamcheck) {
        this.teamcheck = teamcheck;
    }

    public String getPassyescheck() {
        return passyescheck;
    }

    public void setPassyescheck(String passyescheck) {
        this.passyescheck = passyescheck;
    }

    public String getPassnocheck() {
        return passnocheck;
    }

    public void setPassnocheck(String passnocheck) {
        this.passnocheck = passnocheck;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getCndescription() {
        return cndescription;
    }

    public void setCndescription(String cndescription) {
        this.cndescription = cndescription;
    }

    public String getCnprecon() {
        return cnprecon;
    }

    public void setCnprecon(String cnprecon) {
        this.cnprecon = cnprecon;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getEndescription() {
        return endescription;
    }

    public void setEndescription(String endescription) {
        this.endescription = endescription;
    }

    public String getEnprecon() {
        return enprecon;
    }

    public void setEnprecon(String enprecon) {
        this.enprecon = enprecon;
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

    public int getMissionpasscount() {
        return missionpasscount;
    }

    public void setMissionpasscount(int missionpasscount) {
        this.missionpasscount = missionpasscount;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getBookmarkcount() {
        return bookmarkcount;
    }

    public void setBookmarkcount(int bookmarkcount) {
        this.bookmarkcount = bookmarkcount;
    }

    public String getUsersubject() {
        return usersubject;
    }

    public void setUsersubject(String usersubject) {
        this.usersubject = usersubject;
    }

    public String getUserdescription() {
        return userdescription;
    }

    public void setUserdescription(String userdescription) {
        this.userdescription = userdescription;
    }

    public int getLevel() {
        LevelEval levelEval = new LevelEval(totalscore);

        return levelEval.levelEvalMethod();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getProfileimgurl() {
        return profileimgurl;
    }

    public void setProfileimgurl(String profileimgurl) {
        this.profileimgurl = profileimgurl;
    }

    public String getMissiontype() {
        return missiontype;
    }

    public void setMissiontype(String missiontype) {
        this.missiontype = missiontype;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getPassgrade() {
        return passgrade;
    }

    public void setPassgrade(int passgrade) {
        this.passgrade = passgrade;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getPassflag() {
        return passflag;
    }

    public void setPassflag(String passflag) {
        this.passflag = passflag;
    }

    public int getFeedbackcount() {
        return feedbackcount;
    }

    public void setFeedbackcount(int feedbackcount) {
        this.feedbackcount = feedbackcount;
    }

    public int getBoardcount() {
        return boardcount;
    }

    public void setBoardcount(int boardcount) {
        this.boardcount = boardcount;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
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
