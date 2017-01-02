package com.scg.persistence;

import com.scg.datadto.FeedBackDataVo;
import com.scg.model.FeedbackHeader;
import com.scg.model.FeedbackLine;

import java.util.List;

/**
 * Created by sungbo on 2016-06-20.
 */
public interface FeedbackMapper {

    public List<FeedbackHeader> getFeedAllList(FeedbackHeader feedbackHeader);

    public List<FeedbackHeader> requestFeed(FeedbackHeader feedbackHeader);

    public List<FeedbackHeader> getFeedBackList(FeedbackHeader feedbackHeader);

    /*********************************************************
     *  feedback_header
     *********************************************************/
    //feedback_header
    public void saveFeedHeader(FeedbackHeader feedbackHeader);

    public List<FeedbackHeader> getFeedHeaderList(FeedbackHeader feedbackHeader);

    public FeedbackHeader getFeedHeader(FeedbackHeader feedbackHeader);

    public int getFeedHeaderCount(FeedbackHeader feedbackHeader);
    /*********************************************************
     *  feedback_line
     *********************************************************/
    //feedback_line
    public int saveFeedLine(FeedbackLine feedbackLine);

    public List<FeedbackLine> getFeedLineList(FeedbackLine feedbackLine);

    public FeedbackLine getFeedLine(FeedbackLine feedbackLine);

    public int getFeedLineCount(FeedbackLine feedbackLine);

    public void updateLine(FeedbackLine line);

    public void deleteLine(FeedbackLine line);


    //피드백 정보들..
    public List<FeedBackDataVo> getFeedBackTotalList(FeedBackDataVo feedBackDataVo);

}
