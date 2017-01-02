package com.scg.api.point;

import com.scg.model.CpBalanceHeader;
import com.scg.model.CpBalanceLine;
import com.scg.persistence.CashPointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungbo on 2016-06-11.
 */
@Service
public class CashPointService {

    @Autowired
    CashPointMapper cashPointMapper;

    public void saveHeaderPoint(CpBalanceHeader header){
        cashPointMapper.saveHeaderPoint(header);
    }

    //라인은 생성만 있다
    public void saveLinePoint(CpBalanceLine line){
        cashPointMapper.saveLinePoint(line);
    }


    public CpBalanceHeader getCpfPointAmount(CpBalanceHeader header){
        return cashPointMapper.getCpfPointAmount(header);
    }



}
