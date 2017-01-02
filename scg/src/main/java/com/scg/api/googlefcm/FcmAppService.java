package com.scg.api.googlefcm;

import com.scg.persistence.FcmTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sungbo on 2016-09-13.
 *
 *  토큰 발송을 위한 Service
 *
 */

@Service
public class FcmAppService {

    @Autowired
    FcmTokenMapper tokenMapper;



}
