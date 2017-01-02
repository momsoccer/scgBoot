package com.scg.event;

import java.util.Date;

/**
 * Created by 열혈씸 on 2016-12-12.
 */
public class EventBoardVo {

    private int boardid;
    private int uid;
    private int mainid;
    private String content;
    private Date creationdate;
    private String username;
    private String eval;

    public EventBoardVo(){}

    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        this.eval = eval;
    }

    public int getBoardid() {
        return boardid;
    }

    public void setBoardid(int boardid) {
        this.boardid = boardid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getMainid() {
        return mainid;
    }

    public void setMainid(int mainid) {
        this.mainid = mainid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "EventBoardVo{" +
                "boardid=" + boardid +
                ", uid=" + uid +
                ", mainid=" + mainid +
                ", content=" + content +
                ", creationdate=" + creationdate +
                ", username='" + username + '\'' +
                '}';
    }
}
