package com.scg.persistence;

import com.scg.model.Lookup;
import com.scg.model.MissionCategory;
import com.scg.model.MissionType;

import java.util.List;

/**
 * Created by sungbo on 2016-06-02.
 */
public interface CommonLookupMapper {

    public void createMissionCategory(MissionCategory category);
    public void updateMissionUpdate(MissionCategory category);
    public void deleteMissionCategory(int categoryid);
    public List<MissionCategory> getMissionCategoryList(MissionCategory missionCategory);

    public void createMissionType(MissionType type);
    public void deleteMissionType(int typeid);
    public List<MissionType> getMissionType(MissionType type);

    //룩업코드로 기준정보 빼오기
    public List<Lookup> getCategoryCode();

    //룩업코드로 기준정보 빼오기
    public List<Lookup> getTypeCode();



}
