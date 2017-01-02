package com.scg.api.android;

import com.scg.api.common.UploadFunction;
import com.scg.api.team.TeamService;
import com.scg.model.Common.ServerResult;
import com.scg.model.TeamMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by sungbo on 2016-07-01.
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);


    @Autowired
    TeamService teamService;

    @RequestMapping(value="/all/getTeamMemberList", method= RequestMethod.GET)
    public List<TeamMember> teamMemList(){

        TeamMember teamMember = new TeamMember();

        return teamService.getTeamMemeberList(teamMember);
    }

    @RequestMapping(value="/all/testi", method= RequestMethod.GET)
    public Result test(){
        logger.info("테스트 컨트롤러 입니다. 시큐리티 테스트");
        return new Result("값은.....");
    }

    @RequestMapping(value="/all/team/upload", method= RequestMethod.POST)
    public Result uploadTest(HttpServletRequest request,
            @RequestParam(value = "filename", required = false) String filename,
            @RequestParam(value = "file", required = false) MultipartFile file
            )
    {

        logger.info("팀 생성 컨트롤러를 호출 합니다 " + filename);

        try {
            logger.info("팀 생성 컨트롤러를 호출 합니다 " + file.toString());

            logger.info("파일명 : " + file.getName());
            logger.info("파일명 : " + file.getContentType());
            logger.info("파일명 : " + file.getSize());

        }catch (Exception e){
            logger.info("에러 발생 " + e.getMessage());
            e.printStackTrace();
        }

        if (!file.isEmpty()) {

            String picture = filename;

            //서버에 올리때는 아래 경로를 로컬일때는 target 폴더임..
            String rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/teamimg/";

            UploadFunction uploadFunction = new UploadFunction();

            uploadFunction.writeFile(file, picture, request, rootPath);
        }

        return new Result("성공");
    }

   public class Result {

       private String name;

       public Result(String name) {
           this.name = name;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

   }


    @RequestMapping(value="/api/ins/testMain", method= RequestMethod.GET)
    public ServerResult testMain(){
        logger.info("테스트 컨트롤러 입니다. 시큐리티 테스트");
        return new ServerResult(1,"S");
    }

}
