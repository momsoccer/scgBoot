package com.scg.api.googlefcm;

/**
 * Created by sungbo on 2016-09-14.
 */
public class Push {
    //team , feed , feedebal, alluser, allins
    final public static String PUSHTYPE_TEAM = "TEAM";
    final public static String PUSHTYPE_FEEDBACK_USER = "FEEDBACK_USER";
    final public static String PUSHTYPE_FEEDBACK_INS = "FEEDBACK_INS";
    final public static String PUSHTYPE_FEEDBACK_EVAL_USER = "FEEDBACK_EVAL_USER";
    final public static String PUSHTYPE_FEEDBACK_EVAL_INS = "FEEDBACK_EVAL_INS";
    final public static String PUSHTYPE_ALL = "ALLUSER";
    final public static String PUSHTYPE_MISSION_COMMENT = "MISSION_COMMENT";

    final public static String PUSHTYPE_REQ_TEAMJOIN = "TEAM_JOIN";
    final public static String PUSHTYPE_REQ_TEAMAPPROVAL = "TEAM_APPROVAL";

    //강사승인
    final public static String PUSHTYPE_APPROVAL_INS = "INSAPPROVAL";

    //회원가입
    final public static String PUSHTYPE_JOIN_EXECUTE = "JOIN";

    //팀게시글
    final public static String PUSHTYPE_COMMENT_USER = "USER";
    final public static String PUSHTYPE_FRIEND_REQ = "FRIEND_REQ";

    //미션등록
    final public static String PUSHTYPE_SEEDMISSION_REG = "MISSION_REG";


    final public static String PUSHTYPE_LESSON = "PUSHTYPE_LESSON";

    //푸쉬 타이틀 영문화 필요
    final public static String PUSH_TITLE_ALL = "몸싸커 공지글 입니다";
    final public static String PUSH_TITLE_BOARD_TEAM = "팀게시판에 글이 등록되었습니다";
    final public static String PUSH_TITLE_BOARD_COMMNET = "댓글이 등록되었습니다";
    final public static String PUSH_TITLE_FEEDBACK_REG = "피드백 요청이 있습니다";
    final public static String PUSH_TITLE_FEEDBACK_REPLY = "피드백 답변이 도착했습니다";
    final public static String PUSH_TITLE_FEEDBACK_EVAL_REG = "피드백 심사 요청이 있습니다";
    final public static String PUSH_TITLE_FEEDBACK_EVAL_REPLY = "피드백 심사결과가 도착했습니다";
    final public static String PUSH_TITLE_FRIEND_REQ = "친구신청이 왔습니다";
    final public static String PUSH_TITLE_MISSION_COMMENT = "수행한 미션에 댓글이 등록 되었습니다";
    final public static String PUSH_TITLE_TEAM_JOIN_REQ = "팀 가입 요청이 왔습니다";
    final public static String PUSH_TITLE_TEAM_JOIN_APPROVAL = "팀 가입이 승인 되었습니다";

    final public static String PUSH_TITLE_USER_JOIN = "팀 가입이 승인 되었습니다";
    //message
    final public static String TEAM_JOIN_MESSAGE = "팀 가입을 희망합니다. 승인 부탁드립니다";
    final public static String TEAM_JOIN_APPROVAL = "팀 가입을 승인합니다. 반갑습니다";
    final public static String INS_APPROVAL = "몸싸커의 강사가 되셨습니다. 축하드립니다";
    final public static String USER_APPROVAL = "몸싸커 가입을 축하드립니다";

    //미션등록
    final public static String SEED_MISSION_REG = "새로운 미션이 등록되었습니다";

}
