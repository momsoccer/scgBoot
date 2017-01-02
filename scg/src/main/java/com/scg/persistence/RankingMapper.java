package com.scg.persistence;

import com.scg.datadto.UserRangkinVo;

import java.util.List;

/**
 * Created by sungbo on 2016-08-01.
 */
public interface RankingMapper {

    public List<UserRangkinVo> getUserRankingAll(UserRangkinVo userRangkinVo);
    public List<UserRangkinVo> getTeamRanking(UserRangkinVo userRangkinVo);
    public List<UserRangkinVo> getFriendRanking(UserRangkinVo userRangkinVo);
}
