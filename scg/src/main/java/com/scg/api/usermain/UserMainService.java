package com.scg.api.usermain;

import com.scg.datadto.UserMainVo;
import com.scg.persistence.UserMainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-09-06.
 */
@Service
public class UserMainService {

    @Autowired
    private UserMainMapper userMainMapper;


    public List<UserMainVo> getUserMainList(UserMainVo userMainVo){
        return userMainMapper.getUserMainList(userMainVo);
    };
}
