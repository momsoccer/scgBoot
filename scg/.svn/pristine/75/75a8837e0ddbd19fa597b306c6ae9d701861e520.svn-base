package com.scg.insvideoboard;

import com.scg.model.Common.ServerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sungbo on 2016-09-21.
 */
@RestController
@RequestMapping("/insvideo/")
public class InsVideoBoardController {

    private static final Logger logger = LoggerFactory.getLogger(InsVideoBoardController.class);

    @Autowired
    private InsVideoService insVideoService;

    @RequestMapping(value = "saveVideo" , method = RequestMethod.POST)
    public ServerResult saveVideo(@RequestBody InsVideoVo insVideoVo){
        insVideoService.saveVideo(insVideoVo);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "deleteVideo", method = RequestMethod.POST)
    public ServerResult deleteVideo(@RequestBody InsVideoVo insVideoVo){
        insVideoService.deleteVideo(insVideoVo);

        InsVideoVoLine insVideoVoLine = new InsVideoVoLine();
        insVideoVoLine.setVideoid(insVideoVo.getVideoid());
        insVideoService.deleteLine(insVideoVoLine);

        InsVideoLikeVo vo = new InsVideoLikeVo();
        vo.setVideoid(insVideoVo.getVideoid());
        insVideoService.deleteVideoLike(vo);

        InsVideoLikeVo likeVo = new InsVideoLikeVo();
        likeVo.setVideoid(insVideoVo.getVideoid());
        insVideoService.deleteVideoLike(likeVo);

        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "getVideoList" , method = RequestMethod.POST)
    public List<InsVideoVo> getVideoList(@RequestBody InsVideoVo insVideoVo){
        return insVideoService.getVideoList(insVideoVo);
    }

    @RequestMapping(value = "getVideo" , method = RequestMethod.POST)
    public InsVideoVo getVideo(@RequestBody InsVideoVo insVideoVo){
        return insVideoService.getVideo(insVideoVo);
    }

    @RequestMapping(value = "updateVideo" ,method = RequestMethod.POST)
    public ServerResult updateVideo(@RequestBody InsVideoVo insVideoVo){
        insVideoService.updateVideo(insVideoVo);
        return new ServerResult(1,"S");
    }

    //like
    @RequestMapping(value = "saveVideoLike",method = RequestMethod.POST)
    public ServerResult saveVideoLike(@RequestBody InsVideoLikeVo insVideoVo){
        insVideoService.saveVideoLike(insVideoVo);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "deleteVideoLike",method = RequestMethod.POST)
    public ServerResult deleteVideoLike(@RequestBody InsVideoLikeVo insVideoLikeVo){
        insVideoService.deleteVideoLike(insVideoLikeVo);
        return new ServerResult(1,"S");
    }

    @RequestMapping("getVideoLikeList")
    public List<InsVideoLikeVo> getVideoLikeList(@RequestParam("videoid") int videoid){
        return insVideoService.getVideoLikeList(videoid);
    }

    @RequestMapping("getLikeVideoCount")
    public int getLikeVideoCount(@RequestParam("uid") int uid,
                                 @RequestParam("videoid") int videoid
                                 ){
        return insVideoService.getLikeVideoCount(uid,videoid);
    }

    @RequestMapping(value = "saveLine",method = RequestMethod.POST)
    public ServerResult saveLine(@RequestBody InsVideoVoLine line){
        insVideoService.saveLine(line);
        return new ServerResult(1,"S");
    }


    @RequestMapping(value = "deleteLine",method = RequestMethod.POST)
    public ServerResult deleteLine(@RequestBody InsVideoVoLine line){
        insVideoService.deleteLine(line);
        return new ServerResult(1,"S");
    }

    @RequestMapping(value = "getLineList")
    public List<InsVideoVoLine> getLineList(@RequestParam("videoid") int videoid){
        return insVideoService.getLineList(videoid);
    }
}
