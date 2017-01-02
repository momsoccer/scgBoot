package com.scg.api.mission;

import com.scg.model.Common.MomMessage;
import com.scg.model.Mission;
import com.scg.model.MissionEval;
import com.scg.model.QueryMission;
import com.scg.persistence.MomMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mission/")
public class MissionController {

    private static final Logger logger = LoggerFactory.getLogger(MissionController.class);

    @Autowired
    private MissionService missionService;

    @Autowired
    private MomMapper momMapper;

    @RequestMapping(value = "getMission", method = RequestMethod.POST)
    public Mission getMission(
            @RequestBody Mission mission
            ){
        logger.info("요청 값은 아래와 같습니다");
        logger.info(mission.toString());

        return missionService.getMission(mission);
    }

    //미션 조회용 메소드
    @RequestMapping(value="getMissionList", method= RequestMethod.GET)
    public List<Mission> getMissionList(
            @RequestParam(required = false) String typename,
            @RequestParam(required = false) int uid
    ) {

        logger.info("getMissionList() 을 호출합니다");
        QueryMission queryMission = new QueryMission();

        queryMission.setTypename(typename);
        queryMission.setUid(uid);
        return missionService.getMissionList(queryMission);
    }


    @RequestMapping(value = "getMissionEvalList", method = RequestMethod.GET)
    public List<MissionEval> getMissionEvalList(){

        MissionEval eval = new MissionEval();
        eval.setMissionid(1);

        return missionService.getMissionEvalList(eval);
    }

    @RequestMapping(value = "getCommonInfo", method = RequestMethod.GET)
    public MomMessage getMissionEvalList(
            @RequestParam(required = false) String name
    ){
        return momMapper.getMomMessage(name);
    }

}