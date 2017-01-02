package com.scg.api.Follow;

import com.scg.datadto.TeamMapVo;
import com.scg.model.Common.FollowManage;
import com.scg.model.Common.ServerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sungbo on 2016-08-08.
 */
@RestController
@RequestMapping("/api/common/")
public class FollowController {

    private static final Logger logger = LoggerFactory.getLogger(FollowController.class);

    @Autowired
    private FollowService followService;

    @RequestMapping(value = "saveFollow" , method = RequestMethod.POST)
    public ServerResult saveFollow(
            @RequestBody FollowManage followManage
    ){
        followService.saveFollow(followManage);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "deleteFollow" , method = RequestMethod.POST)
    public ServerResult deleteFollow(@RequestBody FollowManage followManage){
        followService.deleteFollow(followManage);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "getFollowUserCount" , method = RequestMethod.POST)
    public ServerResult getFollowUserCount(@RequestBody FollowManage followManage){
        logger.info("팔러우 검색" + followManage.toString());

        return new ServerResult(followService.getFollowUserCount(followManage),"S");
    }

    @RequestMapping(value = "getMeFollowList" , method = RequestMethod.POST)
    public List<FollowManage> getMeFollowList(@RequestBody FollowManage followManage){

        logger.info("parameter : " + followManage.toString());

        return followService.getMeFollowList(followManage);
    }

    @RequestMapping(value = "getFollowerCount")
    public List<TeamMapVo> getFollowerCount(@RequestParam("uid")int uid){
        return followService.getFollowerCount(uid);
    }

}
