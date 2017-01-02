package com.scg.insvideoboard;

import com.scg.persistence.InsVideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-09-21.
 */
@Service
public class InsVideoService {

    @Autowired
    InsVideoMapper insVideoMapper;

    public void saveVideo(InsVideoVo insVideoVo){
        insVideoMapper.saveVideo(insVideoVo);
    };
    public List<InsVideoVo> getVideoList(InsVideoVo insVideoVo){
        return insVideoMapper.getVideoList(insVideoVo);
    };

    public InsVideoVo getVideo(InsVideoVo insVideoVo){

        InsVideoVo vo = null;

        try{
            vo = insVideoMapper.getVideo(insVideoVo);
        }catch (Exception e){

        }

        if(vo == null){
            vo = new InsVideoVo();
        }

        return vo;

    };

    public void deleteVideo(InsVideoVo insVideoVo){
        insVideoMapper.deleteVideo(insVideoVo);
    };

    public void updateVideo(InsVideoVo insVideoVo){
        insVideoMapper.updateVideo(insVideoVo);
    };


    //like click info
    public void saveVideoLike(InsVideoLikeVo vo){
        insVideoMapper.saveVideoLike(vo);
    };

    public void deleteVideoLike(InsVideoLikeVo insVideoLikeVo){
        insVideoMapper.deleteVideoLike(insVideoLikeVo);
    };

    public List<InsVideoLikeVo> getVideoLikeList(int videoid){
        return insVideoMapper.getVideoLikeList(videoid);
    };

    public void saveLine(InsVideoVoLine line){
        insVideoMapper.saveLine(line);
    };

    public void deleteLine(InsVideoVoLine videoid){
        insVideoMapper.deleteLine(videoid);
    };

    public List<InsVideoVoLine> getLineList(int videoid){
        return insVideoMapper.getLineList(videoid);
    };

    public int getLikeVideoCount(int uid,int videoid){

        int count = 0;
        try{
            count = insVideoMapper.getLikeVideoCount(uid,videoid);
        }catch (Exception e){
            return count;
        }

        return insVideoMapper.getLikeVideoCount(uid,videoid);
    };

}
