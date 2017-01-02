package com.scg.api.missionopenhistory;

import com.scg.model.Common.MissionHistory;
import com.scg.persistence.MissionHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungbo on 2016-08-08.
 */

@Service
public class MissionHistoryService {
    @Autowired
    MissionHistoryMapper historyMapper;

    public void saveHistory(MissionHistory history){
        historyMapper.saveHistory(history);
    };

    public int getMissionHistoryCount(MissionHistory history){
       return historyMapper.getMissionHistoryCount(history);
    };

    public MissionHistory getMissionHistory(MissionHistory history){

        MissionHistory missionHistory = null;

        try{
            missionHistory = historyMapper.getMissionHistory(history);
        }catch (Exception e){

        }

        if(missionHistory == null){
            missionHistory = new MissionHistory();
        }

        return missionHistory;
    };
}
