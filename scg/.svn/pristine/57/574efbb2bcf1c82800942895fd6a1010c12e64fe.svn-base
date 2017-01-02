package com.scg.api.user;

import com.scg.api.common.UploadFunction;
import com.scg.api.instructor.InstructorService;
import com.scg.api.point.CashPointService;
import com.scg.api.point.SelfPoinService;
import com.scg.api.user.common.PointTransaction;
import com.scg.model.Common.ServerResult;
import com.scg.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sungbo on 2016-06-27.
 */
@RestController
@RequestMapping("/api/user/")
public class Controller {


    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SelfPoinService selfPoinService;

    @Autowired
    private CashPointService cashPointService;

    @Autowired
    private IndicatorService indicatorService;

    @Autowired
    private InstructorService instructorService;

    @RequestMapping(value = "updateUserSetup",method = RequestMethod.POST)
    public ServerResult updateUser(@RequestBody User user){
        userService.updateUser(user);

        //강사라면 강사 이름도 변경
        Instructor instructor = new Instructor();
        instructor.setUid(user.getUid());
        instructor.setName(user.getUsername());
        instructorService.updateInstructor(instructor);

        return new ServerResult(1,"S");
    }


    @RequestMapping(value = "userCheck", method = RequestMethod.GET)
    public ServerResult userCheck(@RequestParam String snstype,
                                  @RequestParam String email){

        logger.info("sns타입은  : " + snstype);
        logger.info("유저아이디는  : " + email);

        ServerResult serverResult = new ServerResult();

        if(userService.getAcctCheck(snstype, email)==0){
            serverResult.setCount(0);
            serverResult.setResult("회원이 존재하지 않습니다");
            logger.info("유저가 없음");
        }else{
            serverResult.setCount(1);
            serverResult.setResult(email +" 님은 회원입니다 반갑습니다");
            logger.info("유저가 있음");
        }
        logger.info("리턴 값은 : " + serverResult.toString());
        return serverResult;
    }


    @RequestMapping(value = "update",method=RequestMethod.POST)
    public ServerResult update(@RequestBody User user){

        try{
            userService.update(user);
            return new ServerResult(1,"S");
        }catch (Exception e){
            e.printStackTrace();
            return new ServerResult(0,"E","오류 발생 : "+e.getMessage());
        }

    }


    @RequestMapping(value = "selfpointamount",method=RequestMethod.GET)
    public SpBalanceHeader getSelfAmt(
            @RequestParam("uid") int uid
    ){
        SpBalanceHeader header = new SpBalanceHeader();
        header.setUid(uid);
        SpBalanceHeader resultHeader = selfPoinService.getSelfPointAmount(header);
        logger.info("셀프 포인트 정보 : " + resultHeader.toString());
        return resultHeader;
    }

    @RequestMapping(value = "cashpointamount",method=RequestMethod.GET)
    public CpBalanceHeader getCashAmt(@RequestParam("uid") int uid){

        CpBalanceHeader header = new CpBalanceHeader();
        header.setUid(uid);
        CpBalanceHeader resultHeader = cashPointService.getCpfPointAmount(header);
        logger.info("Cash 포인트 정보 : " + resultHeader.toString());
        return resultHeader;
    }

    //String 검증일경우 creation과 exist를 리턴 고유 문자로 활용한다
    @RequestMapping(value = "userdailycheck",method = RequestMethod.GET)
    public ServerResult userdailycheck(
            HttpServletRequest request,
    @RequestParam("uid") String uid,
            @RequestParam("pointtype")String pointtype,
            @RequestParam("lang")String lang){

/*          HttpServletRequest 전송바디읽기
        Enumeration enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            logger.info("1 : " + enumeration.nextElement().toString());
        }*/

        Cookie[] coolies = request.getCookies();

        for(int i=0;i<coolies.length;i++){
            logger.info(coolies[i].getName());

        }

        logger.info("출석체크를 시도합니다");

        //YYYYMMDD 일자를 만든다
        Date today = new Date();
        SimpleDateFormat systemToday = new SimpleDateFormat("yyyyMMdd");

        int dbUid = Integer.parseInt(uid);

        int dailyCount = indicatorService.getdailycheck(uid, systemToday.format(today));

        if(dailyCount==0){

            UserDailyHistory history = new UserDailyHistory();

            history.setUid(dbUid);
            history.setDescription(systemToday.format(today) + " : 일일출석 포인트 지급");
            history.setYyyymmdd(systemToday.format(today));

            indicatorService.savedailyUser(history);
            PointTransaction pointTransaction = new PointTransaction(selfPoinService,dbUid,"+",pointtype,lang);
            int amount = pointTransaction.SelfPointTr();

            ServerResult serverResult = new ServerResult(amount,String.valueOf(amount));

            return serverResult;
        }else{
            ServerResult serverResult = new ServerResult(0,"exist");
            return serverResult;
        }
    }

    @RequestMapping("pointlist")
    public List<PointManagement> pointlist(){
        logger.info("/api/user/pointlist 접근 성공");
        return indicatorService.getPointList();
    }

    //팀 생성 및 업데이트 처리
    @RequestMapping(value = "fileupload", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
    public ServerResult fileupLoad(HttpServletRequest request,
                                   @RequestParam("imgtype") String imgtype,
                                   @RequestParam("uid") String uid,
                                   @RequestParam("filename") String filename,
                                   @RequestParam("profileimgurl") String profileimgurl,
                                   @RequestParam("file") MultipartFile file
    ){
        logger.info("유저 사진 파일 업로드 호출");

        try {

            String upfileName = file.getOriginalFilename();
            int dbUid = Integer.parseInt(uid);

            if (!file.isEmpty()) {

                String picture = filename;

                //서버에 올리때는 아래 경로를 로컬일때는 target 폴더임..
                String rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/userimg/";

                UploadFunction uploadFunction = new UploadFunction();

                uploadFunction.writeFile(file, picture, request, rootPath);
            }

            User user = new User();
            user.setUid(dbUid);
            if(imgtype.equals("front")){
                user.setProfileimgurl(profileimgurl);

                logger.info("파일 업로드 후 생성 완료");
                logger.info("UID : " + dbUid);
                logger.info("파일 명 : " + filename);

                //강사라면 강사 이미지도 변경
                Instructor instructor = new Instructor();
                instructor.setUid(dbUid);
                instructor.setProfileimgurl(profileimgurl);
                instructorService.updateInstructor(instructor);

            }else{
                user.setBackimage(profileimgurl);
            }

            userService.update(user);

            return new ServerResult(1, "S");
        }catch (Exception e){
            logger.info("Error : " + e.getMessage());
            return new ServerResult(0, "E");
        }
    }


    @RequestMapping(value = "getusersearchlist" , method = RequestMethod.POST)
    public List<User> getUserSearchList(@RequestBody User user){
        logger.info("쿼리 값은 : " + user.toString());
        return userService.getUserSearchList(user);
    }

    @RequestMapping(value = "getProfileUser" , method = RequestMethod.GET)
         public User getProfileUser(@RequestParam("uid") int uid){

        logger.info("컬했습니다 : " + uid);

        return userService.getProfileUser(uid);
    }


}
