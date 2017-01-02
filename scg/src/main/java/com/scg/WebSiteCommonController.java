package com.scg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sungbo on 2016-12-13.
 */

@Controller
@RequestMapping("/common/")
public class WebSiteCommonController {

    private static final Logger logger = LoggerFactory.getLogger(WebSiteCommonController.class);

    @RequestMapping("agreement")
    public String agreement(){
        return "/common/agreement";
    }

}
