package com.scg.api.user;

import com.scg.model.PointManagement;
import com.scg.model.UserDailyHistory;
import com.scg.persistence.IndicatorServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-06-16.
 */
@Service
public class IndicatorService {

    @Autowired
    IndicatorServiceMapper mapper;

    public int savedailyUser(UserDailyHistory history){
        return mapper.savedailyUser(history);
    }

    public int getdailycheck(String uid,String yyyymmdd){
        return mapper.getdailycheck(uid,yyyymmdd);
    }

    public List<PointManagement> getPointList(){
        return mapper.getPointList();
    }
}
