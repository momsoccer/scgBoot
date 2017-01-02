package com.scg.webpage;

import com.scg.api.mission.MissionService;
import com.scg.api.usermain.UserMainService;
import com.scg.datadto.UserMainVo;
import com.scg.model.QueryMission;
import com.scg.model.web.MissionTypeVo;
import com.scg.persistence.MissionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by sungbo on 2016-12-06.
 */

@Controller
@RequestMapping("/mission/")
public class WmissionController {

    private static final Logger logger = LoggerFactory.getLogger(WmissionController.class);

    @Autowired
    private MissionMapper missionMapper;

    @Autowired
    private MissionService missionService;

    @Autowired
    private UserMainService userMainService;

    @RequestMapping("main")
    public String missionMain(Model model){

        List<MissionTypeVo> missionType = missionMapper.getMissionType();
        model.addAttribute("list",missionType);

        return "/mission/main";
    }

    @RequestMapping("webmissionlist")
    public String webmissionlist(
            Model model,
            @RequestParam("typeid") int typeid){

        QueryMission queryMission = new QueryMission();

        queryMission.setTypeid(typeid);

        model.addAttribute("list", missionService.getWebMissionList(queryMission));
        return "/mission/webmissionlist";
    }

    @RequestMapping("webusermissionlist")
    public String webusermissionlist(
            Model model,
            @RequestParam("typename") String typename){

        UserMainVo vo = new UserMainVo();
        vo.setMissiontype(typename);
        vo.setOffset(0);
        vo.setLimit(1000);

        model.addAttribute("list",userMainService.getUserMainList(vo));

        return "/mission/webusermissionlist";
    }


}
