package com.scg.api.feedback;

import com.scg.api.googlefcm.Push;
import com.scg.api.googlefcm.PushService;
import com.scg.api.point.SelfPoinService;
import com.scg.api.user.common.PointTransaction;
import com.scg.datadto.FeedBackDataVo;
import com.scg.model.*;
import com.scg.model.Common.ServerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by sungbo on 2016-06-20.
 */

@RestController
@RequestMapping("/api/feed/")
public class FeedBackController {

    @Autowired
    FeedBackService feedService;

    @Autowired
    SelfPoinService selfPoinService;

    @Autowired
    PushService pushService;

    private static final Logger logger = LoggerFactory.getLogger(FeedBackController.class);


    @RequestMapping("getFeedBackTotalList")
    public List<FeedBackDataVo> getFeedBackTotalList(@RequestBody FeedBackDataVo vo){
        return feedService.getFeedBackTotalList(vo);
    }

    @RequestMapping("saveLine")
    public ServerResult requestFeed(@RequestBody FeedbackLine line){
        feedService.saveFeedLine(line);

        FeedbackHeader feedbackHeader = new FeedbackHeader();
        feedbackHeader.setFeedbackid(line.getFeedbackid());
        feedbackHeader  = feedService.getFeedHeader(feedbackHeader);

        //푸쉬 생성
        Message message = new Message(Push.PUSH_TITLE_FEEDBACK_REPLY,
                //피드백 제목
                 feedbackHeader.getInsname() + "(강사님 답변)"
                ,line.getContent());
        pushService.pushExecute(Push.PUSHTYPE_FEEDBACK_USER,0,feedbackHeader.getUid(), 0, message);

        return new ServerResult(1,"S");
    }

    @RequestMapping("requestFeed")
    public List<FeedbackHeader> requestFeed(@RequestBody FeedbackHeader feedbackHeader){
        return feedService.requestFeed(feedbackHeader);
    }

    //getFeedAllList
    @RequestMapping("getFeedAllList")
    public List<FeedbackHeader> getFeedAllList(@RequestBody FeedbackHeader feedbackHeader){

        logger.info("미션 정보는 : " + feedbackHeader.getUsermissionid());

        return feedService.getFeedAllList(feedbackHeader);
    }


    @RequestMapping("updateContent")
    public ServerResult updateContent(@RequestBody FeedbackLine line){

        logger.info("line 확인 : " +  line.toString());

        line.setType("ins");
        int feedBackCount = feedService.getFeedLineCount(line);

        if(feedBackCount == 0){
            //유저의 콘텐츠를 업데이트
            line.setType("user");
            feedService.updateLine(line);

            return new ServerResult(1,"S");
        }else{
            return new ServerResult(0,"E");
        }

    }

    @RequestMapping("deleteLine")
    public ServerResult deleteLine(@RequestBody FeedbackLine line){

        logger.info("line 확인 : " +  line.toString());

        line.setType("ins");
        int feedBackCount = feedService.getFeedLineCount(line);

        if(feedBackCount == 0){
            //미션라인삭제
            feedService.deleteLine(line);

            //포인트환수
            FeedbackHeader feedbackHeader = new FeedbackHeader();
            feedbackHeader.setFeedbackid(line.getFeedbackid());

            logger.info("값 확인 1 : " + feedbackHeader.toString());

            feedbackHeader = feedService.getFeedHeader(feedbackHeader);

            logger.info("값 확인 2 : " + feedbackHeader.toString());

            PointTransaction pointTransaction = new PointTransaction(selfPoinService);
            pointTransaction.newPointTrPlus(feedbackHeader.getUid(),feedbackHeader.getCashpoint(),"FEEDBACK_REQ_BACK","피드백 취소 환급");
            return new ServerResult(1,"S");
        }else{
            return new ServerResult(0,"E");
        }

    }

    @RequestMapping("updateLine")
    public ServerResult updateLine(@RequestBody FeedbackLine line){
        feedService.updateLine(line);
        return new ServerResult(1,"S");
    }

