package com.scg.api.missionopenhistory;

import com.scg.api.mission.MissionController;
import com.scg.model.Common.MissionHistory;
import com.scg.model.Common.ServerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sungbo on 2016-08-08.
 */

@RestController
@RequestMapping("/api/mission/")
public class MissionHistoryController {

    private static final Logger logger = LoggerFactory.getLogger(MissionController.class);

    @Autowired
    private MissionHistoryService missionHistoryService;

    @RequestMapping(value = "saveMissionHistory", method = RequestMethod.POST)
    public ServerResult saveMissionHistory(@RequestBody MissionHistory history){
        missionHistoryService.saveHistory(history);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "getMissionHistoryCount", method = RequestMethod.POST)
    public ServerResult getMissionHistoryCount(@RequestBody MissionHistory history){
        return new ServerResult(missionHistoryService.getMissionHistoryCount(history),"S");
    }

    //유저가 미션을 오픈 하기 직전 이미 지불했는지 다시한번 검증하는 목적으로 만듬
    @RequestMapping(value = "getMissionHistory", method = RequestMethod.POST)
    public MissionHistory getMissionHistory(@RequestBody MissionHistory history){
        logger.info("호출합니다");
        return missionHistoryService.getMissionHistory(history);
    }

}
