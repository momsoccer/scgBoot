package com.scg.persistence;

import com.scg.model.PointManagement;
import com.scg.model.UserDailyHistory;

import java.util.List;

/**
 * Created by sungbo on 2016-06-16.
 */
public interface IndicatorServiceMapper {

    public int savedailyUser(UserDailyHistory history);

    public int getdailycheck(String Uid,
                             String yyyymmdd
                             );

    public List<PointManagement> getPointList();

}
