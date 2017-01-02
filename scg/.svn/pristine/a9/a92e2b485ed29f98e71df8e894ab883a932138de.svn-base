package com.scg.ins.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-08-17.
 */
public class InstructorVideoVo {

    private int videoid;
    private int instructorid;
    private String youtubeaddr;
    private String videoaddr;
    private String subject;
    private String description;
    private String relationmission;
    private Date creationdate;
    private Date updatedate;
    private String change_creationdate;
    private String change_updatedate;

    public InstructorVideoVo(){}

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    public int getInstructorid() {
        return instructorid;
    }

    public void setInstructorid(int instructorid) {
        this.instructorid = instructorid;
    }

    public String getYoutubeaddr() {
        return youtubeaddr;
    }

    public void setYoutubeaddr(String youtubeaddr) {
        this.youtubeaddr = youtubeaddr;
    }

    public String getVideoaddr() {
        return videoaddr;
    }

    public void setVideoaddr(String videoaddr) {
        this.videoaddr = videoaddr;
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

    public String getRelationmission() {
        return relationmission;
    }

    public void setRelationmission(String relationmission) {
        this.relationmission = relationmission;
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

    @Override
    public String toString() {
        return "InstructorVideoVo{" +
                "videoid=" + videoid +
                ", instructorid=" + instructorid +
                ", youtubeaddr='" + youtubeaddr + '\'' +
                ", videoaddr='" + videoaddr + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", relationmission='" + relationmission + '\'' +
                ", creationdate=" + creationdate +
                ", updatedate=" + updatedate +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", change_updatedate='" + change_updatedate + '\'' +
                '}';
    }
}
