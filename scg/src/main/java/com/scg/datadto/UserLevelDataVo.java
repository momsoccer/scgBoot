package com.scg.datadto;

import com.scg.api.common.LevelEval;

/**
 * Created by sungbo on 2016-08-22.
 */
public class UserLevelDataVo {

    private int uid;
    private String mittiontype;
    private String score;
    private int level;

    public UserLevelDataVo(){};

    @Override
    public String toString() {
        return "UserLevelDataVo{" +
                "uid=" + uid +
                ", mittiontype='" + mittiontype + '\'' +
                ", score='" + score + '\'' +
                ", level=" + level +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMittiontype() {
        return mittiontype;
    }

    public void setMittiontype(String mittiontype) {
        this.mittiontype = mittiontype;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getLevel() {
        LevelEval levelEval = new LevelEval(Integer.parseInt(score));
        return levelEval.levelEvalMethod();
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