    @RequestMapping("getFeedLineCount")
    public ServerResult getFeedLineCount(@RequestBody FeedbackLine line){
        return new ServerResult(feedService.getFeedLineCount(line),"S");
    }


    @RequestMapping("getFeedBackList")
    public List<FeedbackHeader> getFeedBackList(@RequestBody FeedbackHeader header){

        List<FeedbackHeader> feedbackHeaders = feedService.getFeedBackList(header);

        return feedbackHeaders;
    }


    @RequestMapping(value = "saveFeedHeader" , method = RequestMethod.POST)
    public ServerResult saveFeedHeader(@RequestBody FeedbackHeader header){
        logger.info("피드백 생성 요청 : " + header.toString());

        //포인트가 남아 있는지 검증
        SpBalanceHeader balanceHeader = new SpBalanceHeader();
        balanceHeader.setUid(header.getUid());
        balanceHeader = selfPoinService.getSelfPointAmount(balanceHeader);

        int initial_amount = balanceHeader.getAmount();

        int last_amount = initial_amount - header.getCashpoint();

        if(last_amount < 0){
            //포인트가 부족하다면
            return new ServerResult(0,"R","Point lack");
        }else {
            //포인트가 된다면...

            selfPoinService.updateHeaderPoint(balanceHeader.getHeaderid(), header.getUid(), last_amount);

            SpBalanceLine spBalanceLine = new SpBalanceLine();

            spBalanceLine.setHeaderid(balanceHeader.getHeaderid());
            spBalanceLine.setType("FEEDBACK_REQ");
            spBalanceLine.setPreviousamount(initial_amount);
            spBalanceLine.setOutamount(header.getCashpoint());
            spBalanceLine.setLastamount(last_amount);
            spBalanceLine.setMissionid(header.getMissionid());
            spBalanceLine.setDescription("미션 피드백 요청");

            selfPoinService.saveLinePoint(spBalanceLine);


            //피드백 생성
            feedService.saveFeedHeader(header);
            int feedbackid = header.getFeedbackid();

            FeedbackLine line = new FeedbackLine();
            line.setFeedbackid(feedbackid);
            line.setType(header.getType());
            line.setVideoaddr(header.getVideoaddr());
            line.setContent(header.getContent());

            feedService.saveFeedLine(line);

            //푸쉬 생성
            Message message = new Message(Push.PUSH_TITLE_FEEDBACK_REG,header.getSubject()+":"+header.getFeedbacktype(),header.getContent());
            pushService.pushExecute(Push.PUSHTYPE_FEEDBACK_INS, header.getInstructorid(),0,0, message);


            return new ServerResult(1, "S");
        }
    }

    @RequestMapping(value = "getFeedHeaderList" , method = RequestMethod.POST)
    public List<FeedbackHeader> getFeedHeaderList(@RequestBody FeedbackHeader header){
        logger.info("피드백 헤더 리스트 정보를 가져옵니다");
        return feedService.getFeedHeaderList(header);
    }

    @RequestMapping(value = "getFeedHeader" , method = RequestMethod.POST)
    public FeedbackHeader getFeedHeader(@RequestBody FeedbackHeader header){

        FeedbackHeader feedbackHeader = feedService.getFeedHeader(header);
        return feedbackHeader;
    }

    @RequestMapping(value = "feedheaderCount" , method = RequestMethod.POST)
    public ServerResult feedheaderCount(HttpServletRequest request,
            @RequestBody FeedbackHeader header){

        Enumeration eHeader = request.getHeaderNames();

        while (eHeader.hasMoreElements()) { //요소가 있으면 True, 없으면 false를 반환
            //eHeader.nextElement() //다음 요소를 반환한다

            String hName = (String)eHeader.nextElement();
            String hValue = request.getHeader(hName);

            logger.info(hName + " : " + hValue);
        }
        ServerResult result = new ServerResult(feedService.getFeedHeaderCount(header),null);


        return result;
    }


}
