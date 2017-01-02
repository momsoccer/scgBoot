CREATE DEFINER=`app`@`%` PROCEDURE `delete_user`(in puid int)
BEGIN

	#미션 댓글 삭제
    delete from board  where uid = puid;
    delete from board  where writeuid = puid;
    
    #유저 수행 미션
    delete from usermission where uid = puid;
    
    #피드백 라인
    delete from feedback_line where feedbackid in 
	(select feedbackid from feedback_header where uid =puid);
    
    #피드백헤더
    delete from feedback_header where uid = puid;
    
    #유저 권한
    delete
	from userrole
	where uid = puid;
    
    #푸쉬토큰
    delete
	from fcm_token
	where uid = puid;
    
    #미션 즐겨찾기
    delete
	from favoritemission
	where uid = puid;
    
    #미션오픈 히스토리
    delete
	from mission_open_history
	where uid = puid;
    
    #북마크
	delete
	from mybookmark
	where uid = puid;
    
    delete
	from teammember
	where uid = puid;
    
    delete
    from team_apply
	where uid = puid;
    
    #포인트 적립 및 사용 라인
    delete
	from self_point_balance_line
	where headerid in 
	(
	select headerid
	from self_point_balance_header
	where uid = puid
	);
    
    #포인트 적립 및 사용 헤더
	delete
	from self_point_balance_header
	where uid = puid;
    
    #일일 적립 포인트
    delete
	from user_daily_history
	where uid = puid;

	#친구추가
	delete
	from user_friend_apply
	where requid =puid;

	#친구삭제
	delete
	from user_friend_apply
	where resuid =puid;
    
    delete
	from user_mission_pass
	where uid = puid;

	delete
	from user_video_history
	where uid = puid;

	delete
	from report
	where uid = puid;
    
	delete
	from report
	where publisherid = puid;
    
    #게시판 정보 지우기
	delete
	from board_line
	where uid = puid;

	delete
	from board_line
	where boardid in 
	(
	select boardid
	from board_header
	where uid = puid
	);

	delete
	from board_file
	where boardid in 
	(
	select boardid
	from board_header
	where uid = puid
	);

	delete
	from board_header
	where uid = puid;
    
    #팔로워 팔로우 아이디
    delete
	from followmanage
	where uid = puid;

	delete
	from followmanage
	where followuid = puid;
    
    #유저 삭제
    delete
    from user where uid = puid;
    
    #토큰 삭제
    delete
    from fcm_token where uid = puid;
END