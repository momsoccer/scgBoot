package com.scg.wep.controller;

import com.scg.api.commonlookup.LookupService;
import com.scg.api.googlefcm.Push;
import com.scg.api.googlefcm.PushService;
import com.scg.api.instructor.InstructorService;
import com.scg.api.mission.MissionService;
import com.scg.api.point.SelfPoinService;
import com.scg.api.team.TeamService;
import com.scg.api.user.UserService;
import com.scg.ins.service.InsService;
import com.scg.ins.vo.InsApplyVo;
import com.scg.model.*;
import com.scg.persistence.PushMapper;
import com.scg.persistence.ReportMapper;
import com.scg.persistence.UserRoleMapper;
import com.scg.wep.service.PointManageServeice;
import com.scg.wep.vo.MissionRegisterVo;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sungbo on 2016-06-02.
 */
@Controller
@RequestMapping("/admin/")
public class WebMissionController {

    private static final Logger logger = LoggerFactory.getLogger(WebMissionController.class);
    @Autowired
    PushMapper pushMapper;

    @Autowired
    MissionService missionService;

    @Autowired
    LookupService lookupService;

    @Autowired
    PointManageServeice pointManageServeice;

    @Autowired
    InsService insService;

    @Autowired
    InstructorService instructorService;

    @Autowired
    UserService userService;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    TeamService teamService;

    @Autowired
    PushService pushService;

    @Autowired
    ReportMapper reportMapper;

    @Autowired
    SelfPoinService selfPoinService;

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<HashMap> result;
    HttpHeaders headers = new HttpHeaders();
    String fcmString="dqZXAsncTZ4:APA91bEarmS_iCTWpIJivTkQvsD8drvM7t_ly3QMpVVR5mmFpuJkBvKg5zqUwlixGTAQNk0cGFvXiqpSpbl3vStU2eghw_nEKVBJKwtt-5R2PU-ZHPR5TfyzLRwvgdpqnoVzvbFZCvVv";

    @RequestMapping("mission")
    public String mission(Model model,
                          @ModelAttribute("querymission") QueryMission queryMission){

        List<Mission> missionList = missionService.getMissionList(queryMission);
        model.addAttribute("list", missionList);

        JSONArray jsonArray = new JSONArray();
        model.addAttribute("categoryList", jsonArray.fromObject(lookupService.getCategoryCode()));
        model.addAttribute("typeList", jsonArray.fromObject(lookupService.getTypeCode()));

        model.addAttribute("qcategoryList", jsonArray.fromObject(lookupService.getCategoryCode()));
        model.addAttribute("qtypeList", jsonArray.fromObject(lookupService.getTypeCode()));
        return "/admin/mission";
    }

    //새로운 미션이 등록 되었을때..
    @RequestMapping(value = "missioncreate")
    public String categorycreate(@ModelAttribute("missionregistervo") MissionRegisterVo mission){

        logger.info("MissionVo information : "+mission.toString());

        missionService.saveMission(mission);

        PointManagement PointVo = new PointManagement();
        PointVo.setTypecode(mission.getTypecode());
        PointVo.setTypedescription("mission challenge");
        PointVo.setEnabled(mission.getEnabled());
        PointVo.setPoint(0);
        PointVo.setLang("KR");
        PointVo.setSign("+-");
        PointVo.setMissionid(mission.getMissionid());
        PointVo.setGetpoint(mission.getGetpoint());
        PointVo.setEscapepoint(mission.getEscapepoint());
        pointManageServeice.savePointManager(PointVo);

        Message message = new Message(Push.SEED_MISSION_REG,mission.getMissionname(),mission.getDescription());
        pushService.pushExecute(Push.PUSHTYPE_SEEDMISSION_REG, 0, 0, 0, message);

        return "redirect:" +"/admin/mission";
    }

    @RequestMapping(value = "coachapprov")
    public String approve(){
        return "/admin/coachapprov";
    }


