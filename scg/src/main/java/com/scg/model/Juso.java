package com.scg.model;

/**
 * Created by KIMU on 2016. 7. 11..
 */
public class Juso {

    private String roadAddr;
    private String roadAddrPart1;
    private String roadAddrPart2;
    private String jibunAddr;
    private String engAddr;
    private String zipNo;
    private String admCd;
    private String rnMgtSn;
    private String bdMgtSn;
    private String detBdNmList;
    //naver 변수
    private String address;
    private JusoAddrDetail addrdetail;
    private String isRoadAddress;
    private JusoPoint point;

    public String getRoadAddr() {
        return roadAddr;
    }

    public void setRoadAddr(String roadAddr) {
        this.roadAddr = roadAddr;
    }

    public String getRoadAddrPart1() {
        return roadAddrPart1;
    }

    public void setRoadAddrPart1(String roadAddrPart1) {
        this.roadAddrPart1 = roadAddrPart1;
    }

    public String getRoadAddrPart2() {
        return roadAddrPart2;
    }

    public void setRoadAddrPart2(String roadAddrPart2) {
        this.roadAddrPart2 = roadAddrPart2;
    }

    public String getJibunAddr() {
        return jibunAddr;
    }

    public void setJibunAddr(String jibunAddr) {
        this.jibunAddr = jibunAddr;
    }

    public String getEngAddr() {
        return engAddr;
    }

    public void setEngAddr(String engAddr) {
        this.engAddr = engAddr;
    }

    public String getZipNo() {
        return zipNo;
    }

    public void setZipNo(String zipNo) {
        this.zipNo = zipNo;
    }

    public String getAdmCd() {
        return admCd;
    }

    public void setAdmCd(String admCd) {
        this.admCd = admCd;
    }

    public String getRnMgtSn() {
        return rnMgtSn;
    }

    public void setRnMgtSn(String rnMgtSn) {
        this.rnMgtSn = rnMgtSn;
    }


    public String getBdMgtSn() {
        return bdMgtSn;
    }

    public void setBdMgtSn(String bdMgtSn) {
        this.bdMgtSn = bdMgtSn;
    }

    public String getDetBdNmList() {
        return detBdNmList;
    }

    public void setDetBdNmList(String detBdNmList) {
        this.detBdNmList = detBdNmList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public JusoAddrDetail getAddrdetail() {
        return addrdetail;
    }

    public void setAddrdetail(JusoAddrDetail addrdetail) {
        this.addrdetail = addrdetail;
    }

    public String getIsRoadAddress() {
        return isRoadAddress;
    }

    public void setIsRoadAddress(String isRoadAddress) {
        this.isRoadAddress = isRoadAddress;
    }

    public JusoPoint getPoint() {
        return point;
    }

    public void setPoint(JusoPoint point) {
        this.point = point;
    }


}
