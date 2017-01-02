package com.scg.api.feedback;

import com.scg.datadto.FeedBackDataVo;
import com.scg.model.FeedbackHeader;
import com.scg.model.FeedbackLine;
import com.scg.persistence.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungbo on 2016-06-20.
 */
@Service
public class FeedBackService {

    @Autowired
    FeedbackMapper feedbackMapper;

    public List<FeedbackHeader> getFeedAllList(FeedbackHeader feedbackHeader){
        return feedbackMapper.getFeedAllList(feedbackHeader);
    };

    public List<FeedbackHeader> requestFeed(FeedbackHeader feedbackHeader){
        return feedbackMapper.requestFeed(feedbackHeader);
    };

    public List<FeedbackHeader> getFeedBackList(FeedbackHeader feedbackHeader){

        List<FeedbackHeader> headers;

        try{
           headers = feedbackMapper.getFeedBackList(feedbackHeader);
        }catch (Exception e){
            headers = new ArrayList<FeedbackHeader>();
            return headers;
        }

        return headers;
    };

    /*********************************************************
     *  feedback_header
     *********************************************************/

    public void saveFeedHeader(FeedbackHeader header){

        feedbackMapper.saveFeedHeader(header);
    };

    public List<FeedbackHeader> getFeedHeaderList(FeedbackHeader feedbackHeader){
        return feedbackMapper.getFeedHeaderList(feedbackHeader);
    };

    public FeedbackHeader getFeedHeader(FeedbackHeader feedbackHeader){
        return feedbackMapper.getFeedHeader(feedbackHeader);
    };

    public int getFeedHeaderCount(FeedbackHeader feedbackHeader){
        return feedbackMapper.getFeedHeaderCount(feedbackHeader);
    };
    /*********************************************************
     *  feedback_line
     *********************************************************/

    public void saveFeedLine(FeedbackLine line){

        feedbackMapper.saveFeedLine(line);
    };

    public List<FeedbackLine> getFeedLineList(FeedbackLine feedbackLine){
        return feedbackMapper.getFeedLineList(feedbackLine);
    };

    public FeedbackLine getFeedLine(FeedbackLine feedbackLine){
        return feedbackMapper.getFeedLine(feedbackLine);
    };

    public int getFeedLineCount(FeedbackLine feedbackLine){
        return feedbackMapper.getFeedLineCount(feedbackLine);
    };

    public void updateLine(FeedbackLine line){
        feedbackMapper.updateLine(line);
    };

    public void deleteLine(FeedbackLine line){
        feedbackMapper.deleteLine(line);
    };

    public List<FeedBackDataVo> getFeedBackTotalList(FeedBackDataVo feedBackDataVo){
        return feedbackMapper.getFeedBackTotalList(feedBackDataVo);
    };

}
