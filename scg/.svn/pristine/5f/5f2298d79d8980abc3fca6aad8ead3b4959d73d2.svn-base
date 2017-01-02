package com.scg.api.momcommon;

import com.scg.model.Common.ServerResult;
import com.scg.persistence.MomProcedureMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sungbo on 2016-09-19.
 */

@RestController
@RequestMapping("/common/set/")
public class CommonController {

    @Autowired
    private MomProcedureMapper momProcedureMapper;

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);


    //회원탈퇴시 유저의 정보 모두 삭제
    @RequestMapping("deleteUser")
    public ServerResult deleteUser(
            @RequestParam("uid") int uid
    ){

        momProcedureMapper.deleteUser(uid);
        return new ServerResult(1,"S");
    }

}
