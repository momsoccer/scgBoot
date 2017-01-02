package com.scg.persistence;

import com.scg.model.Mission;
import com.scg.model.MissionEval;
import com.scg.model.QueryMission;
import com.scg.model.web.MissionTypeVo;
import com.scg.wep.vo.MissionRegisterVo;

import java.util.List;

/**
 * Created by sungbo on 2016-05-30.
 */
public interface MissionMapper {
    public List<Mission> MissionList(QueryMission queryMission);
    public void saveMission(MissionRegisterVo mission);
    public Mission getMission(Mission mission);

    public int saveMissionEval(MissionEval missionEval);
    public MissionEval getMissionEval(MissionEval missionEval);
    public List<MissionEval> getMissionEvalList(MissionEval missionEval);

    public List<MissionTypeVo> getMissionType();

    public List<Mission> getWebMissionList(QueryMission queryMission);

}
