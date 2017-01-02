package com.scg.model.userfriend;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-07-12.
 */
public class FriendApply {

    private int applyid;
    private int requid;
    private int resuid;
    private String flag;
    private String requestmessage;
    private Date creationdate;
    private Date updatedate;

    private String requsername;  //친구신청자 이름

    //non DB
    private String change_creationdate;
    private String change_updatedate;

    public String getRequsername() {
        return requsername;
    }

    public void setRequsername(String requsername) {
        this.requsername = requsername;
    }

    public FriendApply(){}

    public int getApplyid() {
        return applyid;
    }

    public void setApplyid(int applyid) {
        this.applyid = applyid;
    }

    public int getRequid() {
        return requid;
    }

    public void setRequid(int requid) {
        this.requid = requid;
    }

    public int getResuid() {
        return resuid;
    }

    public void setResuid(int resuid) {
        this.resuid = resuid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRequestmessage() {
        return requestmessage;
    }

    public void setRequestmessage(String requestmessage) {
        this.requestmessage = requestmessage;
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
        return "FriendApply{" +
                "applyid=" + applyid +
                ", requid=" + requid +
                ", resuid=" + resuid +
                ", flag='" + flag + '\'' +
                ", requestmessage='" + requestmessage + '\'' +
                ", creationdate=" + creationdate +
                ", updatedate=" + updatedate +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", change_updatedate='" + change_updatedate + '\'' +
                '}';
    }
}
