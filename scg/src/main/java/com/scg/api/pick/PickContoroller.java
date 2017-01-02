package com.scg.api.pick;

import com.scg.model.Common.ServerResult;
import com.scg.model.MyBookMark;
import com.scg.model.UserMission;
import com.scg.persistence.MyBookMarkMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sungbo on 2016-07-30.
 */

@RestController
public class PickContoroller {

    private static final Logger logger = LoggerFactory.getLogger(PickContoroller.class);

    @Autowired
    MyBookMarkMapper myBookMarkMapper;

    @RequestMapping(value = "/api/mission/pickvideo",method = RequestMethod.POST)
    public ServerResult pickVideo(@RequestBody MyBookMark myBookMark){
        logger.info("즐겨 찾기 실행");
        myBookMarkMapper.createMarck(myBookMark);
        return new ServerResult(1,"S");
    }


    @RequestMapping(value = "/api/mission/pickcancel",method = RequestMethod.POST)
    public ServerResult pickCancel(@RequestBody MyBookMark myBookMark){
        myBookMarkMapper.deleteMarck(myBookMark);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "/api/mission/getPickCount")
    public ServerResult getPickCount(
            @RequestParam(required = false) int uid,
            @RequestParam(required = false) int usermissionid
    ){
        MyBookMark myBookMark = new MyBookMark(0,uid,usermissionid);
        ServerResult serverResult = new ServerResult();
        int count = myBookMarkMapper.getPickCount(myBookMark);

        serverResult.setCount(count);
        serverResult.setResult("S");
        return  serverResult;
    }

    @RequestMapping("/api/mission/getMyBookMark")
    public List<UserMission> getMyBookMark(@RequestBody MyBookMark myBookMark){
        return myBookMarkMapper.getMyBookMark(myBookMark);
    }


    @RequestMapping(value = "/api/mission/getMyBookMarkList",method = RequestMethod.POST)
    public List<MyBookMark> getMyBookMarkList(@RequestBody MyBookMark myBookMark){
        return myBookMarkMapper.getMyBookMarkList(myBookMark);
    }

}
