package com.scg.api.googlefcm;

import com.scg.model.GcmObject;
import com.scg.model.Instructor;
import com.scg.model.Message;
import com.scg.model.User;
import com.scg.persistence.PushMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sungbo on 2016-09-14.
 */
@Service
public class PushService {

    private static final Logger logger = LoggerFactory.getLogger(PushService.class);

    @Autowired
    PushMapper pushMapper;


    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<HashMap> result;
    HttpHeaders headers = new HttpHeaders();

    String fcmString = "cnP73mq9_cU:APA91bHfRwL_RqOjrRh45mGDjnjhdl-t82lHLdHBN2XrXyWlLUb81oOzTErPfxHtrLRl8xS3yid3v2AOSdYt5ECcPgyjfjE_fV9ifWHviz2WdPswFtvg_597NmVjm8SiFgzIUm5wxPKP";

    public List<User> getUserPushList(User user){
        return pushMapper.getUserPushList(user);
    };

    public User getUserPush(User user){
        return pushMapper.getUserPush(user);
    };

    public List<Instructor> getInsPushList(Instructor instructor){
        return pushMapper.getInsPushList(instructor);
    };

    //전체 유저에게 보내는 푸쉬

    //팀유저들에게 보내는 푸쉬(선생님의 팀 게시글)
    public void pushExecute(String pushType,int insid, int uid, int teamid,Message message){

        pushHeaderSet();

        User query = new User();
        Instructor instructor = new Instructor();

        message.setKey1("default");

        if(pushType.equals("test")){

            try {
                    logger.info("값은 : " + message.toString());

                    GcmObject gcmObject = new GcmObject(fcmString, message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );

            } catch (Exception e) {
                logger.error(e.getMessage());
            }


        }else if(pushType.equals(Push.PUSHTYPE_TEAM)){

            query.setTeamid(teamid);
            List<User> userList = pushMapper.getUserPushList(query);
            try {
                for(int i=0; i < userList.size();i++){
                    query = userList.get(i);
                    GcmObject gcmObject = new GcmObject(query.getFcmToken(), message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }

            //댓글이 달렸을 경우 원 게시자에게 메세지 발송
        }else if(pushType.equals(Push.PUSHTYPE_COMMENT_USER)){
            try {
                query.setUid(uid);
                User user = new User();
                List<User> userList = pushMapper.getUserPushList(query);
                try {
                    for(int i=0; i < userList.size();i++){
                        query = userList.get(i);
                        GcmObject gcmObject = new GcmObject(query.getFcmToken(), message);
                        HttpEntity request = new HttpEntity(gcmObject, headers);
                        result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                        if (result.getStatusCode() != HttpStatus.OK)
                            logger.debug("전송 오류 : " + result.getStatusCode().toString()
                            );
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }

            //전체공지
        }else if(pushType.equals(Push.PUSHTYPE_ALL)){

            List<User> userList = pushMapper.getAllUser();

            try {

                for(int i=0; i < userList.size();i++){

                        logger.info("전송시작");

                        query = userList.get(i);
                        GcmObject gcmObject = new GcmObject(query.getFcmToken(), message);
                        HttpEntity request = new HttpEntity(gcmObject, headers);
                        result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                        if (result.getStatusCode() != HttpStatus.OK)
                            logger.debug("전송 오류 : " + result.getStatusCode().toString()
                            );
                }

            } catch (Exception e) {
                logger.error(e.getMessage());
            }




            //유저가 피드백 요청을 할때 강사에게 날리기
        }else if(pushType.equals(Push.PUSHTYPE_FEEDBACK_INS)){

            try {
                instructor.setInstructorid(insid);
                List<Instructor> insPushList = pushMapper.getInsPushList(instructor);

                for(int i =0 ; i < insPushList.size(); i++){
                    GcmObject gcmObject = new GcmObject(insPushList.get(i).getFcmtoken(), message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }

            //강사가 유저에게 피드백 작성시....
        }else if(pushType.equals(Push.PUSHTYPE_FEEDBACK_USER)){
            try {
                query.setUid(uid);
                List<User> userList = pushMapper.getUserPushList(query);
                try {
                    for(int i=0; i < userList.size();i++){
                        query = userList.get(i);
                        GcmObject gcmObject = new GcmObject(query.getFcmToken(), message);
                        HttpEntity request = new HttpEntity(gcmObject, headers);
                        result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                        if (result.getStatusCode() != HttpStatus.OK)
                            logger.debug("전송 오류 : " + result.getStatusCode().toString()
                            );
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }

            //심사요청을 강사에게 보낼경우 강사가 받음
        }else if(pushType.equals(Push.PUSHTYPE_FEEDBACK_EVAL_INS)){
            try {
                instructor.setInstructorid(insid);
                List<Instructor> insPushList = pushMapper.getInsPushList(instructor);

                for(int i =0 ; i < insPushList.size(); i++){
                    GcmObject gcmObject = new GcmObject(insPushList.get(i).getFcmtoken(), message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }else if(pushType.equals(Push.PUSHTYPE_FEEDBACK_EVAL_USER)){
            query.setUid(uid);
            List<User> userList = pushMapper.getUserPushList(query);
            try {
                for(int i=0; i < userList.size();i++){
                    query = userList.get(i);
                    GcmObject gcmObject = new GcmObject(query.getFcmToken(), message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }else if(pushType.equals(Push.PUSHTYPE_FRIEND_REQ)){

            query.setUid(uid);
            query.setUid(uid);
            List<User> userList = pushMapper.getUserPushList(query);
            try {
                for(int i=0; i < userList.size();i++){
                    query = userList.get(i);
                    GcmObject gcmObject = new GcmObject(query.getFcmToken(), message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }

        }else if(pushType.equals(Push.PUSHTYPE_MISSION_COMMENT)){
            //내 미션에 코멘트를 달경우
            query.setUid(uid);
            List<User> userList = pushMapper.getUserPushList(query);
            try {
                for(int i=0; i < userList.size();i++){
                    query = userList.get(i);
                    GcmObject gcmObject = new GcmObject(query.getFcmToken(), message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }else if(pushType.equals(Push.PUSHTYPE_REQ_TEAMJOIN)){
            try {
                instructor.setInstructorid(insid);
                List<Instructor> insPushList = pushMapper.getInsPushList(instructor);

                for(int i =0 ; i < insPushList.size(); i++){
                    GcmObject gcmObject = new GcmObject(insPushList.get(i).getFcmtoken(), message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }else if(pushType.equals(Push.PUSHTYPE_REQ_TEAMAPPROVAL)){
            query.setUid(uid);
            List<User> userList = pushMapper.getUserPushList(query);
            try {
                for(int i=0; i < userList.size();i++){
                    query = userList.get(i);
                    GcmObject gcmObject = new GcmObject(query.getFcmToken(), message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }else if(pushType.equals(Push.PUSHTYPE_APPROVAL_INS)){
            query.setUid(uid);
            List<User> userList = pushMapper.getUserPushList(query);
            try {
                for(int i=0; i < userList.size();i++){
                    query = userList.get(i);
                    GcmObject gcmObject = new GcmObject(query.getFcmToken(), message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }else if(pushType.equals(Push.PUSHTYPE_JOIN_EXECUTE)){
            query.setUid(uid);
            List<User> userList = pushMapper.getUserPushList(query);
            try {
                for(int i=0; i < userList.size();i++){
                    query = userList.get(i);
                    GcmObject gcmObject = new GcmObject(query.getFcmToken(), message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }else if(pushType.equals(Push.SEED_MISSION_REG)){
            List<User> userList = pushMapper.getAllUser();
            try {
                for(int i=0; i < userList.size();i++){
                    query = userList.get(i);
                    GcmObject gcmObject = new GcmObject(query.getFcmToken(), message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }else if(pushType.equals(Push.PUSHTYPE_LESSON)){
            //List<User> userList = pushMapper.getAllUser();
            try {

                //for(int i=0; i < userList.size();i++){
                    //query = userList.get(i);

                    logger.info("Test :" + message.toString());

                    GcmObject gcmObject = new GcmObject(fcmString, message);
                    HttpEntity request = new HttpEntity(gcmObject, headers);
                    result = restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, request, HashMap.class);

                    if (result.getStatusCode() != HttpStatus.OK)
                        logger.debug("전송 오류 : " + result.getStatusCode().toString()
                        );
                //}
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }


    public void pushHeaderSet(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "key=AIzaSyAxrziw6jJwqVcR3oGtqzmKipC8sSLdZLo");
    }


}
