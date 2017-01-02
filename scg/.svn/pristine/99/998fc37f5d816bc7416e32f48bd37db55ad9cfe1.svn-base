package com.scg.api.usermain;

import com.scg.api.team.TeamService;
import com.scg.datadto.UserMainVo;
import com.scg.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sungbo on 2016-09-06.
 */
@RestController
@RequestMapping("/api/usermain/")
public class UserMainController {

    private static final Logger logger = LoggerFactory.getLogger(UserMainController.class);

    @Autowired
    private UserMainService userMainService;

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "getUserMainList", method = RequestMethod.POST)
    public List<UserMainVo> getUserMainList(@RequestBody UserMainVo vo){


        if(vo.getTeamname() != null){

            if(vo.getTeamname().equals("ALL")){

            }else{
                Team team = new Team();
                team.setName(vo.getTeamname());
                team = teamService.getTeam(team);
                vo.setTeamid(team.getTeamid());
            }


        }

        return userMainService.getUserMainList(vo);
    }

}
