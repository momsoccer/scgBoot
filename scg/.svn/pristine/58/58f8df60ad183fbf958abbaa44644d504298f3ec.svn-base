package com.scg.persistence;

import com.scg.model.Common.PointTrVo;
import com.scg.model.PointManagement;
import com.scg.model.SpBalanceHeader;
import com.scg.model.SpBalanceLine;

import java.util.List;

/**
 * Created by sungbo on 2016-06-11.
 */
public interface SelfPointMapper {

    public void saveHeaderPoint(SpBalanceHeader header);

    public void saveLinePoint(SpBalanceLine line);
    public SpBalanceLine getLinePoint(int headerid);


    public void updateHeaderPoint(int headerid, int uid, int amount);

    public SpBalanceHeader getSelfPointAmount(SpBalanceHeader header);

    //get point info
    public PointManagement getPointInfo(PointManagement pointType);

    public PointTrVo getPointTr(PointTrVo pointTrVo);

    //GET POINT HISTORY
    public List<SpBalanceLine> getCashLineList(SpBalanceLine spBalanceLine);


}
