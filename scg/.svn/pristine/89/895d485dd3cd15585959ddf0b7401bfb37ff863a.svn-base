package com.scg.api.instructor;

import com.scg.api.common.FcmTokenService;
import com.scg.api.common.UploadFunction;
import com.scg.api.team.TeamService;
import com.scg.api.user.UserService;
import com.scg.ins.vo.InsInfoVo;
import com.scg.model.Common.ServerResult;
import com.scg.model.*;
import com.scg.persistence.UserRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by sungbo on 2016-06-01.
 * 강사 테이블 Controller
 */
@RestController
public class InstructorController {

    private static final Logger logger = LoggerFactory.getLogger(InstructorController.class);

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private FcmTokenService fcmTokenService;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private TeamService teamService;


    @RequestMapping(value = "/api/ins/getFindIns")
    public Instructor getFindIns(@RequestParam("uid") int insId){
        return instructorService.getFindIns(insId);
    }


    @RequestMapping(value="/all/ins/saveInstructor", method= RequestMethod.POST)
    public ServerResult insert(
            @RequestBody Instructor instructor
    ){
        logger.info("insert 실행 : " + instructor.toString());

        try{
            //비번 암호화 작업
            StandardPasswordEncoder encoder = new StandardPasswordEncoder();
            String secretPwd = encoder.encode(instructor.getPassword());
            instructor.setPassword(secretPwd);

            FcmToken fcmToken = new FcmToken();
            fcmToken.setFcmtoken(instructor.getFcmtoken());
            fcmToken.setSerialnumber(instructor.getSerialnumber());

            int insId = instructorService.saveInstructor(instructor);

            if(insId==-5){
                logger.info("이미 계정이 존재합니다.");
                return new ServerResult(-5,"E","이미 있는 아이디");
            }


            fcmToken.setInstructorid(instructor.getInstructorid());
            int comomtokenid = fcmTokenService.saveFcmToken(fcmToken);
            instructor.setCommontokenid(comomtokenid);
            instructorService.updateInstructor(instructor);

            //강사도 시큐리티 통과를 위해 가상의 권한을 만들어 준다
            User user = new User();
            user.setUseremail(instructor.getEmail());
            user.setPassword(instructor.getPassword());
            user.setUsername("[INS]"+instructor.getName());

            //강사용 유저를 생성 최소단위
            userService.saveUser(user);

            //role 생성
            Role role = new Role();
            role.setRolename("INS");
            role.setUid(user.getUid());

            userRoleMapper.saveUserRole(role);

            //비디오, 글자 피드백관련 금액 설정
            InstructorPointHistory pointHistory = new InstructorPointHistory();
            pointHistory.setInstructorid(instructor.getInstructorid());
            pointHistory.setPubvideopoint(0);
            pointHistory.setPubwordpoint(0);
            pointHistory.setTeamvideopoint(0);
            pointHistory.setTeamwordpoint(0);
            pointHistory.setTeamjoinpoint(0);
            instructorService.savePointHistory(pointHistory);

            //강사마다 팀을 생성 하도록 해준다.
            Team team = new Team();
            team.setInstructorid(instructor.getInstructorid());
            team.setName(instructor.getName() + "-Team");
            team.setDescription(instructor.getDescription()+" Default Team");
            team.setEnabled("Y");
            team.setApproveflag("N");
            teamService.teamSave(team);

            return new ServerResult(instructor.getInstructorid(),"S");
        }catch (Exception e){
            e.printStackTrace();
            return new ServerResult(0,"E");
        }
    }

    @RequestMapping(value="/api/ins/insLogin", method= RequestMethod.POST)
    public Instructor insLogin(@RequestBody Instructor instructor){
        Instructor gerIns = instructorService.getInstrutor(instructor);
        return gerIns;
    }


    @RequestMapping(value="update", method= RequestMethod.POST)
    public ServerResult update(@RequestBody Instructor instructor){

        try{
            instructorService.updateInstructor(instructor);
            return new ServerResult(1,"S");
        }catch (Exception e){
            logger.info("Error : " + e.getMessage());
            return new ServerResult(0,"E");
        }

    }

    @RequestMapping(value = "/api/ins/fileupload", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
    public ServerResult fileupLoad(HttpServletRequest request,
                                   @RequestParam("instructorid") String insId,
                                   @RequestParam("filename") String filename,
                                   @RequestParam("profileimgurl") String profileimgurl,
                                   @RequestParam("file") MultipartFile file
    ){
        logger.info("instructorid : "+insId);
        logger.info("filename : "+filename);
        logger.info("profileimgurl : "+profileimgurl);
        logger.info("profileimgurl : "+file.getSize());

        try {

            int instructorId = Integer.parseInt(insId);

            if (!file.isEmpty()) {

                String picture = filename;

                //서버에 올리때는 아래 경로를 로컬일때는 target 폴더임..
                String rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/instructorimg/";

                UploadFunction uploadFunction = new UploadFunction();

                uploadFunction.writeFile(file, picture, request, rootPath);
            }

            Instructor instructor = new Instructor();
            instructor.setInstructorid(instructorId);
            instructor.setProfileimgurl(profileimgurl);

            logger.info("저장 값은 : " + instructor.toString());

            instructorService.updateInstructor(instructor);

            logger.info("파일 업로드 후 생성 완료");
            logger.info("UID : " + instructorId);
            logger.info("파일 명 : " + filename);

            return new ServerResult(1, "S");
        }catch (Exception e){
            logger.info("Error : " + e.getMessage());
            return new ServerResult(0, "E");
        }
    }

    @RequestMapping(value = "/api/ins/getPointHis" , method = RequestMethod.GET)
    public InstructorPointHistory getPointHis(@RequestParam("insid") int insid){
        logger.info("강사의 정보 : " +insid);
        return instructorService.getPointHis(insid);
    }

    @RequestMapping(value = "/all/team/getInstructorList")
    public List<Instructor> getInstructorList(){
        Instructor instructor = new Instructor();
        return instructorService.getInstrutorList(instructor);
    }

    @RequestMapping(value = "/api/ins/getCoachSearchList", method = RequestMethod.POST)
    public List<Instructor> getFindInsList(@RequestBody Instructor instructor){
        return instructorService.getCoachSearchList(instructor);
    }

    @RequestMapping("/api/ins/getInsInfoApply")
    public InsInfoVo getInsInfoApply(@RequestParam("insid") int insid){
        logger.info("강사번호는 : " + insid );
        return instructorService.getInsInfoApply(insid);
    }

}
