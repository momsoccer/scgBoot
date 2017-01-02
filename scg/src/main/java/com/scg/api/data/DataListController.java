package com.scg.api.data;

import com.scg.api.team.TeamService;
import com.scg.datadto.*;
import com.scg.ins.vo.InsInfoVo;
import com.scg.model.Common.ServerResult;
import com.scg.model.TeamMember;
import com.scg.persistence.RankingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sungbo on 2016-07-21.
 */

@RestController
@RequestMapping("/api/data")
public class DataListController {

    private static final Logger logger = LoggerFactory.getLogger(DataListController.class);

    @Autowired
    private DataListService dataListService;

    @Autowired
    private RankingMapper rankingMapper;

    @Autowired
    private TeamService teamService;

    @RequestMapping("getTeamRankingScore")
    public List<TeamRankingVo> getTeamRankingScore(@RequestParam("count") int queryCount){
        return dataListService.getTeamRankingScore(queryCount);
    }

    @RequestMapping("getUserMissionCount")
    public FeedDataVo getUserMissionCount(@RequestParam("uid") int uid){
        return dataListService.getUserMissionCount(uid);
    }

    @RequestMapping("getInsFileCount")
    public ServerResult getInsFileCount(@RequestParam("uid") int uid,@RequestParam("insid") int insid,@RequestParam("filename") String filename ){

        ServerResult result = new ServerResult();
        int count =dataListService.getInsFileCount(uid,insid,filename);
        result.setCount(count);
        result.setResult("S");
        return result;
    }

    //피드빽 요청할때 선생님 리스트
    @RequestMapping(value = "getInsInfoList", method = RequestMethod.POST)
    public List<InsInfoVo> getInsInfoList(@RequestBody InsInfoVo v){

        TeamMember teamMember = new TeamMember();
        teamMember.setUid(v.getNouid());

        logger.info("강사 조회 : " + teamMember.toString());

        teamMember = teamService.getTeamMemeber(teamMember);

        if(teamMember.getTeamid()==0){
            v.setNouid(0);
        }

        logger.info("강사 조회 : " + v.toString());

        return dataListService.getInsInfoList(v);
    }

    @RequestMapping("getPassData")
    public FeedDataVo getPassData(@RequestParam("insid") int insid){
        return dataListService.getPassData(insid);
    }

    @RequestMapping("getFeedData")
    public FeedDataVo getFeedData(@RequestParam("insid") int insid){
        return dataListService.getFeedData(insid);
    }

    @RequestMapping("typeList")
    public List<MainTypeListVo> getMisstionTypeList(){
        List<MainTypeListVo> mainTypeListVos = dataListService.getMomMainList();
        return mainTypeListVos;
    }

    @RequestMapping(value = "getTotalRanking", method = RequestMethod.POST)
         public List<UserRangkinVo> getTotalRanking(@RequestBody UserRangkinVo userRangkinVo){
        return rankingMapper.getUserRankingAll(userRangkinVo);
    }

    @RequestMapping(value = "getTeamRanking", method = RequestMethod.POST)
    public List<UserRangkinVo> getTeamRanking(@RequestBody UserRangkinVo userRangkinVo){
        return rankingMapper.getTeamRanking(userRangkinVo);
    }

    @RequestMapping(value = "getFriendRanking", method = RequestMethod.POST)
    public List<UserRangkinVo> getFriendRanking(@RequestBody UserRangkinVo userRangkinVo){
        logger.info("프랜드 랭킹");
        return rankingMapper.getFriendRanking(userRangkinVo);
    }

    //피드빽 요청할때 선생님 리스트
    @RequestMapping(value = "getInsInfo", method = RequestMethod.POST)
    public InsInfoVo getInsInfo(@RequestBody InsInfoVo v){

        logger.info("컬합니다 : " +v.toString());

        return dataListService.getInsInfo(v);
    }

    //개인유저 레벨 및 점수 정보
    @RequestMapping(value = "getUserLevelDataList", method = RequestMethod.GET)
    public List<UserLevelDataVo> getUserLevelDataList(@RequestParam("uid") int uid){
        return dataListService.getUserLevelDataList(uid);
    }

    //getTeamMemberList 팀 멤버
    @RequestMapping(value = "getTeamMemberList", method = RequestMethod.GET)
    public List<UserMainVo> getTeamMemberList(@RequestParam("insid") int insid){
        return dataListService.getTeamMemberList(insid);
    }

}
