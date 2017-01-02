package com.scg.api.data;

import com.scg.datadto.*;
import com.scg.ins.vo.InsInfoVo;
import com.scg.persistence.DataListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-07-21.
 */
@Service
public class DataListService {

    @Autowired
    private DataListMapper dataListMapper;

    public List<MainTypeListVo> getMomMainList(){
        return dataListMapper.getMomMainList();
    };

    public List<InsInfoVo> getInsInfoList(InsInfoVo v){
        return dataListMapper.getInsInfoList(v);
    };


    public int getInsFileCount(int uid,int insid,String filename){
        return dataListMapper.getInsFileCount(uid, insid, filename);
    };

    public InsInfoVo getInsInfo(InsInfoVo v){

        InsInfoVo insInfoVo=null;
        try {
            insInfoVo = dataListMapper.getInsInfo(v);
        }catch (Exception e){

        }

        if(insInfoVo==null){
            insInfoVo = new InsInfoVo();
        }

        return insInfoVo;
    };

    public List<UserLevelDataVo> getUserLevelDataList(int uid){
        return dataListMapper.getUserLevelDataList(uid);
    };

    public FeedDataVo getFeedData(int insid){
        return dataListMapper.getFeedData(insid);
    };

    public FeedDataVo getPassData(int insid){
        return dataListMapper.getPassData(insid);
    };

    public FeedDataVo getUserMissionCount(int uid){
        return dataListMapper.getUserMissionCount(uid);
    };

    public List<UserMainVo> getTeamMemberList(int insid){
        return dataListMapper.getTeamMemberList(insid);
    };

    public List<TeamRankingVo> getTeamRankingScore(int queryCount){
        return dataListMapper.getTeamRankingScore(queryCount);
    };
}
