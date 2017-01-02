package com.scg.api.common;

import com.scg.model.FcmToken;
import com.scg.persistence.FcmTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FcmTokenService {
    protected org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());

    @Autowired
    FcmTokenMapper fcmTokenMapper;

    public int saveFcmToken(FcmToken token){
        return fcmTokenMapper.saveFcmToken(token);
    };

    public void updateFcmToken(FcmToken token){
        fcmTokenMapper.updateFcmToken(token);
    };

    public List<FcmToken> getFcmTokenList(FcmToken token){
        return fcmTokenMapper.getFcmTokenList(token);
    };

    public void deleteFcmToken(FcmToken token){
        fcmTokenMapper.deleteFcmToken(token);
    };

    public int getFcmTokenCount(FcmToken token){
        return fcmTokenMapper.getFcmTokenCount(token);
    };

    public FcmToken getFcmTokenCompare(FcmToken fcmToken){
        FcmToken resultTooken=null;
        try{
            resultTooken =  fcmTokenMapper.getFcmTokenCompare(fcmToken);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(resultTooken==null){
            resultTooken = new FcmToken();
        }

        return resultTooken;
    };

    public FcmToken getFcmToken(FcmToken token){

        FcmToken fcmToken=null;
        try{
            fcmToken =  fcmTokenMapper.getFcmToken(token);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(fcmToken==null){
            fcmToken = new FcmToken();
        }
        return fcmToken;

    };

}
