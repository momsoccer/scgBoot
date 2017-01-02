package com.scg.event;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-11-24.
 */
public class Eventrequest {

    private int reqid;
    private String name;
    private String emailaddr;
    private int age;
    private String reqrason;
    private String phone;
    private Date creationdate;
    private int mainid;
    private String bankflag;
    private String confirm;
    private String change_creationdate;
    private String password;
    private String agree;


    public Eventrequest(){}

    @Override
    public String toString() {
        return "Eventrequest{" +
                "reqid=" + reqid +
                ", name='" + name + '\'' +
                ", emailaddr='" + emailaddr + '\'' +
                ", age=" + age +
                ", reqrason='" + reqrason + '\'' +
                ", phone='" + phone + '\'' +
                ", creationdate=" + creationdate +
                ", mainid=" + mainid +
                ", bankflag='" + bankflag + '\'' +
                ", confirm='" + confirm + '\'' +
                ", change_creationdate='" + change_creationdate + '\'' +
                ", password='" + password + '\'' +
                ", agree='" + agree + '\'' +
                '}';
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getReqid() {
        return reqid;
    }

    public void setReqid(int reqid) {
        this.reqid = reqid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailaddr() {
        return emailaddr;
    }

    public void setEmailaddr(String emailaddr) {
        this.emailaddr = emailaddr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getReqrason() {
        return reqrason;
    }

    public void setReqrason(String reqrason) {
        this.reqrason = reqrason;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public int getMainid() {
        return mainid;
    }

    public void setMainid(int mainid) {
        this.mainid = mainid;
    }

    public String getBankflag() {
        return bankflag;
    }

    public void setBankflag(String bankflag) {
        this.bankflag = bankflag;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
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
