package com.scg.api.friend;

import com.scg.datadto.FeedDataVo;
import com.scg.model.userfriend.FriendApply;
import com.scg.model.userfriend.FriendReqVo;
import com.scg.persistence.FriendApplyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-07-12.
 */
@Service
public class FriendService {

    private static final Logger logger = LoggerFactory.getLogger(FriendService.class);

    @Autowired
    private FriendApplyMapper mapper;

    public void reqFriendApply(FriendApply friendApply){
        logger.info("클라이언트에게 받은 값 : "+friendApply.toString());
        mapper.reqFriendApply(friendApply);
    };

    public List<FriendReqVo> getFriendReqList(int responseUid,String flag){
        return mapper.getFriendReqList(responseUid,flag);
    };

    public void updateFriendFlag(FriendApply v){
        mapper.updateFriendFlag(v);
    };


    public FriendApply getFriendApply(FriendApply friendApply){

        FriendApply apply = null;
        try{
            apply = mapper.getFriendApply(friendApply);
        }catch (Exception e){}

        if(apply == null){
            apply = new FriendApply();
        }

        return apply;
    };

    public void deleteFriend(FriendApply friendApply){
        mapper.deleteFriend(friendApply);
    };

    public void friendupdate(FriendApply friendApply){
        mapper.friendupdate(friendApply);
    };


    public FeedDataVo getAllfriend(FeedDataVo feedDataVo){
        return  mapper.getAllfriend(feedDataVo);
    };

}
