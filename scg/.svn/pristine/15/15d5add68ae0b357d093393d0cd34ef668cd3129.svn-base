package com.scg.ins;

import com.scg.api.Follow.FollowController;
import com.scg.api.common.UploadFunction;
import com.scg.api.instructor.InstructorService;
import com.scg.api.team.TeamService;
import com.scg.api.user.IndicatorService;
import com.scg.api.user.UserService;
import com.scg.datadto.InsPointBalance;
import com.scg.ins.service.InsService;
import com.scg.ins.vo.InsApplyVo;
import com.scg.model.Common.ServerResult;
import com.scg.model.Instructor;
import com.scg.model.Team;
import com.scg.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by sungbo on 2016-08-11.
 */
@RestController
@RequestMapping("/ins/")
public class AppController {

    private static final Logger logger = LoggerFactory.getLogger(FollowController.class);

    @Autowired
    InsService insService;

    @Autowired
    IndicatorService indicatorService;

    @Autowired
    UserService userService;

    @Autowired
    InstructorService instructorService;

    @Autowired
    TeamService teamService;


    //팀 생성 및 업데이트 처리
    @RequestMapping(value = "userFileupload", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
    public ServerResult fileupLoad(HttpServletRequest request,
                                   @RequestParam("uid") String uid,
                                   @RequestParam("userfileAddr") String userfileAddr,
                                   @RequestParam("filename") String filename,
                                   @RequestParam("file") MultipartFile file,
                                   @RequestParam("teamStatus") String teamStatus,
                                   @RequestParam("insfileAddr") String insfileAddr
    ){

        try {
            if (!file.isEmpty()) {

                String picture = filename;

                //서버에 올리때는 아래 경로를 로컬일때는 target 폴더임..
                String rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/userimg";
                String ins_rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/instructorimg";

                UploadFunction uploadFunction = new UploadFunction();
                uploadFunction.writeFile(file, picture, request, rootPath);

                if(teamStatus.equals("APPROVAL")){
                    UploadFunction uploadFunctionIns = new UploadFunction();
                    uploadFunctionIns.writeFile(file, picture, request, ins_rootPath);
                }

            }

            User user = new User();
            user.setUid(Integer.parseInt(uid));
            user.setProfileimgurl(userfileAddr);
            userService.update(user);

            if(teamStatus.equals("APPROVAL")){
                Instructor instructor = new Instructor();
                instructor.setUid(Integer.parseInt(uid));
                instructor.setProfileimgurl(insfileAddr);
                instructorService.updateInstructor(instructor);
            }

            return new ServerResult(1, "S");
        }catch (Exception e){
            logger.info("Error : " + e.getMessage());
            return new ServerResult(0, "E");
        }
    }

    @RequestMapping(value = "insApplyfile", method = RequestMethod.POST , headers = "Content-Type=multipart/form-data")
         public ServerResult fileupLoad(HttpServletRequest request,
                                        @RequestParam("uid") String uid,
                                        @RequestParam("updateflag") String updateflag,
                                        @RequestParam("fileaddr") String fileaddr,
                                        @RequestParam("filename") String filename,
                                        @RequestParam("file") MultipartFile file
    ){
        logger.info("recieve vale : " + filename);
        logger.info("file size : "+file.getSize());
        logger.info("file name : "+file.getName());

        logger.info("updateflag : "+updateflag);

        try {
            if (!file.isEmpty()) {

                String picture = filename;

                //서버에 올리때는 아래 경로를 로컬일때는 target 폴더임..
                String rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/teamimg/";

                UploadFunction uploadFunction = new UploadFunction();

                uploadFunction.writeFile(file, picture, request, rootPath);
            }

            if(updateflag.equals("Y")){

                InsApplyVo insApplyVo = new InsApplyVo();
                insApplyVo.setUid(Integer.parseInt(uid));
                insApplyVo.setTeamimg(fileaddr);
                insService.updateIns(insApplyVo);
            }else{

                logger.info("이미강사인 팀 정보 업데이트");

                InsApplyVo insApplyVo = new InsApplyVo();
                insApplyVo.setUid(Integer.parseInt(uid));
                insApplyVo.setTeamimg(fileaddr);
                insService.updateIns(insApplyVo);

                //팀도 반영해준다
                Instructor instructor = new Instructor();
                instructor.setUid(Integer.parseInt(uid));
                instructor = instructorService.getInstrutor(instructor);

                Team team = new Team();
                team.setInstructorid(instructor.getInstructorid());
                team.setEmblem(fileaddr);
                teamService.teamUpdate(team);

            }


            return new ServerResult(1, "S");
        }catch (Exception e){
            logger.info("Error : " + e.getMessage());
            return new ServerResult(0, "E");
        }
    }

    @RequestMapping(value = "insApply", method = RequestMethod.POST)
    public ServerResult fileupLoad(@RequestBody InsApplyVo vo){
        logger.info("받은 값은 : " + vo.toString());
        insService.saveIns(vo);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "updateIns",method = RequestMethod.POST)
    public ServerResult updateIns(@RequestBody InsApplyVo vo){
        insService.updateIns(vo);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ServerResult delete(@RequestBody InsApplyVo vo){
        insService.delete(vo);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "getListIns",method = RequestMethod.POST)
    public List<InsApplyVo> getListIns(@RequestBody InsApplyVo vo){
        return insService.getListIns(vo);
    }

    @RequestMapping(value = "getIns",method = RequestMethod.POST)
    public InsApplyVo gettIns(@RequestBody InsApplyVo vo){
        InsApplyVo insApplyVo = insService.getIns(vo);
        logger.info("ins : " + insApplyVo.toString());
        return insApplyVo;
    }

    //강사포인트 수입내역
    @RequestMapping(value = "getInsPointBalanceList")
    public List<InsPointBalance> getInsPointBalanceList(@RequestParam("insid") int insid){
        return insService.getInsPointBalanceList(insid);
    }
}
