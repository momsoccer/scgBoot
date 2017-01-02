package com.scg.api.team;

import com.scg.api.common.UploadFunction;
import com.scg.api.googlefcm.Push;
import com.scg.api.googlefcm.PushService;
import com.scg.api.instructor.InstructorService;
import com.scg.api.user.UserService;
import com.scg.datadto.FeedDataVo;
import com.scg.model.Common.ServerResult;
import com.scg.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungbo on 2016-06-24.
 */
@RestController
@RequestMapping("/api/team/")
public class TeamController {

    private static final Logger logger = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    TeamService teamService;

    @Autowired
    PushService pushService;

    @Autowired
    InstructorService instructorService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "getTeamCount")
    public FeedDataVo getTeamCount(@RequestParam("insid")int insid){
        return teamService.getTeamCount(insid);
    }

    @RequestMapping(value = "getMyTeaminfo")
    public Team getMyTeaminfo(@RequestParam("uid")int uid){
        return teamService.getMyTeaminfo(uid);
    }

    @RequestMapping(value = "getMyTeam")
    public ServerResult getMyTeam(@RequestParam("uid")int uid){
        TeamMember myTeam = teamService.getMyTeam(uid);
        return new ServerResult(myTeam.getTeamid(),"S");
    }

    @RequestMapping(value = "getReqMember")
    public List<TeamApply> getReqMember(@RequestParam("insid")int insid,@RequestParam("status")String status){
        return teamService.getReqMember(insid,status);
    }

    //제자신청 받아들일때
    @RequestMapping(value = "acceptMember")
    public ServerResult acceptMember(@RequestParam("applyid")int applyid){

        logger.info("id : " + applyid);

        TeamApply teamApply = new TeamApply();
        teamApply.setApplyid(applyid);
        teamApply.setApproval("APPROVAL");
        teamService.teamApplyUpdate(teamApply);

        teamApply = teamService.getTeamApply(teamApply);

        //TEammemeber
        TeamMember teamMember = new TeamMember();
        teamMember.setTeamid(teamApply.getTeamid());
        teamMember.setAuthority("MEMBER");
        teamMember.setUid(teamApply.getUid());
        teamMember.setEnabled("Y");
        teamService.saveTeamMember(teamMember);

        User user = new User();
        user.setUid(teamApply.getUid());
        user = userService.getInsUser(user);

        //가입 승인 푸쉬를 보내준다
        Message message = new Message(Push.PUSH_TITLE_TEAM_JOIN_APPROVAL,user.getUsername(),Push.TEAM_JOIN_APPROVAL);
        pushService.pushExecute(Push.PUSHTYPE_REQ_TEAMAPPROVAL, 0, teamApply.getUid(), 0, message);
        return new ServerResult(1,"S");
    }

    //제자신청 삭제시
    @RequestMapping(value = "rejectMember")
    public ServerResult rejectMember(@RequestParam("applyid")int applyid){
        TeamApply teamApply = new TeamApply();
        teamApply.setApplyid(applyid);
        teamService.deleteTeamApply(teamApply);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "applyTeam",method = RequestMethod.POST)
    public ServerResult applyTeam(@RequestBody TeamApply apply){
        teamService.teamApplySave(apply);

        logger.info("가입 요청 : " + apply.toString());

        //강사에게 푸쉬보내기
        Message message = new Message(Push.PUSH_TITLE_TEAM_JOIN_REQ,apply.getUsername(),Push.TEAM_JOIN_MESSAGE);
        pushService.pushExecute(Push.PUSHTYPE_REQ_TEAMJOIN, apply.getInstructorid(), 0, 0, message);

        return new ServerResult(1,"S");
    }

    @RequestMapping(value ="getTeamApply" ,method = RequestMethod.POST)
    public TeamApply getTeamApply(@RequestBody TeamApply apply){
        return teamService.getTeamApply(apply);
    }

    @RequestMapping(value ="deleteTeamApply" ,method = RequestMethod.POST)
    public ServerResult deleteTeamApply(@RequestBody TeamApply apply){

        logger.info("제자 및 제자 멤버 삭제 요청 : " + apply.toString());

        teamService.deleteTeamApply(apply);
        teamService.deleteTeamMember(apply.getTeamid(),apply.getUid());

        return new ServerResult(1,"S");
    }

    @RequestMapping("getTeamMemeber")
    public TeamMember getTeamMemeber(@RequestBody TeamMember teamMember){
        return teamService.getTeamMemeber(teamMember);
    }


    //팀 생성 및 업데이트 처리
    @RequestMapping(value="saveteam", method= RequestMethod.POST)
    public Team makeTeam(HttpServletRequest request,
                                   @RequestParam(value = "insid", required = false) String insid,
                                   @RequestParam(value = "teamname", required = false) String teamname,
                                   @RequestParam(value = "teamdisp", required = false) String teamdisp,
                                   @RequestParam(value = "filename", required = false) String filename,
                                   @RequestParam(value = "profileimgurl", required = false) String profileimgurl,
                                   @RequestParam(value = "trFlag", required = false) String transactionFlag,
                                   @RequestParam(value = "file", required = false) MultipartFile file) {

        logger.info("매개변수 : "+ insid);
        logger.info("매개변수 : "+ teamname);
        logger.info("매개변수 : "+ teamdisp);
        logger.info("매개변수 : "+ filename);
        logger.info("매개변수 : "+ transactionFlag);
        logger.info("매개변수 : "+ profileimgurl);

        if (!file.isEmpty()) {

            String picture = filename;

            //서버에 올리때는 아래 경로를 로컬일때는 target 폴더임..
            String rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/teamimg/";

            UploadFunction uploadFunction = new UploadFunction();

            uploadFunction.writeFile(file, picture, request, rootPath);
        }

        Team team = new Team();
        team.setInstructorid(Integer.parseInt(insid));
        team.setName(teamname);
        team.setDescription(teamdisp);
        team.setEmblem(profileimgurl);
        team.setEnabled("Y");

        int teamid = teamService.teamSave(team);

        Team resultTeam = teamService.getTeam(team);

        return resultTeam;
    }

    @RequestMapping(value = "getTeamNameList")
    public ArrayList<String> getTeamNameList(){
        return teamService.getTeamNameList();
    }

}
