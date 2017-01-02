package com.scg.persistence;

import com.scg.model.FcmToken;

import java.util.List;

/**
 * Created by sungbo on 2016-06-30.
 */
public interface FcmTokenMapper {

    public FcmToken getFcmToken(FcmToken token);

    public int saveFcmToken(FcmToken token);
    public void updateFcmToken(FcmToken token);
    public void deleteFcmToken(FcmToken token);

    public List<FcmToken> getFcmTokenList(FcmToken token);
    public int getFcmTokenCount(FcmToken token);

    public FcmToken getFcmTokenCompare(FcmToken fcmToken);

}
