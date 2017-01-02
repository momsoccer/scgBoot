package com.scg.wep.controller;

import com.scg.api.googlefcm.Push;
import com.scg.api.googlefcm.PushService;
import com.scg.api.missionpass.MissionPassService;
import com.scg.api.usermission.UserMissionService;
import com.scg.event.Utils;
import com.scg.model.Message;
import com.scg.model.MissionPass;
import com.scg.model.UserMission;
import com.scg.wep.service.WebMissionPassService;
import com.scg.wep.vo.MissionPassVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by sungbo on 2016-11-21.
 */

@Controller
public class MomSoccerController {

    private static final Logger weblog = LoggerFactory.getLogger(MomSoccerController.class);

    @Autowired
    WebMissionPassService webMissionPassService;

    @Autowired
    UserMissionService userMissionService;

    @Autowired
    MissionPassService missionPassService;

    @Autowired
    private PushService pushService;

    /*****************************************
     * 웹 로그인 관련
     * ******************************************/

    @RequestMapping(value = "mom/index")
    public String Index(Model model,
                        HttpServletRequest request){

        weblog.info("씨큐리티 로그인 명" + SecurityContextHolder.getContext().getAuthentication().getName());
        weblog.info("씨큐리티 로그인 명" + SecurityContextHolder.getContext().getAuthentication().getAuthorities());

        model.addAttribute("curlogname", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("curlogrole", SecurityContextHolder.getContext().getAuthentication().getAuthorities());

        HttpSession session = request.getSession();
        String userid = SecurityContextHolder.getContext().getAuthentication().getName();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(userid != "anonymousUser" ){
            session.setAttribute("userid",userid);
        }
        return "/mom/index";
    }

    //로그아웃
    @RequestMapping(value = "/mom/loginerror", method = RequestMethod.GET)
    public String loginerror() {
        return "/mom/loginerror";
    }

    //로그아웃
    @RequestMapping(value = "/mom/logout", method = RequestMethod.GET)
    public String logoutFacebook(HttpServletRequest request, Model model) {

        SecurityContextHolder.clearContext();
        HttpSession session = request.getSession(false);

        //카카오라면
        String accessToken = (String) session.getAttribute("accessToken");

        weblog.info("토큰 값은 : " + accessToken);
        String kakaoUserProfileReqUrl="https://kapi.kakao.com/v1/user/logout";
        String getid = Utils.getHtml(kakaoUserProfileReqUrl,"Bearer {{"+accessToken+"}}");
        weblog.info("카카오 로그 아웃 응답 : " + getid);


        if (session != null) {
            session.invalidate();
        }

        return "redirect:" + "/mom/index";
    }

    /***********************************************************************************/

    @RequestMapping("/missionwork/missionreqlist")
    public String missionreqlist(Model model){

        weblog.info("미션신청 리스트");

        MissionPassVo missionPassVo = new MissionPassVo();

        model.addAttribute("passlist", webMissionPassService.getUserMissionList());

        return "/missionwork/missionreqlist";
    }

    @RequestMapping("/missionwork/evalenter")
    public String evalenter(Model model,
                            @RequestParam("usermissionid") int usermissionid){

        model.addAttribute("PassVo", webMissionPassService.getData(usermissionid));

        return "/missionwork/evalenter";
    }

    @RequestMapping(value = "/missionwork/missioneval" ,method = RequestMethod.POST)
    public String missioneval(@ModelAttribute("missionpassvo") MissionPassVo missionPassVo){

        if(missionPassVo.getPassflag().equals("Y")){
            missionPassVo.setStatus("SUCCESS");
        }else{
            missionPassVo.setStatus("REJECT");
        }

        UserMission userMission = new UserMission();
        userMission.setUid(missionPassVo.getUid());
        userMission.setUsermissionid(missionPassVo.getUsermissionid());
        userMission.setPassflag(missionPassVo.getPassflag());

        //Update usermission table
        userMissionService.updateUserMission(userMission);

        //Copy data
        //missionPass <= missionPassVo

        MissionPass missionPass = new MissionPass();

        missionPass.setInstructorid(37);

        missionPass.setMissionid(missionPassVo.getMissionid());
        missionPass.setPassid(missionPassVo.getPassid());
        missionPass.setUid(missionPassVo.getUid());
        missionPass.setUsermissionid(missionPassVo.getUsermissionid());

        missionPass.setPassflag(missionPassVo.getPassflag());
        missionPass.setInscomment(missionPassVo.getInscomment());
        missionPass.setFailuredisp(missionPassVo.getFailuredisp());
        missionPass.setStatus(missionPassVo.getStatus());

        weblog.info("객체의 값 : " + missionPass.toString());


        missionPassService.savePass(missionPass);

        String message_result;

        if(missionPassVo.getPassflag().equals("Y")){
            message_result = "미션 합격";
        }else{
            message_result = "미션 불합격";
        }

        Message message = new Message(Push.PUSH_TITLE_FEEDBACK_EVAL_REPLY,missionPass.getInsname(),message_result);
        pushService.pushExecute(Push.PUSHTYPE_FEEDBACK_EVAL_USER, 0, missionPass.getUid(), 0, message);

        return "redirect:" +"/missionwork/missionreqlist";
    }

    @RequestMapping("/mom/logoutsuccess")
    public String evalenter(){
        return "/mom/logoutsuccess";
    }


}
