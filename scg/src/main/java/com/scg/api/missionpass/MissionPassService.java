package com.scg.api.missionpass;

import com.scg.model.MissionPass;
import com.scg.persistence.MissionPassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-08-29.
 */

@Service
public class MissionPassService {

    @Autowired
    MissionPassMapper missionPassMapper;

    public List<MissionPass> getPassList(MissionPass p){
        return missionPassMapper.getPassList(p);
    };
    public void savePass(MissionPass p){
        missionPassMapper.savePass(p);
    };
    public void updatePass(MissionPass p){
        missionPassMapper.updatePass(p);
    };

    public void deletePass(MissionPass missionPass){
        missionPassMapper.deletePass(missionPass);
    };

    public MissionPass getMissionPass(MissionPass p){

        MissionPass pass = null;
        try{
            pass = missionPassMapper.getMissionPass(p);
        }catch (Exception e){

        }

        if(pass==null){
            pass = new MissionPass();
        }

        return missionPassMapper.getMissionPass(p);
    };

    public int getMaxSeq(MissionPass p){
        int i = 0;

        try{
           i = missionPassMapper.getMaxSeq(p);
        }catch (Exception e){
            i = 0;
        }


        return i;
    };


    public List<MissionPass> getMissionPassList(MissionPass m){
        return missionPassMapper.getMissionPassList(m);
    }
    public List<MissionPass> getMissionPassResultList(MissionPass m){
        return missionPassMapper.getMissionPassResultList(m);
    };
}
