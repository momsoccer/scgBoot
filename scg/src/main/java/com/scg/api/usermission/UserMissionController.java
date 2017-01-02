package com.scg.api.usermission;

import com.scg.datadto.EvalVo;
import com.scg.datadto.UserVideoHistoryVo;
import com.scg.model.Common.ServerResult;
import com.scg.model.UserMission;
import com.scg.model.UserMissionEval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sungbo on 2016-05-31.
 */
@RestController
@RequestMapping("/api/usermission/")
public class UserMissionController {

    private static final Logger logger = LoggerFactory.getLogger(UserMissionController.class);

    @Autowired
    private UserMissionService userMissionService;

    @Autowired
    private UserVideoHistoryService userVideoHistoryService;

    //다른사람들의 영상
    @RequestMapping(value = "uMissionList",method = RequestMethod.POST)
    public List<UserMission> uMissionList(@RequestBody UserMission userMission){
        return userMissionService.getUmissionList(userMission);
    }

    //내영상
    @RequestMapping(value = "getUserMissionList",method = RequestMethod.POST)
    public List<UserMission> getUserMissionList(@RequestBody UserMission userMission){
        return userMissionService.getUserMissionList(userMission);
    }

    @RequestMapping(value = "videoValidate",method = RequestMethod.POST)
    public ServerResult videoValidate(@RequestBody UserMission userMission){

        String workFlag = null;

        UserVideoHistoryVo historyVo = new UserVideoHistoryVo();
        historyVo.setUid(userMission.getUid());
        historyVo.setFilename(userMission.getFilename());

        UserVideoHistoryVo resultVo = new UserVideoHistoryVo();
        resultVo = userVideoHistoryService.getVideoHistory(historyVo);

        if(resultVo.getId()!=0){
            workFlag="F";
        }else{
            workFlag="S";
        }

        return new ServerResult(1,workFlag);
    }


    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public ServerResult insert(@RequestBody UserMission userMission){

        String workFlag;
        logger.info("유저 미션 데이터를 생성 합니다");
        //해당 미션아이디로 업로드 자료가 있다면 업데이트를 수행한다.

        UserMission query_user_mission = userMissionService.getUserMission(userMission);

        if(query_user_mission.getUsermissionid()==0){
            logger.info("데이터를 생성 합니다 ");
            int userMission_id = userMissionService.saveUserMission(userMission);
            workFlag ="new data";
        }else{
            userMissionService.updateUserMission(userMission);
            workFlag ="update data";
        }

        //중복 방지를 위한 데이터 흔적 남기기
        UserVideoHistoryVo historyVo = new UserVideoHistoryVo();
        historyVo.setUid(userMission.getUid());
        historyVo.setMissionid(userMission.getMissionid());
        historyVo.setFilename(userMission.getFilename());
        userVideoHistoryService.saveVideoHistory(historyVo);

        return new ServerResult(1,"S",workFlag);
    }

    //json 형태는 스트링으로 넘어오기 때문에 넘버 타입으로 받을 때는 형변환을 해준다.
    @RequestMapping(value="getlist", method= RequestMethod.GET)
    public List<UserMission> getUserMissionList(
            @RequestParam(required = false) String usermissionid,
            @RequestParam(required = false) String uid,
            @RequestParam(required = false) String uploadflag,
            @RequestParam(required = false) String passflag
    ) {

        logger.info("getusermissionlist() 호출");
        UserMission userMission = new UserMission();

        if(usermissionid!=null){
            int sumissionid = Integer.parseInt(usermissionid);
            userMission.setUsermissionid(sumissionid);
        }

        if(uid!=null){
            int suid = Integer.parseInt(uid);
            userMission.setUid(suid);
        }

        if(uploadflag!=null){
            userMission.setUploadflag(uploadflag);
        }

        if(passflag!=null){
            userMission.setPassflag(passflag);
        }

        return userMissionService.getUserMissionList(userMission);
    }


    @RequestMapping(value = "usermissioncount")
    public int userMissionCount(){

        UserMissionEval eval = new UserMissionEval();
        eval.setUid(1);
        return userMissionService.getUserMissionEvalCount(eval);
    }

    @RequestMapping(value = "getumission", method = RequestMethod.POST)
    public UserMission getUserMission(@RequestBody UserMission mission){

        UserMission userMission = userMissionService.getUserMission(mission);

        logger.info("mission 값은 : " + userMission.toString());

        return userMission;
    }

    /**************************
     * 유저 미션 평가관련 쿼리
     * *******************************/

    @RequestMapping(value = "saveUserMissionEval", method = RequestMethod.POST)
    public ServerResult saveUserMissionEval(@RequestBody UserMissionEval e){

        //평가를 하고
        if(e.getQueryflag().equals("S")){ //s일때는 인설트 및 조회


            userMissionService.saveUserMissionEval(e);
        }

        EvalVo evalVo = userMissionService.getUserMissionAvg(e);
        ServerResult result = new ServerResult();
        result.setAvg(evalVo.getAvg());
        result.setCount(1);
        result.setResult("S");
        return result;
    }
}
