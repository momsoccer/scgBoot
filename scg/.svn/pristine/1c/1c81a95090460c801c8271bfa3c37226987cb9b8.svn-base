package com.scg.test.api;

import com.scg.api.common.FcmTokenService;
import com.scg.model.GcmObject;
import com.scg.model.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * Created by KIMU on 2016. 6. 29..
 */
@RestController
@RequestMapping("/all/")
public class GCMControllerTest {
    protected Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private FcmTokenService fcmTokenService;

    @RequestMapping(value = "sendFcm")
    public String sendGcm() {

        String fcmString="dqZXAsncTZ4:APA91bEarmS_iCTWpIJivTkQvsD8drvM7t_ly3QMpVVR5mmFpuJkBvKg5zqUwlixGTAQNk0cGFvXiqpSpbl3vStU2eghw_nEKVBJKwtt-5R2PU-ZHPR5TfyzLRwvgdpqnoVzvbFZCvVv";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HashMap> result;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "key=AIzaSyAxrziw6jJwqVcR3oGtqzmKipC8sSLdZLo");

        try {
            //List<FcmToken> list = fcmTokenService.getFcmTokenList(new FcmToken());

            //for (FcmToken f : list) {
                Message message = new Message("타이틀","콘텐트","메세지","lesson","키투입니다");

                GcmObject gcmObject = new GcmObject(fcmString, message);
                HttpEntity request = new HttpEntity(gcmObject, headers);
                result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                if (result.getStatusCode() != HttpStatus.OK)
                    logger.debug("전송 오류 : " + result.getStatusCode().toString());
            //}
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return "완료";
    }
}
