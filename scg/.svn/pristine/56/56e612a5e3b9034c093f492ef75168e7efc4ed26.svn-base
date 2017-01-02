package com.scg.wep.service;

import com.scg.persistence.WebMissionPassMapper;
import com.scg.wep.vo.MissionPassVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-11-21.
 */

@Service
public class WebMissionPassService {

    @Autowired
    WebMissionPassMapper webMissionPassMapper;

    public List<MissionPassVo> getMissionPassList(MissionPassVo missionPassVo){
        return webMissionPassMapper.getMissionPassList(missionPassVo);
    };

    public MissionPassVo getMissionPass(int passId){
        return webMissionPassMapper.getMissionPass(passId);
    };

    public List<MissionPassVo> getUserMissionList(){
        return webMissionPassMapper.getUserMissionList();
    }

    public MissionPassVo getData(int usermissionid){
        return webMissionPassMapper.getData(usermissionid);
    };
}
