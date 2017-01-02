package com.scg.api.usermission;

import com.scg.datadto.EvalVo;
import com.scg.model.UserMission;
import com.scg.model.UserMissionEval;
import com.scg.persistence.UserMissionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-05-31.
 */
@Service
public class UserMissionService {
    private static final Logger logger = LoggerFactory.getLogger(UserMissionService.class);
    @Autowired
    private UserMissionMapper userMissionMapper;

    /**************************************************
     * UserMission
     **************************************************/

    public List<UserMission> getUserMissionList(UserMission userMission){
        return userMissionMapper.getUserMissionList(userMission);
    }

    public int saveUserMission(UserMission userMission){

        return userMissionMapper.saveUserMission(userMission);
    }

    public void updateUserMission(UserMission mission){
        userMissionMapper.updateUserMission(mission);
    }

    public int getUserMissionCount(UserMission userMission){
        return userMissionMapper.getUserMissionCount(userMission);
    };


    public UserMission getUserMission(UserMission userMission){

        UserMission uMission = null;
        try{
            uMission = userMissionMapper.getUserMission(userMission);
        }catch (Exception e){
            logger.info(" 조회 된 값이 없습니다");
        }

        if(uMission == null){
            uMission = new UserMission();
            logger.info(" 조회 된 값이 없습니다 강제로 값을 리턴합니다");
        }

        return uMission;
    };


    //다른사람영상 같은 미션의...
    public List<UserMission> getUmissionList(UserMission mission){
        return userMissionMapper.getUmissionList(mission);
    };

    /**************************************************
     * UserMission Evaluation
     **************************************************/

    public int saveUserMissionEval(UserMissionEval eval){

       return userMissionMapper.saveUserMissionEval(eval);
    };

    public List<UserMissionEval> getUserMissionEvalList(UserMissionEval userMissionEval){
        return userMissionMapper.getUserMissionEvalList(userMissionEval);
    };

    public int getUserMissionEvalCount(UserMissionEval userMissionEval){
        return userMissionMapper.getUserMissionEvalCount(userMissionEval);
    };

    public EvalVo getUserMissionAvg(UserMissionEval e){

        EvalVo evalVo = null;
        try{
            evalVo = userMissionMapper.getUserMissionAvg(e);
        }catch (Exception e1){

        }

        if(evalVo==null){
            evalVo = new EvalVo();
        }

        return evalVo;
    };

}
