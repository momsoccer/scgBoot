package com.scg.api.user;

import com.scg.api.common.FcmTokenService;
import com.scg.api.googlefcm.Push;
import com.scg.api.googlefcm.PushService;
import com.scg.api.instructor.InstructorService;
import com.scg.api.point.CashPointService;
import com.scg.api.point.SelfPoinService;
import com.scg.model.Common.ServerResult;
import com.scg.model.*;
import com.scg.persistence.UserRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungbo on 2016-06-27.
 */
@RestController
@RequestMapping("/all/")
public class AllController {

    private static final Logger logger = LoggerFactory.getLogger(AllController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private SelfPoinService selfPoinService;

    @Autowired
    private CashPointService cashPointService;

    @Autowired
    private FcmTokenService fcmTokenService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private PushService pushService;



    @RequestMapping(value = "getLevel")
    public User insert(@RequestParam("uid") int uid){
        return userService.getLevel(uid);
    }

    @RequestMapping(value = "insert", method= RequestMethod.POST)
    public ServerResult insert(@RequestBody User user){

        User resultUser = new User();
        String SNSTYPE  = user.getSnstype();
        String USEREMAIL = user.getUseremail();

        logger.info("1.유저생성 userCreate() :" + user.getSnstype());
        logger.info("2.유저생성 userCreate() :" + user.getUseremail());

        //유저가 있는지 없는지 검사를 한 후에 있다면 1를 넘겨서 유저가 있음을 알리고
        //없다면 생성된 시퀀스를 넘겨 준다 이메일로 검사를 해준다

        if(user.getSnstype().equals("app")){
            logger.info("자체 회원 가입 로직을 실행합니다");
            int countUser = userService.getAcctCount(SNSTYPE,USEREMAIL);

            if(countUser==1){
                logger.info("================================");
                logger.info("이미 회원으로 가입 되어 있습니다");
                logger.info("TYPE : " + SNSTYPE);
                logger.info("EMAIL ADDRESS : " + USEREMAIL);
                logger.info("================================");

                String textDate = "1999-12-31";
                SimpleDateFormat systemToday = new SimpleDateFormat("yyyyMMdd");
                try {
                    Date today = systemToday.parse(textDate);

                    resultUser.setUid(0);
                    resultUser.setCreationdate(today);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }else{
                //자체 회원정보 생성
                resultUser = creationUser(user);
            }
        } else {
            //SNS 회원정보 생성
            logger.info("SNS정보로 회원 가입 로직을 실행합니다");

            resultUser = creationUser(user);

            logger.info("SNS정보로 회원 가입이 되었습니다");
        }

        logger.info("유저 회원 가입이 되었습니다" + resultUser.toString());

        return new ServerResult(resultUser.getUid(),"S",null,resultUser.getCommontokenid());
    }

    //회원 가입시 , self 포인트 생성
    public User creationUser(User user) {

        if(user.getSnstype().equals("app")){
            logger.info("일반회원 가입입니다.");
        }else{
            user.setPassword(user.getSnsid());
        }

        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        String secretPwd = encoder.encode(user.getPassword());
        user.setPassword(secretPwd);

        FcmToken fcmToken = new FcmToken();
        fcmToken.setFcmtoken(user.getFcmToken());
        fcmToken.setSerialnumber(user.getSerialnumber());

        userService.saveUser(user);

        logger.info("발생된 유저 아이디는 : " + user.getUid());

        fcmToken.setUid(user.getUid());
        int comomtokenid = fcmTokenService.saveFcmToken(fcmToken);

        //업데이트 후 tokenid를 한번더 업데이트
        user.setCommontokenid(fcmToken.getCommontokenid());
        userService.update(user);

        //role 생성
        Role role = new Role();
        role.setRolename("USER");
        role.setUid(user.getUid());

        logger.info("생성된 값 확인 : " + role.toString());

        //role User 생성

        userRoleMapper.saveUserRole(role);

        SpBalanceHeader header = new SpBalanceHeader();
        SpBalanceLine line = new SpBalanceLine();

        header.setUid(user.getUid());
        header.setAmount(13000);

        line.setType("JOIN");
        line.setPreviousamount(0);
        line.setInamount(13000);
        line.setOutamount(0);
        line.setLastamount(13000);
        line.setDescription("가입 포인트 지급");

        //최초 셀프포인트 지급
        selfPoinService.saveHeaderPoint(header);
        line.setHeaderid(header.getHeaderid());
        selfPoinService.saveLinePoint(line);

        //최초 현금 포인트 자료 생성
        //나중에 에러를 방지하기 위해 시드데이터 생성
        CpBalanceHeader cpHeader = new CpBalanceHeader();
        CpBalanceLine 	cpLine	= new CpBalanceLine();

        cpHeader.setUid(user.getUid());
        cpHeader.setAmount(0);

        cpLine.setType("JOIN");
        cpLine.setPrevious_amount(0);
        cpLine.setIn_amount(0);
        cpLine.setOut_amount(0);
        cpLine.setLast_amount(0);
        cpLine.setDescription("SEED");

        cashPointService.saveHeaderPoint(cpHeader);
        cashPointService.saveLinePoint(cpLine);

        //가입 푸쉬
        Message message = new Message(Push.USER_APPROVAL,user.getUsername(),"몸싸커 가입을 축하드립니다. 문제점, 문의사항 언제든 문의 주시고요. 몸싸커를 사랑해주세요");
        pushService.pushExecute(Push.PUSHTYPE_MISSION_COMMENT, 0, user.getUid(), 0, message);

        return user;
    }

    //유저의 이메일로 회원인지 아닌지 검색한다
    //http://localhost:8080/all/existuser?snstype=akkao&snsid=12313123&password=123&useremail=123123
    @RequestMapping(value = "existuser",method=RequestMethod.GET)
    public User existUser(@RequestParam String snstype,
                          @RequestParam String snsid,
                          @RequestParam String password,
                          @RequestParam String useremail){

        logger.info("회원이 존재하는지 검증을 합니다");

        User user = new User();
        user.setSnstype(snstype);

        if(snstype.equals("app")){

            user.setUseremail(useremail);

        }else{
            //카카오나 페이스북으로 가입한 유저는 snstype과 아이디로 유저 로그인 시킨다
            logger.info("SNS 로그인일 경우");
            user.setSnsid(snsid);
        }

        logger.info("유저가 존재 하는지 조회합니다." + user.toString());

        User ResultUser = new User();

        if(userService.getUserCount(user)==0) {

            logger.info("유저 없음");
            ResultUser.setUseremail("null@co.com");
            ResultUser.setUid(0);

            //날짜 값이 없을 경우 에러가 난다. 그래서 강제로 넣어준다
            Date d = new Date();
            ResultUser.setCreationdate(d);
            logger.info("유저 없음" + ResultUser.toString());

            return ResultUser;
        }else{
            logger.info("유저 있음");
            ResultUser = userService.getUser(user);
            return ResultUser;
        }
    }

    @RequestMapping(value = "updateToken", method = RequestMethod.POST)
    public ServerResult updateToken(@RequestBody FcmToken fcmToken) {
        logger.info("푸쉬 토큰 값을 업데이트 합니다 : " + fcmToken.toString());

        fcmTokenService.updateFcmToken(fcmToken);

        return new ServerResult(1,"S","정상 토큰 작업 수행함(업데이트)");
    }

    @RequestMapping(value = "saveToken", method = RequestMethod.POST)
    public ServerResult saveToken(@RequestBody FcmToken fcmToken) {
        logger.info("푸쉬 토큰 값을 생성합니다 : " + fcmToken.toString());

        int tokenid = fcmTokenService.saveFcmToken(fcmToken);

        return new ServerResult(1,"S","정상 토큰 작업 수행함(인설트)");
    }

    @RequestMapping(value = "getEmailFind", method = RequestMethod.POST)
    public ServerResult getEmailFind(@RequestBody User user) {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        String secretPwd = encoder.encode(user.getPassword());
        user.setPassword(secretPwd);
        userService.updateUser(user);
        return new ServerResult(1,"S");

    }

}
