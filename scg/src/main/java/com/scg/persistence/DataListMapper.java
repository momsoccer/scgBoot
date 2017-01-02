package com.scg.persistence;

import com.scg.datadto.*;
import com.scg.ins.vo.InsInfoVo;

import java.util.List;

/**
 * Created by sungbo on 2016-07-21.
 */
public interface DataListMapper {

    public List<MainTypeListVo> getMomMainList();

    public List<InsInfoVo> getInsInfoList(InsInfoVo v);

    public InsInfoVo getInsInfo(InsInfoVo v);

    public List<UserLevelDataVo> getUserLevelDataList(int uid);

    public FeedDataVo getFeedData(int insid);

    public FeedDataVo getPassData(int insid);

    public FeedDataVo getUserMissionCount(int uid);

    //duplicate file name validation
    public int getInsFileCount(int uid,int insid,String filename);

    //team member query
    public List<UserMainVo> getTeamMemberList(int insid);

    //Mom All Team ranking
    public List<TeamRankingVo> getTeamRankingScore(int queryCount);
}
