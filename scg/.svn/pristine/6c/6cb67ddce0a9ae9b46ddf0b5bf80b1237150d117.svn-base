package com.scg.api.mission;

import com.scg.model.Mission;
import com.scg.model.MissionEval;
import com.scg.model.QueryMission;
import com.scg.persistence.MissionMapper;
import com.scg.wep.vo.MissionRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {

	@Autowired
	private MissionMapper missionMapper;

	public void saveMission(MissionRegisterVo mission){
		missionMapper.saveMission(mission);
	}

	public Mission getMission(Mission mission){
		return missionMapper.getMission(mission);
	};

	public List<Mission> getMissionList(QueryMission queryMission){
		return missionMapper.MissionList(queryMission);
	}

	public List<Mission> getWebMissionList(QueryMission queryMission){
		return missionMapper.getWebMissionList(queryMission);
	}

	public int saveMissionEval(MissionEval missionEval){
		return missionMapper.saveMissionEval(missionEval);
	};

	public MissionEval getMissionEval(MissionEval missionEval){
		return missionMapper.getMissionEval(missionEval);
	};

	public List<MissionEval> getMissionEvalList(MissionEval missionEval){
		return missionMapper.getMissionEvalList(missionEval);
	};


}