package com.scg.persistence;

import com.scg.insvideoboard.InsVideoLikeVo;
import com.scg.insvideoboard.InsVideoVo;
import com.scg.insvideoboard.InsVideoVoLine;

import java.util.List;

/**
 * Created by sungbo on 2016-09-21.
 */
public interface InsVideoMapper {

    public void saveVideo(InsVideoVo insVideoVo);
    public List<InsVideoVo> getVideoList(InsVideoVo insVideoVo);
    public InsVideoVo getVideo(InsVideoVo insVideoVo);

    public void deleteVideo(InsVideoVo insVideoVo);
    public void updateVideo(InsVideoVo insVideoVo);

    public void saveVideoLike(InsVideoLikeVo vo);

    public void deleteVideoLike(InsVideoLikeVo vo);

    public List<InsVideoLikeVo> getVideoLikeList(int videoid);

    public int getLikeVideoCount(int uid,int videoid);

    public void saveLine(InsVideoVoLine line);
    public List<InsVideoVoLine> getLineList(int videoid);
    public void deleteLine(InsVideoVoLine videoid);


}
