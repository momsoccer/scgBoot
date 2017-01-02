package com.scg.persistence;

import com.scg.model.Common.MissionHistory;

/**
 * Created by sungbo on 2016-08-08.
 */
public interface MissionHistoryMapper {
    public void saveHistory(MissionHistory history);
    public int getMissionHistoryCount(MissionHistory history);
    public MissionHistory getMissionHistory(MissionHistory history);
}
