package com.scg.api.point;

import com.scg.model.Common.PointTrVo;
import com.scg.model.Common.ServerResult;
import com.scg.model.SpBalanceHeader;
import com.scg.model.SpBalanceLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sungbo on 2016-08-09.
 */

@RestController
@RequestMapping("/api/user/")
public class PointController {

    private static final Logger logger = LoggerFactory.getLogger(PointController.class);

    @Autowired
    SelfPoinService selfPoinService;

    @RequestMapping("getCashLineList")
    public List<SpBalanceLine> getCashLineList(@RequestParam("uid") int uid){
        logger.info("parameter value : " + uid);

        SpBalanceLine  line = new SpBalanceLine();
        line.setUid(uid);

        List<SpBalanceLine> spBalanceLines = selfPoinService.getCashLineList(line);

        logger.info("spBalanceLines : " + spBalanceLines.get(0).toString());

        return spBalanceLines;
    }



    //포인트 차감 및 지급에 관련 메서드
    @RequestMapping("pointTr")
    public ServerResult pointTransaction(
            @RequestBody PointTrVo pointTrVo){

        logger.info("pointTrVo : "+pointTrVo.toString());


        PointTrVo dbvPointVo = selfPoinService.getPointTr(pointTrVo);

        SpBalanceHeader queryHeader = new SpBalanceHeader();
        queryHeader.setUid(pointTrVo.getUid());

        //현재금액
        SpBalanceHeader header = selfPoinService.getSelfPointAmount(queryHeader);

        //미션오픈을 위한 지급액
        if(pointTrVo.getTypecode().equals("MISSION") && pointTrVo.getTrType().equals("G")){

            SpBalanceLine line = new SpBalanceLine();
            line.setHeaderid(header.getHeaderid());
            line.setPreviousamount(header.getAmount());
            line.setOutamount(dbvPointVo.getEscapepoint());

            //가지고 있는 돈보다 지급할 금액이 클경우
            if(header.getAmount() < dbvPointVo.getEscapepoint() ){
                return new ServerResult(0,"F","lack point");
            }else{
                //라인 금액 이력 만들기
                line.setType(pointTrVo.getTypecode());
                line.setLastamount( header.getAmount() - dbvPointVo.getEscapepoint() );
                line.setMissionid(pointTrVo.getMissionid());
                line.setPointid(dbvPointVo.getPointid());
                line.setDescription("미션 오픈");
                selfPoinService.saveLinePoint(line);
                selfPoinService.updateHeaderPoint(line.getHeaderid(),pointTrVo.getUid(),line.getLastamount());
            }
        }

        return new ServerResult(1,"S");
    }

}
