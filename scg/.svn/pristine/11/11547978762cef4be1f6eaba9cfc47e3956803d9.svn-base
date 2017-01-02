package com.scg.api.missionpass;

import com.scg.api.googlefcm.Push;
import com.scg.api.googlefcm.PushService;
import com.scg.api.instructor.InstructorService;
import com.scg.api.point.SelfPoinService;
import com.scg.api.usermission.UserMissionService;
import com.scg.model.*;
import com.scg.model.Common.ServerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sungbo on 2016-08-29.
 */
@RestController
@RequestMapping("/api/pass/")
public class MissionPassController {
    private static final Logger logger = LoggerFactory.getLogger(MissionPassController.class);

    @Autowired
    private MissionPassService missionPassService;

    @Autowired
    private UserMissionService userMissionService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private SelfPoinService selfPoinService;

    @Autowired
    private PushService pushService;

    //강사심사 대기중인 목록
    @RequestMapping(value = "getMissionPassList", method = RequestMethod.POST)
    public List<MissionPass> getMissionPassList(@RequestBody MissionPass missionPass){
        logger.info("get test : " + missionPass.toString());
        return missionPassService.getMissionPassList(missionPass);
    }

    //강사심사 종료목록
    @RequestMapping(value = "getMissionPassResultList", method = RequestMethod.POST)
    public List<MissionPass> getMissionPassResultList(@RequestBody MissionPass missionPass){
        return missionPassService.getMissionPassResultList(missionPass);
    }

    @RequestMapping(value = "saveUserMissionPass", method = RequestMethod.POST)
    public ServerResult saveUserMissionPass(@RequestBody MissionPass missionPass){

        logger.info("패스 VO 값은 : " + missionPass.toString());
        missionPass.setPassflag("N");
        int previous_amount = 0;
        int pass_amount = 0;
        int last_amount = 0;
        SpBalanceLine spBalanceLine = new SpBalanceLine();

        InstructorPointHistory pointHis = instructorService.getPointHis(missionPass.getInstructorid());

        SpBalanceHeader balanceHeader = new SpBalanceHeader();
        balanceHeader.setUid(missionPass.getUid());
        balanceHeader = selfPoinService.getSelfPointAmount(balanceHeader);
        previous_amount = balanceHeader.getAmount();

        if(missionPass.getEvaltype().equals("Y")){ //자기팀 스승
            pass_amount = pointHis.getTeampasspoint();
        }else{  //다른팀 스승
            pass_amount = pointHis.getPubpasspoint();
        }

        missionPass.setCashpoint(pass_amount);

        if(previous_amount < pass_amount){
            return new ServerResult(0,"LACK","Point lack");
        }

        //포인트 지불
        last_amount = previous_amount - pass_amount;

        spBalanceLine.setHeaderid(balanceHeader.getHeaderid());
        spBalanceLine.setType("MISSIONPASS");
        spBalanceLine.setPreviousamount(previous_amount);
        spBalanceLine.setOutamount(pass_amount);
        spBalanceLine.setLastamount(last_amount);
        spBalanceLine.setDescription("미션 심사요청");

        selfPoinService.updateHeaderPoint(balanceHeader.getHeaderid(), balanceHeader.getUid(), last_amount);
        selfPoinService.saveLinePoint(spBalanceLine);

        UserMission userMission = new UserMission();
        userMission.setUid(missionPass.getUid());
        userMission.setUsermissionid(missionPass.getUsermissionid());
        userMission.setPassflag("P");
        userMission.setMissionid(missionPass.getMissionid());

        userMissionService.updateUserMission(userMission);
        //mission pass make
        logger.info("vlaue : " + missionPass.toString());
        int seq = missionPassService.getMaxSeq(missionPass);
        missionPass.setSeq(1 + seq);

        logger.info("패스 비용 검사 : " + missionPass.toString());

        missionPassService.savePass(missionPass);

        //패스 신청 푸쉬
        Message message = new Message(Push.PUSH_TITLE_FEEDBACK_EVAL_REG,missionPass.getUsername(),missionPass.getMissionname());
        pushService.pushExecute(Push.PUSHTYPE_FEEDBACK_EVAL_INS, missionPass.getInstructorid(), 0, 0, message);

        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "getPassList" , method = RequestMethod.POST)
    public List<MissionPass> getPassList(@RequestBody MissionPass missionPass){
        return missionPassService.getPassList(missionPass);
    }


    @RequestMapping(value = "deletePass" , method = RequestMethod.POST)
    public ServerResult deletePass(@RequestBody MissionPass missionPass){

        logger.info("1. value : " + missionPass.toString());

        //1.포인트 환급
        int previous_amount = 0;
        int pass_amount = 0;
        int last_amount = 0;
        SpBalanceLine spBalanceLine = new SpBalanceLine();

        //현재 잔액 가져오기
        SpBalanceHeader balanceHeader = new SpBalanceHeader();
        balanceHeader.setUid(missionPass.getUid());
        balanceHeader = selfPoinService.getSelfPointAmount(balanceHeader);
        previous_amount = balanceHeader.getAmount();

        pass_amount = missionPass.getCashpoint();
        logger.info("금액은... : " + pass_amount);

        //포인트 환불
        last_amount = pass_amount + previous_amount;

        spBalanceLine.setHeaderid(balanceHeader.getHeaderid());
        spBalanceLine.setType("MISSIONPASS_BACK");
        spBalanceLine.setPreviousamount(previous_amount);
        spBalanceLine.setInamount(pass_amount);
        spBalanceLine.setLastamount(last_amount);
        spBalanceLine.setDescription("미션 심사요청 환불");

        logger.info("환불 : " + spBalanceLine.toString());

        selfPoinService.updateHeaderPoint(balanceHeader.getHeaderid(), balanceHeader.getUid(), last_amount);
        selfPoinService.saveLinePoint(spBalanceLine);

        missionPassService.deletePass(missionPass);

        //미션이 끝난 상태 Y가 아니라면 usermission을 업데이트해준다 초기화
        if(missionPass.getMissionPassFlag().equals("P")){
            UserMission userMission = new UserMission();
            userMission.setUid(missionPass.getUid());
            userMission.setUsermissionid(missionPass.getUsermissionid());
            userMission.setMissionid(missionPass.getMissionid());
            userMission.setPassflag("N");
            userMissionService.updateUserMission(userMission);
        }


        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "updatePass", method = RequestMethod.POST)
    public ServerResult updatePass(@RequestBody MissionPass missionPass){

        logger.info("missionPass " + missionPass.toString());

        UserMission userMission = new UserMission();
        userMission.setUid(missionPass.getUid());
        userMission.setUsermissionid(missionPass.getUsermissionid());
        userMission.setPassflag(missionPass.getPassflag());
        userMission.setMissionid(missionPass.getMissionid());

        logger.info("userMission " + userMission.toString());

        userMissionService.updateUserMission(userMission);

        missionPassService.updatePass(missionPass);

        String message_result;

        if(missionPass.getPassflag().equals("Y")){
            message_result = "미션 합격";
        }else{
            message_result = "미션 불합격";
        }

        //패스결과 푸쉬
        Message message = new Message(Push.PUSH_TITLE_FEEDBACK_EVAL_REPLY,missionPass.getInsname(),message_result);
        pushService.pushExecute(Push.PUSHTYPE_FEEDBACK_EVAL_USER, 0, missionPass.getUid(), 0, message);

        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "getMissionPass", method = RequestMethod.POST)
    public MissionPass getMissionPass(@RequestBody MissionPass missionPass){
        MissionPass pass = missionPassService.getMissionPass(missionPass);
        return pass;
    }

}
