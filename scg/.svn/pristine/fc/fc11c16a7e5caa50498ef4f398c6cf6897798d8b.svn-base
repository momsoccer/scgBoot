package com.scg.api.mominfo;

import com.scg.model.Common.Mominfo;
import com.scg.model.Common.ServerResult;
import com.scg.model.Report;
import com.scg.persistence.MominfoMapper;
import com.scg.persistence.ReportMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sungbo on 2016-08-14.
 */
@RestController
public class MomInfoController {

    private static final Logger logger = LoggerFactory.getLogger(MomInfoController.class);

    @Autowired
    MominfoMapper mominfoMapper;

    @Autowired
    ReportMapper reportMapper;

    @RequestMapping("/all/mominfo")
    public List<Mominfo> getMomInfo(){
        return mominfoMapper.getMomInfo("Y");
    }

    @RequestMapping(value = "/all/saveReport",method = RequestMethod.POST)
    public ServerResult saveReport(@RequestBody Report report){
        reportMapper.saveReport(report);
        return new ServerResult(1,"S");
    }


}
