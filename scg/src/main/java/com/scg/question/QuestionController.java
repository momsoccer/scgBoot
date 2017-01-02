package com.scg.question;

import com.scg.model.Common.ServerResult;
import com.scg.persistence.QuestionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sungbo on 2016-09-23.
 */

@RestController
public class QuestionController {

    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    QuestionMapper questionMapper;

    @RequestMapping(value = "/api/question/saveQuestion",method = RequestMethod.POST)
    public ServerResult saveQuestion(@RequestBody QuestionVo questionVo){
        questionMapper.saveQuetion(questionVo);
        return new ServerResult(1,"S");
    }

}
