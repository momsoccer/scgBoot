package com.scg.api.point;

import com.scg.model.Common.PointTrVo;
import com.scg.model.PointManagement;
import com.scg.model.SpBalanceHeader;
import com.scg.model.SpBalanceLine;
import com.scg.persistence.SelfPointMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sungbo on 2016-06-11.
 */
@Service
public class SelfPoinService {

    private static final Logger logger = LoggerFactory.getLogger(SelfPoinService.class);

    @Autowired
    private SelfPointMapper selfPointMapper;

    //현재 포인트를 리턴한다
    public void saveHeaderPoint(SpBalanceHeader header){
        selfPointMapper.saveHeaderPoint(header);
    }

    public void updateHeaderPoint(int headerid, int uid, int amount){

        selfPointMapper.updateHeaderPoint(headerid, uid, amount);
    }

    //라인은 생성만 있다
    public void saveLinePoint(SpBalanceLine line){
        selfPointMapper.saveLinePoint(line);
    }

    public SpBalanceLine getLinePoint(int headerid){
        return selfPointMapper.getLinePoint(headerid);
    };

    public SpBalanceHeader getSelfPointAmount(SpBalanceHeader header){

        SpBalanceHeader balanceHeader = null;

        try{
            balanceHeader = selfPointMapper.getSelfPointAmount(header);
        }catch (Exception e){

        }

        if( balanceHeader == null){
            balanceHeader = new SpBalanceHeader();
        }

        return balanceHeader;
    }

    public PointManagement getPointInfo(PointManagement pointType){
        return selfPointMapper.getPointInfo(pointType);
    };

    public PointTrVo getPointTr(PointTrVo pointTrVo){
        return selfPointMapper.getPointTr(pointTrVo);
    };


    public List<SpBalanceLine> getCashLineList(SpBalanceLine spBalanceLine){
        return selfPointMapper.getCashLineList(spBalanceLine);
    };


}
