package com.scg.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-06-11.
 */
public class CpBalanceHeader {

    private int headerid;
    private int uid;
    private int amount;
    private Date updatedate;
    private String change_updatedate;

    public CpBalanceHeader(){}

    public CpBalanceHeader(int headerid, int uid, int amount, Date updatedate, String change_updatedate) {
        this.headerid = headerid;
        this.uid = uid;
        this.amount = amount;
        this.updatedate = updatedate;
        this.change_updatedate = change_updatedate;
    }

    public int getHeaderid() {
        return headerid;
    }

    public void setHeaderid(int headerid) {
        this.headerid = headerid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getChange_updatedate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        change_updatedate = dateFormat.format(updatedate);
        return change_updatedate;
    }

    public void setChange_updatedate(String change_updatedate) {
        this.change_updatedate = change_updatedate;
    }

    @Override
    public String toString() {
        return "CpBalanceHEader{" +
                "headerid=" + headerid +
                ", uid=" + uid +
                ", amount=" + amount +
                ", updatedate=" + updatedate +
                ", change_updatedate='" + change_updatedate + '\'' +
                '}';
    }


}
