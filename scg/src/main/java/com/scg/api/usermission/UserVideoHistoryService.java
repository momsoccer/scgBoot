package com.scg.api.usermission;

import com.scg.datadto.UserVideoHistoryVo;
import com.scg.persistence.UserVideoHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungbo on 2016-08-10.
 */
@Service
public class UserVideoHistoryService {

    @Autowired
    UserVideoHistoryMapper userVideoHistoryMapper;

    public void saveVideoHistory(UserVideoHistoryVo vo){
        userVideoHistoryMapper.saveVideoHistory(vo);
    };

    public UserVideoHistoryVo getVideoHistory(UserVideoHistoryVo vo){

        UserVideoHistoryVo historyVo = null;

        try{
            historyVo = userVideoHistoryMapper.getVideoHistory(vo);
        }catch (Exception e){

        }

        if(historyVo == null){
            historyVo = new UserVideoHistoryVo();
        }

        return historyVo;
    };


}
