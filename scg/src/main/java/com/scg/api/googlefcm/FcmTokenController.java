package com.scg.api.googlefcm;

import com.scg.api.common.FcmTokenService;
import com.scg.api.instructor.InstructorService;
import com.scg.api.user.UserService;
import com.scg.model.Common.ServerResult;
import com.scg.model.FcmToken;
import com.scg.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sungbo on 2016-09-13.
 */
@RestController
@RequestMapping("/fcm/token/")
public class FcmTokenController {

    private static final Logger logger = LoggerFactory.getLogger(FcmTokenController.class);

    @Autowired
    FcmTokenService fcmTokenService;

    @Autowired
    UserService userService;

    @Autowired
    InstructorService instructorService;

    @Autowired
    PushService pushService;
    /*********
    앱이 실행 될때마다 토큰을 검증
     *********/

    private int commontokenid = 0;

    @RequestMapping(value = "setupToken",method = RequestMethod.POST)
    public ServerResult setupToken(@RequestBody FcmToken token){

        logger.info("토큰 체크");

        FcmToken fcmToken = new FcmToken();
        fcmToken = fcmTokenService.getFcmToken(token);
        //1.만약 기계와 아이디루 토큰이 없다면 토큰 값을 인설트 한다
        if(fcmToken.getUid()==0){
            commontokenid = fcmTokenService.saveFcmToken(token);

            User user = new User();
            user.setUid(token.getUid());
            user.setCommontokenid(commontokenid);
            userService.update(user);

        }else{
            fcmTokenService.updateFcmToken(token);
        }

        return new ServerResult(1,"S");
    }
}
