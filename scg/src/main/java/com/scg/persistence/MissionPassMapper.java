package com.scg.persistence;

import com.scg.model.MissionPass;

import java.util.List;

/**
 * Created by sungbo on 2016-08-29.
 */
public interface MissionPassMapper {

    public List<MissionPass> getPassList(MissionPass p);
    public void savePass(MissionPass p);
    public void updatePass(MissionPass p);
    public void deletePass(MissionPass missionPass);

    public MissionPass getMissionPass(MissionPass p);
    public int getMaxSeq(MissionPass p);

    public List<MissionPass> getMissionPassList(MissionPass m);
    //getMissionPassResultList

    public List<MissionPass> getMissionPassResultList(MissionPass m);
}
