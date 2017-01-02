package com.scg.model;

import com.scg.api.common.LevelEval;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserMission {

	private int usermissionid;
	private int missionid;
	private int uid;
	private String username;
	private String profileimgurl;
	private String teamname;
	private String bookmarkcount;
	private String boardcount;
	private int mycheck;
	private String subject;
	private String description;
	private String uploadflag;
	private String youtubeaddr;
	private String passflag;
	private String videoaddr;
	private String filename;
	private int grade;          //미션업로드점수
	private int passgrade;      //미션클리어점수
	private Date creationdate;
	private String change_creationdate;
	private Date updatedate;
	private String change_updatedate;
	private int queryRow;
	private String orderbytype;
	private String missionname;
	private int totalscore;
	private int level;
	private int sequence;

	private String missiontype;

	public UserMission(){}

	@Override
	public String toString() {
		return "UserMission{" +
				"usermissionid=" + usermissionid +
				", missionid=" + missionid +
				", uid=" + uid +
				", username='" + username + '\'' +
				", profileimgurl='" + profileimgurl + '\'' +
				", teamname='" + teamname + '\'' +
				", bookmarkcount='" + bookmarkcount + '\'' +
				", boardcount='" + boardcount + '\'' +
				", mycheck=" + mycheck +
				", subject='" + subject + '\'' +
				", description='" + description + '\'' +
				", uploadflag='" + uploadflag + '\'' +
				", youtubeaddr='" + youtubeaddr + '\'' +
				", passflag='" + passflag + '\'' +
				", videoaddr='" + videoaddr + '\'' +
				", filename='" + filename + '\'' +
				", grade=" + grade +
				", passgrade=" + passgrade +
				", creationdate=" + creationdate +
				", change_creationdate='" + change_creationdate + '\'' +
				", updatedate=" + updatedate +
				", change_updatedate='" + change_updatedate + '\'' +
				", queryRow=" + queryRow +
				", orderbytype='" + orderbytype + '\'' +
				", missionname='" + missionname + '\'' +
				", totalscore=" + totalscore +
				", level=" + level +
				", sequence=" + sequence +
				", missiontype='" + missiontype + '\'' +
				'}';
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getMissiontype() {
		return missiontype;
	}

	public void setMissiontype(String missiontype) {
		this.missiontype = missiontype;
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

	public String getOrderbytype() {
		return orderbytype;
	}

	public String getMissionname() {
		return missionname;
	}

	public void setMissionname(String missionname) {
		this.missionname = missionname;
	}

	public void setOrderbytype(String orderbytype) {
		this.orderbytype = orderbytype;
	}

	public int getQueryRow() {
		return queryRow;
	}

	public void setQueryRow(int queryRow) {
		this.queryRow = queryRow;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getUsermissionid() {
		return usermissionid;
	}

	public void setUsermissionid(int usermissionid) {
		this.usermissionid = usermissionid;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUploadflag() {
		return uploadflag;
	}

	public void setUploadflag(String uploadflag) {
		this.uploadflag = uploadflag;
	}

	public String getYoutubeaddr() {
		return youtubeaddr;
	}

	public void setYoutubeaddr(String youtubeaddr) {
		this.youtubeaddr = youtubeaddr;
	}

	public String getPassflag() {
		return passflag;
	}

	public void setPassflag(String passflag) {
		this.passflag = passflag;
	}

	public String getVideoaddr() {
		return videoaddr;
	}

	public void setVideoaddr(String videoaddr) {
		this.videoaddr = videoaddr;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public String getChange_creationdate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

		if(creationdate!=null){
			change_creationdate = dateFormat.format(creationdate);
			return change_creationdate;
		}else{
			this.change_creationdate = change_creationdate;
			return change_creationdate;
		}
	}

	public void setChange_creationdate(String change_creationdate) {
		this.change_creationdate = change_creationdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getChange_updatedate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

		if(updatedate!=null){
			change_updatedate = dateFormat.format(updatedate);
			return change_updatedate;
		}else{
			return change_updatedate;
		}
	}

	public void setChange_updatedate(String change_updatedate) {
		this.change_updatedate = change_updatedate;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getBookmarkcount() {
		return bookmarkcount;
	}

	public void setBookmarkcount(String bookmarkcount) {
		this.bookmarkcount = bookmarkcount;
	}

	public int getMycheck() {
		return mycheck;
	}

	public void setMycheck(int mycheck) {
		this.mycheck = mycheck;
	}

	public String getBoardcount() {
		return boardcount;
	}

	public void setBoardcount(String boardcount) {
		this.boardcount = boardcount;
	}

}