    /******************
     * 강사승인 및 강사의 종속된 팀 생성 셋업
     * *******************/
    @RequestMapping(value = "coachconfirm")
    public String coachconfirm(@ModelAttribute("missionregistervo") User user){

        logger.info("user : " + user.toString());
        InsApplyVo applyVo = new InsApplyVo();
        applyVo.setUid(user.getUid());
        applyVo = insService.getIns(applyVo);
        user = userService.getInsUser(user);

        logger.info("applyVo : " + applyVo.toString());
        logger.info("user : " + user.toString());

        Instructor instructor = new Instructor();

        instructor.setUid(applyVo.getUid());
        instructor.setEmail(applyVo.getEmail());
        instructor.setName(applyVo.getName());
        instructor.setProfile(applyVo.getResume());

        String profileDisp = applyVo.getCareer1()+"#"+
                applyVo.getCareer2()+"#"+
                applyVo.getCareer3()+"#"+
                applyVo.getCareer4()+"#"+
                applyVo.getCareer5();

        instructor.setDescription(profileDisp);
        instructor.setPhone(applyVo.getPhonenumber());
        instructor.setCommontokenid(user.getCommontokenid());
        instructor.setFeedbackflag("Y");
        instructor.setApppushflag("Y");
        instructor.setProfileimgurl(user.getProfileimgurl());
        instructor.setPassword("not use");

        logger.info("instructor : " + instructor.toString());

        Role role = new Role();
        role.setUid(user.getUid()); role.setRolename("INS");

        userRoleMapper.saveUserRole(role);

        int inid = instructorService.saveInstructor(instructor);
        logger.info("inid : " + inid);

        //팀을 생성한다
        Team team = new Team();
        team.setInstructorid(instructor.getInstructorid());
        team.setName(applyVo.getMomappteamname());
        team.setEmblem(applyVo.getTeamimg());
        team.setApproveflag("Y");
        team.setEnabled("Y");

        int teamId = teamService.teamSave(team);

        TeamMember teamMember = new TeamMember();
        teamMember.setUid(instructor.getUid());
        teamMember.setTeamid(team.getTeamid());
        teamMember.setEnabled("Y");
        teamMember.setAuthority("OWNER");

        teamService.saveTeamMember(teamMember);

        applyVo.setApplystatus("APPROVAL");
        applyVo.setInstructorid(instructor.getInstructorid());
        insService.updateIns(applyVo);

        InstructorPointHistory pointHistory = new InstructorPointHistory();
        pointHistory.setInstructorid(instructor.getInstructorid());
        pointHistory.setPubvideopoint(0);
        pointHistory.setPubwordpoint(0);
        pointHistory.setTeamvideopoint(0);
        pointHistory.setTeamwordpoint(0);
        instructorService.savePointHistory(pointHistory);

        Message message = new Message(Push.INS_APPROVAL,"몸싸커 강사승인","열심히 활동 부탁드립니다");
        pushService.pushExecute(Push.PUSHTYPE_APPROVAL_INS, 0, user.getUid(), 0, message);

        return "redirect:" +"/admin/lookup";
    }

    public void pushHeaderSet(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "key=AIzaSyAxrziw6jJwqVcR3oGtqzmKipC8sSLdZLo");
    }

    //웹상으로 관리자가 푸쉬를 등록한다
    @RequestMapping(value = "allpush" ,method = RequestMethod.POST)
    public String allpush(@ModelAttribute("message") Message messag
    ){

        pushHeaderSet();


        if(messag.getKey1().equals("lesson")){
            messag.setTitle("신규 레슨 특강 신청");
            List<User> userList = pushMapper.getAllUser();

            try {

                for(int i=0; i < userList.size();i++) {

                    User query = new User();
                    query = userList.get(i);

                    logger.info(query.toString());

                GcmObject gcmObject = new GcmObject(query.getFcmToken(), messag);
                HttpEntity request = new HttpEntity(gcmObject, headers);
                result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);


                    logger.info("보내는 숫자 : " + i + " ,user : "+query.getUsername() );

                if (result.getStatusCode() != HttpStatus.OK)
                    logger.debug("전송 오류 : " + result.getStatusCode().toString()
                    );
                }

            } catch (Exception e) {
                logger.error(e.getMessage());
            }

        }else if(messag.getKey1().equals("insvideo")){
            messag.setTitle("신규강의 등록");
            logger.info("신규 비디오 강의 등록" + messag.toString());
            List<User> userList = pushMapper.getAllUser();

            try {

                for(int i=0; i < userList.size();i++) {

                    User query = new User();
                    query = userList.get(i);

                    logger.info(query.toString());

                    GcmObject gcmObject = new GcmObject(query.getFcmToken(), messag);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);



                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }

            } catch (Exception e) {
                logger.error(e.getMessage());
            }

        }else if(messag.getKey1().equals("default")){
            Message message = new Message(Push.PUSH_TITLE_ALL,messag.getContent(),messag.getMessage());
            pushService.pushExecute(Push.PUSHTYPE_ALL,0,0,0,message);
        }



        return "redirect:" +"/admin/lookup";
    }



    @RequestMapping("reqpointlist")
    public String mission(Model model){

        Report query = new Report();
        query.setFlag("N");
        query.setType("REQ_POINT");
        JSONArray jsonArray = new JSONArray();
        model.addAttribute("pointReqList", jsonArray.fromObject(reportMapper.getReportList(query)));
        return "/admin/reqpointlist";
    }

    @RequestMapping("pointexecute")
    public String pointExecute(@RequestParam("uid") int uid, @RequestParam("point") int point,@RequestParam("id") int id){

        logger.info("uid : " + uid);
        logger.info("point : " + point);
        logger.info("id : " + id);

        //포인트지급 후 REQ 테이블 업데이트
        Report report = new Report();
        report.setId(id);
        report.setFlag("Y");
        reportMapper.pointUpdateReport(report);

        SpBalanceHeader balanceHeader = new SpBalanceHeader();
        balanceHeader.setUid(uid);

        balanceHeader = selfPoinService.getSelfPointAmount(balanceHeader);

        logger.info("값은 : " + balanceHeader.toString());

        SpBalanceLine line = new SpBalanceLine();
        line.setHeaderid(balanceHeader.getHeaderid());
        line.setInamount(point);
        line.setPreviousamount(balanceHeader.getAmount());
        line.setLastamount(point + balanceHeader.getAmount());
        line.setType("EVENT");
        line.setDescription("포인트충전신청 및 지급");

        selfPoinService.saveLinePoint(line);
        selfPoinService.updateHeaderPoint(line.getHeaderid(),uid,line.getLastamount());

        return "redirect:" +"/admin/reqpointlist";
    }
}
