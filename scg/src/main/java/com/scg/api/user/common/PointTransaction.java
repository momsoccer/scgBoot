package com.scg.api.user.common;

import com.scg.api.point.SelfPoinService;
import com.scg.model.Common.ServerResult;
import com.scg.model.PointManagement;
import com.scg.model.SpBalanceHeader;
import com.scg.model.SpBalanceLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sungbo on 2016-06-17.
 * 포인트 관련 오브젝변경 가입시, 출석체크시만 사용
 */
public class PointTransaction {

    private static final Logger logger = LoggerFactory.getLogger(PointTransaction.class);

    public PointTransaction(SelfPoinService selfPoinService){
        this.selfPoinService = selfPoinService;
    }

    private SelfPoinService selfPoinService;
    private int uid;
    private String transactionSign;
    private String poinType;
    private String lang;
    private String missionpaycode = "null";
    private int missionid;

    private int last_amount = 0;

    public PointTransaction(SelfPoinService selfPoinService, int uid, String transactionSign, String poinType, String lang) {
        this.selfPoinService = selfPoinService;
        this.uid = uid;
        this.transactionSign = transactionSign;
        this.poinType = poinType;
        this.lang = lang;
    }

    public PointTransaction(SelfPoinService selfPoinService, int uid, String transactionSign, String poinType, String lang, String missionpaycode, int missionid) {
        this.selfPoinService = selfPoinService;
        this.uid = uid;
        this.transactionSign = transactionSign;
        this.poinType = poinType;
        this.lang = lang;
        this.missionpaycode = missionpaycode;
        this.missionid = missionid;
    }

    /**********************************************
     *  2016.08.23 미션을 제외한 포인트 +
     * *************************************************/

    private int currentAmount = 0;
    private int lastAmount = 0 ;

    public void newPointTrPlus(int uid,int trAmount,String trType,String pointDescription){

        SpBalanceHeader header = new SpBalanceHeader();
        SpBalanceLine line = new SpBalanceLine();

        header.setUid(uid);
        header = selfPoinService.getSelfPointAmount(header);
        currentAmount = header.getAmount();
        lastAmount = currentAmount + trAmount;

        line.setHeaderid(header.getHeaderid());
        line.setUid(header.getUid());
        line.setPreviousamount(currentAmount);
        line.setInamount(trAmount);
        line.setLastamount(lastAmount);
        line.setType(trType);
        line.setDescription(pointDescription);

        //헤더저장
        selfPoinService.updateHeaderPoint(header.getHeaderid(),header.getUid(),lastAmount);
        selfPoinService.saveLinePoint(line);

    }

    public ServerResult newPointMinus(int uid,int trAmount,String trType){

        return new ServerResult(1,"S");
    }

    /***********************************************************************************************/
    //신규유저만 사용.
    public int SelfPointTr(){

        PointManagement paramPointType = new PointManagement();
        paramPointType.setTypecode(poinType);
        paramPointType.setLang(lang);
        paramPointType.setSign(transactionSign);

        //생성자 값이 없는 경우, 값이 없음으로 간주
        //지급일 경우 mission pay code 가 존재 한다

        PointManagement pointType = selfPoinService.getPointInfo(paramPointType);

        SpBalanceHeader header = new SpBalanceHeader();
        header.setUid(uid);
        SpBalanceHeader resultHeader = selfPoinService.getSelfPointAmount(header);

        //기존 헤더의 금액을 가져온다
        int preResultAmount = resultHeader.getAmount();

        logger.info("기존 금액 : " + preResultAmount);

        //유저에게 지급 이라면
        if(transactionSign.equals("+")){

            last_amount = preResultAmount + pointType.getPoint();

            logger.info("변경될 총 금액 : " + last_amount);

            selfPoinService.updateHeaderPoint(resultHeader.getHeaderid(), resultHeader.getUid(), last_amount);

            //라인에 지급내역 표기
            SpBalanceLine line = new SpBalanceLine();
            line.setType(pointType.getTypecode());
            line.setHeaderid(resultHeader.getHeaderid());
            line.setDescription(pointType.getTypedescription());
            line.setPreviousamount(preResultAmount);
            line.setInamount(pointType.getPoint());
            line.setMissionid(missionid);
            line.setLastamount(last_amount);
            line.setOutamount(0);
            line.setPointid(pointType.getPointid());
            selfPoinService.saveLinePoint(line);

            logger.info("포인트 지급이 완료 되었습니다");

        //유저가 포인트 사용이라면
        }else{

            //남아있는 포인트가 지급할 금액보다 작다면 0으로 리턴
            if(pointType.getPoint() > preResultAmount ){
                logger.info("포인트 잔고가 부족합니다, 남은 금액: " +preResultAmount + " , 지급 금액 : "+ pointType.getPoint());
                return 0;
            }else{
                //지급할 포인트가 있다면
                logger.info("포인트 잔고가 충분 합니다 남은금액 : " +preResultAmount + " , 지급 금액 : "+ pointType.getPoint());
                last_amount = preResultAmount - pointType.getPoint();

                selfPoinService.updateHeaderPoint(resultHeader.getHeaderid(), resultHeader.getUid(), last_amount);
                //라인에 지급내역 표기
                SpBalanceLine line = new SpBalanceLine();
                line.setType(pointType.getTypecode());
                line.setHeaderid(resultHeader.getHeaderid());
                line.setDescription(pointType.getTypedescription());
                line.setPreviousamount(preResultAmount);
                line.setInamount(0);
                line.setLastamount(last_amount);
                line.setOutamount(pointType.getPoint());
                line.setMissionid(missionid);
                line.setPointid(pointType.getPointid());
                selfPoinService.saveLinePoint(line);

                logger.info("포인트를 사용이 완료 되었습니다");
            }

        }
        //잔액을 리턴 한다
        return last_amount;
    }
}
