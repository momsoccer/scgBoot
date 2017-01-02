package com.scg.persistence;

import com.scg.datadto.EvalVo;
import com.scg.model.UserMission;
import com.scg.model.UserMissionEval;

import java.util.List;

/**
 * Created by sungbo on 2016-05-31.
 */

public interface UserMissionMapper {

    /**************************************************
     * UserMission
     **************************************************/

    public List<UserMission> getUserMissionList(UserMission userMission);

    public int saveUserMission(UserMission userMission);

    public void updateUserMission(UserMission userMission);

    public int getUserMissionCount(UserMission userMission);

    public UserMission getUserMission(UserMission userMission);

    //다른사람영상 리스트 조회용
    public List<UserMission> getUmissionList(UserMission mission);


    /**************************************************
     * UserMission Evaluation
     **************************************************/

    public int saveUserMissionEval(UserMissionEval eval);

    public List<UserMissionEval> getUserMissionEvalList(UserMissionEval userMissionEval);

    public int getUserMissionEvalCount(UserMissionEval userMissionEval);

    public EvalVo getUserMissionAvg(UserMissionEval e);

}
