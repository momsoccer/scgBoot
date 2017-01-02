package com.scg.api.commonlookup;

import com.scg.model.Lookup;
import com.scg.model.MissionCategory;
import com.scg.model.MissionType;
import com.scg.persistence.CommonLookupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-06-02.
 */
@Service
public class LookupService {

    @Autowired
    CommonLookupMapper mapper;

    //카테고리관련
    public void createMissionCategory(MissionCategory missionCategory){
        mapper.createMissionCategory(missionCategory);
    }
    public void updateMissionUpdate(MissionCategory missionCategory){
        mapper.updateMissionUpdate(missionCategory);
    }

    public void deleteMissionCategory(int categoryid){
        mapper.deleteMissionCategory(categoryid);
    }
    public List<MissionCategory>getMissionCategoryList(MissionCategory missionCategory){
        return mapper.getMissionCategoryList(missionCategory);
    }

    //타입 관련
    public void createMissionType(MissionType type){
        mapper.createMissionType(type);
    }

    public void deleteMissionType(int typeid){
        mapper.deleteMissionType(typeid);
    }

    public List<MissionType> getMissionType(MissionType type){
      return   mapper.getMissionType(type);
    }

    public List<Lookup> getCategoryCode(){
        return mapper.getCategoryCode();
    }

    public List<Lookup> getTypeCode(){
        return mapper.getTypeCode();
    }



}
