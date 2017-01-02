package com.scg.api.friend;

import com.scg.api.googlefcm.Push;
import com.scg.api.googlefcm.PushService;
import com.scg.datadto.FeedDataVo;
import com.scg.model.Common.ServerResult;
import com.scg.model.Message;
import com.scg.model.userfriend.FriendApply;
import com.scg.model.userfriend.FriendReqVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sungbo on 2016-07-12.
 * 친구 요청, 수락/거절 , 친구삭제 관련
 */

@RestController
@RequestMapping("/api/common/")
public class FriendController {

    private static final Logger logger = LoggerFactory.getLogger(FriendController.class);

    @Autowired
    private FriendService friendService;

    @Autowired
    private PushService pushService;

    @RequestMapping(value = "getAllfriend",method = RequestMethod.POST)
    public FeedDataVo getAllfriend(@RequestBody FeedDataVo feedDataVo){
        return friendService.getAllfriend(feedDataVo);
    }

    @RequestMapping(value = "deleteFriend")
    public ServerResult deleteFriend(@RequestBody FriendApply friendApply){

        friendService.deleteFriend(friendApply);

        FriendApply apply = new FriendApply();
        apply.setRequid(friendApply.getResuid());
        apply.setResuid(friendApply.getRequid());

        friendService.deleteFriend(apply);

        return new ServerResult(1,"S");
    }


    //친구리스트 검색
    @RequestMapping(value = "updateFriendFlag")
    public ServerResult updateFriendFlag(@RequestBody FriendApply friendApply){

        friendService.updateFriendFlag(friendApply);

        FriendApply apply = new FriendApply();

        apply.setRequid(friendApply.getResuid());
        apply.setResuid(friendApply.getRequid());

        friendService.updateFriendFlag(friendApply);
        return new ServerResult(1,"S");
    }

    //친구리스트 검색
    @RequestMapping(value = "FriendReqList")
    public List<FriendReqVo> FriendReqList(@RequestParam("uid") int uid,@RequestParam("flag") String flag){

        logger.info("요청 친구 목록" + uid);
        logger.info("요청 친구 목록" + flag);

        return friendService.getFriendReqList(uid,flag);
    }

    //친구가 있는지 검색
    @RequestMapping(value = "getFriendStatus")
    public ServerResult getFriendApply(@RequestParam("uid") int uid, @RequestParam("friendUid") int friendUid){

        logger.info("친구 상태를 확인 합니다");

        ServerResult result = new ServerResult();
        /****************************
         * 친구 상태를 조회한다
         * 1.친구인지 아닌지         친구 Y , 아무것도 아닐때는 N
         * 2.친구요청을 한 상태인지  P
         */
        result.setResult("S");
        result.setCount(0);

        FriendApply query = new FriendApply();

        //검증1
        query.setRequid(uid); query.setResuid(friendUid);

        FriendApply resultOneVo = new FriendApply();

        query.setRequid(uid);
        query.setResuid(friendUid);

        resultOneVo = friendService.getFriendApply(query);

        if(resultOneVo.getApplyid()!=0) {
            if (resultOneVo.getFlag().equals("ACCEPT")) {
                result.setCount(1);
                result.setResult("Y");
                return result;
            } else if (resultOneVo.getFlag().equals("REQUEST")) {
                result.setCount(2);
                result.setResult("P");
                return result;
            }
        }

        //검증2 나에게 친구 신청를 했는지 검사한다
        query.setRequid(friendUid);
        query.setResuid(uid);
        resultOneVo = friendService.getFriendApply(query);

        if(resultOneVo.getApplyid()!=0){
            if (resultOneVo.getFlag().equals("ACCEPT")) {
                result.setCount(1);
                result.setResult("Y");
                return result;
            } else if (resultOneVo.getFlag().equals("REQUEST")) {
                result.setCount(2);
                result.setResult("ME");
                return result;
            }
        }

        return result;
    }

    //친구요청 메서드
    @RequestMapping(value = "reqFriend" , method = RequestMethod.POST)
    public ServerResult reqFriend(@RequestBody FriendApply friendApply){

        friendService.reqFriendApply(friendApply);



        Message message = new Message(Push.PUSH_TITLE_FRIEND_REQ,friendApply.getRequsername(),null);
        pushService.pushExecute(Push.PUSHTYPE_FRIEND_REQ, 0,friendApply.getResuid(), 0, message);

        return new ServerResult(1,"S");
    }



}
