package com.scg.adboard;

import com.scg.persistence.AdBoardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sungbo on 2016-09-19.
 */
@RestController
@RequestMapping("/adboard/")
public class AdBoardController {

    private static final Logger logger = LoggerFactory.getLogger(AdBoardController.class);

    @Autowired
    private AdBoardMapper adBoardMapper;

    @RequestMapping(value = "getlist",method = RequestMethod.POST)
    public List<AdBoardVo> getlist(@RequestBody AdBoardVo adBoardVo){

        List<AdBoardVo> adBoardVos = adBoardMapper.getList(adBoardVo);

        for(int i=0 ; i < adBoardVos.size() ; i++){
            AdBoardVo vo = adBoardVos.get(i);
            if(vo.getFilecount() > 0){
                List<AdBoardFile> adBoardFiles = adBoardMapper.getFileList(vo.getAdvid());
                vo.setAdBoardFiles(adBoardFiles);
            }
        }

        return adBoardVos;
    }

    @RequestMapping(value = "getHeader")
    public AdBoardVo getHeader(@RequestParam("advid") int advid){


        AdBoardVo vo = adBoardMapper.getHeader(advid);

        List<AdBoardFile> adBoardFiles = adBoardMapper.getFileList(vo.getAdvid());
        vo.setAdBoardFiles(adBoardFiles);


        return  vo;
    }

}
