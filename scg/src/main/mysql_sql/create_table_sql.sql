CREATE TABLE `adv_board` (
  `advid` int(11) NOT NULL AUTO_INCREMENT,
  `addr` varchar(255) NOT NULL,
  `introduce` varchar(500) DEFAULT NULL,
  `subcontent1` varchar(45) DEFAULT NULL,
  `subcontent2` varchar(45) DEFAULT NULL,
  `subcontent3` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `creationdate` datetime NOT NULL,
  `youtubeaddr` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`advid`),
  UNIQUE KEY `advid_UNIQUE` (`advid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='광고게시판';

CREATE TABLE `adv_board_file` (
  `fileid` int(11) NOT NULL AUTO_INCREMENT,
  `advid` int(11) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `fileaddr` varchar(255) NOT NULL,
  PRIMARY KEY (`fileid`),
  UNIQUE KEY `fileid_UNIQUE` (`fileid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='광고첨부테이블';

CREATE TABLE `board` (
  `boardid` int(11) NOT NULL AUTO_INCREMENT,
  `usermissionid` int(11) NOT NULL COMMENT '유저 미션 아이디',
  `uid` int(11) NOT NULL COMMENT '미션 오너',
  `writeuid` int(11) NOT NULL COMMENT '글을 입력한 유저',
  `comment` varchar(300) NOT NULL,
  `creationdate` datetime NOT NULL,
  `updatedate` datetime NOT NULL,
  PRIMARY KEY (`boardid`),
  UNIQUE KEY `boardid_UNIQUE` (`boardid`),
  KEY `boardid_n1` (`usermissionid`,`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;

CREATE TABLE `board_file` (
  `fileid` int(11) NOT NULL AUTO_INCREMENT,
  `boardid` int(11) NOT NULL COMMENT '해당 게시물의 파일id',
  `filename` varchar(200) DEFAULT NULL,
  `fileaddr` varchar(500) NOT NULL,
  `crationdate` datetime DEFAULT NULL,
  PRIMARY KEY (`fileid`),
  UNIQUE KEY `fileid_UNIQUE` (`fileid`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8;

CREATE TABLE `board_header` (
  `boardid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `category` varchar(45) DEFAULT NULL COMMENT '공지 : A, 일반, B',
  `boardtype` varchar(45) NOT NULL COMMENT 'team 팀전용,club 클럽전용,all 전체유저',
  `subject` varchar(100) DEFAULT NULL,
  `content` varchar(500) NOT NULL,
  `boardtypeid` int(11) DEFAULT NULL COMMENT 'teamid,clubid',
  `pubtype` varchar(45) DEFAULT NULL COMMENT 'Y,N 전체 공개, 해당 모임만 공개 여부 ',
  `creationdate` datetime NOT NULL,
  `updatedate` datetime NOT NULL,
  PRIMARY KEY (`boardid`),
  UNIQUE KEY `boardid_UNIQUE` (`boardid`)
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=utf8;

CREATE TABLE `board_like` (
  `likeid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '좋아용 한사람',
  `boardid` int(11) NOT NULL COMMENT '게시물 아이디 ',
  `creationdate` datetime NOT NULL,
  PRIMARY KEY (`likeid`),
  UNIQUE KEY `likeid_UNIQUE` (`likeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cash_point_balance_header` (
  `headerid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `updatedate` datetime NOT NULL,
  UNIQUE KEY `headerid_UNIQUE` (`headerid`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

CREATE TABLE `cash_point_balance_line` (
  `lineid` int(11) NOT NULL AUTO_INCREMENT,
  `headerid` int(11) NOT NULL,
  `type` varchar(100) NOT NULL,
  `previous_amount` int(11) NOT NULL,
  `in_amount` int(11) NOT NULL,
  `out_amount` int(11) NOT NULL,
  `last_amount` int(11) NOT NULL,
  `description` varchar(300) NOT NULL,
  `creationdate` datetime NOT NULL,
  UNIQUE KEY `lineid_UNIQUE` (`lineid`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

CREATE TABLE `favoritemission` (
  `favoriteid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `missionid` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `attribute1` varchar(255) DEFAULT NULL,
  `attribute2` varchar(255) DEFAULT NULL,
  `attribute3` varchar(255) DEFAULT NULL,
  `attribute4` varchar(255) DEFAULT NULL,
  `attribute5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`favoriteid`),
  UNIQUE KEY `favoriteid_UNIQUE` (`favoriteid`),
  KEY `favoriteid_u1` (`uid`,`missionid`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COMMENT='미션 즐겨 찾기...';

CREATE TABLE `fcm_token` (
  `commontokenid` int(11) NOT NULL AUTO_INCREMENT,
  `fcmtoken` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL COMMENT '유저 아이디',
  `instructorid` int(11) DEFAULT NULL COMMENT '강사아이디',
  `serialnumber` varchar(255) DEFAULT NULL,
  `creationdate` datetime NOT NULL,
  `updatedate` datetime NOT NULL,
  PRIMARY KEY (`commontokenid`),
  UNIQUE KEY `id_UNIQUE` (`commontokenid`)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8 COMMENT='앱을 설치한 모든 사람의 토큰을 관리하는 테이블\n앱이 실행시 토큰테이블에 토큰 값을 입력한다.';

CREATE TABLE `feedback_header` (
  `feedbackid` int(11) NOT NULL AUTO_INCREMENT,
  `feedbacktype` varchar(100) NOT NULL COMMENT '영상 피드백/코멘트 피드백 요청',
  `missionid` int(11) NOT NULL COMMENT '미션아이디',
  `usermissionid` int(11) NOT NULL COMMENT '유저업로드 미션 수행 아이디',
  `uid` int(11) NOT NULL COMMENT '요청 유저 아이디',
  `instructorid` int(11) NOT NULL COMMENT '강사아이디',
  `cashpoint` int(11) NOT NULL COMMENT '피드백에 대한 캐쉬포인트',
  `Frequency` int(11) NOT NULL COMMENT '피드백 회차',
  `subject` varchar(255) NOT NULL COMMENT '요청 제목',
  `pubstatus` varchar(45) NOT NULL COMMENT '다른 유저에게 공개=Y,비공개=N',
  `instype` varchar(45) DEFAULT NULL COMMENT '지정 강사에게 피드백이면 Y 아니면 N',
  `creationdate` datetime NOT NULL COMMENT '발생일자',
  UNIQUE KEY `feedbackid_UNIQUE` (`feedbackid`),
  KEY `feedback_header_n1` (`usermissionid`,`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

CREATE TABLE `feedback_history` (
  `feedbackhistoryid` int(11) NOT NULL AUTO_INCREMENT,
  `feedbackid` int(11) NOT NULL,
  `cashpoint` int(11) NOT NULL,
  `missionid` int(11) NOT NULL,
  `usermissionid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `frequency` int(11) NOT NULL,
  `instructorid` int(11) NOT NULL,
  `creationdate` datetime DEFAULT NULL,
  UNIQUE KEY `feedbackhistoryid_UNIQUE` (`feedbackhistoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `feedback_line` (
  `feedbacklineid` int(11) NOT NULL AUTO_INCREMENT,
  `feedbackid` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL COMMENT '강사가 쓴글인지 유저가 쓴글인지 구분/user/ins',
  `videoaddr` varchar(255) DEFAULT NULL,
  `content` longtext NOT NULL,
  `image1` varchar(255) DEFAULT NULL,
  `image2` varchar(45) DEFAULT NULL,
  `image3` varchar(45) DEFAULT NULL,
  `evalscore` float DEFAULT NULL,
  `calculateflag` varchar(45) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `creationdate` datetime DEFAULT NULL,
  UNIQUE KEY `feedbacklineid_UNIQUE` (`feedbacklineid`)
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8;

CREATE TABLE `followmanage` (
  `followid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `followuid` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `attribute1` varchar(255) DEFAULT NULL,
  `attribute2` varchar(255) DEFAULT NULL,
  `attribute3` varchar(255) DEFAULT NULL,
  `attribute4` varchar(255) DEFAULT NULL,
  `attribute5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`followid`),
  UNIQUE KEY `followid_UNIQUE` (`followid`),
  KEY `followmanage_n1` (`uid`,`followuid`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;

CREATE TABLE `ins_video_board` (
  `videoid` int(11) NOT NULL,
  `instructorid` int(11) NOT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `content` varchar(500) NOT NULL,
  `youtubeaddr` varchar(45) NOT NULL,
  `teamid` int(11) NOT NULL,
  `filename` varchar(45) DEFAULT NULL,
  `creationdate` datetime NOT NULL,
  PRIMARY KEY (`videoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ins_video_board_line` (
  `lineid` int(11) NOT NULL AUTO_INCREMENT,
  `videoid` int(11) NOT NULL,
  `comment` varchar(500) NOT NULL,
  `uid` int(11) NOT NULL,
  `creationdate` datetime NOT NULL,
  PRIMARY KEY (`lineid`),
  UNIQUE KEY `lineid_UNIQUE` (`lineid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ins_video_like` (
  `likeid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `videoid` int(11) NOT NULL,
  `creationdate` datetime NOT NULL,
  PRIMARY KEY (`likeid`),
  UNIQUE KEY `likeid_UNIQUE` (`likeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `instructor` (
  `instructorid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(200) NOT NULL,
  `profileimgurl` varchar(200) DEFAULT NULL,
  `profile` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL COMMENT '강사인사',
  `phone` varchar(200) NOT NULL,
  `location` int(11) NOT NULL,
  `pointhistoryid` int(11) NOT NULL,
  `feedbackflag` varchar(200) NOT NULL COMMENT '피드백을 서비스 온오프\n수강생으로 부터 피드백을 받는다/안받는다',
  `apppushflag` varchar(1) DEFAULT NULL COMMENT '서버공지를 받겠는가? 안받겠는가?',
  `commontokenid` int(11) DEFAULT NULL COMMENT 'FCM 토큰 아이디',
  `creationdate` datetime DEFAULT NULL,
  `uid` int(11) NOT NULL COMMENT '유저 가입 후 코치가 됨',
  PRIMARY KEY (`instructorid`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `instructorid_UNIQUE` (`instructorid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='강사 테이블';

CREATE TABLE `instructor_apply` (
  `insid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `playeryear` int(11) NOT NULL COMMENT '선수경력년 ',
  `instructoryear` varchar(5000) NOT NULL COMMENT '강사경력 년 ',
  `bankname` varchar(50) DEFAULT NULL,
  `bankaccount` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `currentteamname` varchar(255) DEFAULT NULL,
  `career1` varchar(500) DEFAULT NULL COMMENT '지원 동기',
  `career2` varchar(500) DEFAULT NULL,
  `career3` varchar(500) DEFAULT NULL,
  `career4` varchar(500) DEFAULT NULL,
  `career5` varchar(500) DEFAULT NULL,
  `resume` varchar(1000) NOT NULL COMMENT '유저에게 하고 싶은 말',
  `uid` int(11) NOT NULL,
  `phonenumber` varchar(50) NOT NULL,
  `applystatus` varchar(45) NOT NULL COMMENT '초기값 REQUEST , ACCEPT, APPROVAL',
  `creationdate` datetime NOT NULL,
  `updatedate` datetime NOT NULL,
  `teamimg` varchar(255) DEFAULT NULL COMMENT '팀 이미지 주소',
  `momappteamname` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `instructorid` int(11) DEFAULT NULL COMMENT '강사 지원 승인후 생성',
  PRIMARY KEY (`insid`),
  UNIQUE KEY `insid_UNIQUE` (`insid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='강사지원 테이블';

CREATE TABLE `instructor_point_history` (
  `pointhistoryid` int(11) NOT NULL AUTO_INCREMENT,
  `instructorid` int(11) NOT NULL,
  `teamvideopoint` int(11) NOT NULL COMMENT '팀선수들에 대한 비디오 포인트',
  `teamwordpoint` int(11) NOT NULL COMMENT '팀선수들에 대한 워드 포인트',
  `pubvideopoint` int(11) NOT NULL COMMENT '일반 사람에 대한 비디오 답변 금액',
  `pubwordpoint` int(11) NOT NULL COMMENT '일반사람들에 대한 코멘트 답변금액',
  `teamjoinpoint` int(11) NOT NULL,
  `teampasspoint` int(11) NOT NULL,
  `pubpasspoint` int(11) NOT NULL,
  `creationdate` datetime NOT NULL,
  `updatedate` datetime NOT NULL,
  UNIQUE KEY `pointhistoryid_UNIQUE` (`pointhistoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `mission` (
  `missionid` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) NOT NULL COMMENT '미션 분류 예 : 기초, 일반, 프리스타일, 팀미션등 ',
  `typeid` int(11) NOT NULL COMMENT '드리블,리프팅, Flick, 드리블 등',
  `sequence` int(11) DEFAULT NULL COMMENT '미션을 정렬하기 위한 필드',
  `missionname` varchar(200) DEFAULT NULL COMMENT '미션 제목',
  `description` varchar(500) DEFAULT NULL COMMENT '미션 상세 설명',
  `precon` varchar(200) DEFAULT NULL COMMENT '합격기준 설명',
  `videoaddr` varchar(100) DEFAULT NULL COMMENT '자체 비디오 서버 제작시 CDN 영상 주소',
  `fullyoutubeaddr` varchar(100) DEFAULT NULL COMMENT '웹페이지에서 사용할 유투브 영상 풀주소',
  `youtubeaddr` varchar(45) DEFAULT NULL COMMENT '안드로이드에서 참조할 유튜브 주소',
  `enabled` varchar(1) DEFAULT NULL COMMENT '사용가능',
  `feetype` varchar(45) DEFAULT NULL COMMENT '무료/유료 상품 타입',
  `grade` int(11) NOT NULL COMMENT '업로드시 유저가 획득할 점수',
  `passgrade` int(11) NOT NULL COMMENT '해당미션 성공시 획득 점수',
  `creationdate` datetime NOT NULL,
  `updatedate` datetime NOT NULL,
  PRIMARY KEY (`missionid`),
  UNIQUE KEY `missionid_UNIQUE` (`missionid`),
  KEY `mission_n1` (`missionid`),
  KEY `mission_n2` (`missionid`,`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='유저가 클리어해야될 시드 미션';

CREATE TABLE `mission_category` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `enabled` varchar(1) NOT NULL,
  `creationdate` datetime NOT NULL,
  `lastupdate` datetime NOT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `mission_eval` (
  `evalid` int(11) NOT NULL AUTO_INCREMENT COMMENT '미션에 대한 유저 평가 아이디',
  `missionid` int(11) NOT NULL COMMENT '미션아이디',
  `uid` int(11) NOT NULL COMMENT '평가한 유저 아이디',
  `comment` varchar(500) NOT NULL COMMENT '미션에 대한 유저들의 문의점 등등',
  `userscore` int(11) NOT NULL COMMENT '미션에 대한 유저들의 평가점수',
  `creationdate` datetime NOT NULL,
  UNIQUE KEY `evalid_UNIQUE` (`evalid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='시드미션에 대한 사람들 평가 및 코멘트';

CREATE TABLE `mission_open_history` (
  `historyid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `missionid` int(11) NOT NULL,
  `escapepoint` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `opentype` varchar(255) DEFAULT NULL COMMENT '유저가 일일이 포인트 지급을 해서 오픈을 했는지 프리미어 결재를 통해 오픈 했는지를 표시한다.\neach , premium',
  PRIMARY KEY (`historyid`),
  UNIQUE KEY `historyid_UNIQUE` (`historyid`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8;

CREATE TABLE `mission_sequence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

CREATE TABLE `mission_type` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `enabled` varchar(1) NOT NULL,
  `backgraoundImage` varchar(500) DEFAULT NULL,
  `creationdate` datetime NOT NULL,
  `lastupdate` datetime NOT NULL,
  PRIMARY KEY (`typeid`),
  KEY `mission_type_n1` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE `mom_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `lang` varchar(45) NOT NULL,
  `attribute1` varchar(255) DEFAULT NULL,
  `attribute2` varchar(255) DEFAULT NULL,
  `attribute3` varchar(255) DEFAULT NULL,
  `attribute4` varchar(255) DEFAULT NULL,
  `attribute5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `mom_user_all_board` (
  `allboardid` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(200) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `insflag` varchar(45) NOT NULL COMMENT 'Y면 강사, N이면 유저',
  `creationdate` datetime NOT NULL,
  `youtubeaddr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`allboardid`),
  UNIQUE KEY `allboardid_UNIQUE` (`allboardid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='강사비디오 및 유저 전체 게시판';

CREATE TABLE `mominfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(200) NOT NULL COMMENT '버전정보,이용약관,개인정보취급방지,회사소개',
  `type` varchar(45) DEFAULT NULL COMMENT 'app,web page addr',
  `content` longtext,
  `date` datetime NOT NULL,
  `enabled` varchar(1) NOT NULL COMMENT '사용가능, 아님 Y,n',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='회사정보 및 기타 정보';

CREATE TABLE `mybookmark` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '유저아이디',
  `usermissionid` int(11) DEFAULT NULL COMMENT '관심영상 체크한 아이디',
  PRIMARY KEY (`bookid`),
  UNIQUE KEY `bookid_UNIQUE` (`bookid`),
  KEY `bookmark_n1` (`usermissionid`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8;

CREATE TABLE `pointmanagement` (
  `pointid` int(11) NOT NULL AUTO_INCREMENT,
  `typecode` varchar(45) NOT NULL COMMENT '포인트 정책 참고 코드',
  `typedescription` varchar(255) NOT NULL,
  `point` int(11) NOT NULL COMMENT '미션에서는 사용안함, 오직 가입,출석체크만 사용',
  `lang` varchar(45) DEFAULT NULL COMMENT '사용예정',
  `enabled` varchar(45) NOT NULL,
  `sign` varchar(45) NOT NULL COMMENT '미션에서는 사용안함, 오직 가입,출석체크만 사용',
  `missionid` int(11) DEFAULT NULL COMMENT '관련 미션 아이디',
  `getpoint` int(11) NOT NULL COMMENT '미션을 수행후 패스하게 되면 유저가 얻는 포인트',
  `escapepoint` int(11) NOT NULL COMMENT '미션을 수행하기 위한서 유저가 지불해야될 포인트',
  PRIMARY KEY (`pointid`),
  UNIQUE KEY `pointid_UNIQUE` (`pointid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL COMMENT 'feedback,missionpass,comment,teamboard,missionboard',
  `reason` varchar(500) NOT NULL,
  `uid` int(11) NOT NULL,
  `publisherid` int(11) NOT NULL COMMENT 'uid, instructorid',
  `content` varchar(500) NOT NULL,
  `creationdate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='신고하시 테이블';

CREATE TABLE `request_ad` (
  `reqid` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) NOT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `creationdate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reqid`),
  UNIQUE KEY `reqid_UNIQUE` (`reqid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `self_point_balance_header` (
  `headerid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `updatedate` datetime NOT NULL,
  PRIMARY KEY (`headerid`),
  UNIQUE KEY `uid_UNIQUE` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;

CREATE TABLE `self_point_balance_line` (
  `lineid` int(11) NOT NULL AUTO_INCREMENT,
  `headerid` int(11) NOT NULL,
  `type` varchar(200) NOT NULL COMMENT 'FEEDBACK_REQ 피드백요청, MISSION 미션오픈,EVENT 이벤트 지급,JOIN 가입포인트\nEVAL 심사포인트, DAY 출석체',
  `previousamount` int(11) NOT NULL,
  `inamount` int(11) NOT NULL,
  `outamount` int(11) NOT NULL,
  `lastamount` int(11) NOT NULL,
  `description` varchar(300) NOT NULL,
  `missionid` int(11) DEFAULT NULL,
  `pointid` int(11) DEFAULT NULL,
  `creationdate` datetime NOT NULL,
  UNIQUE KEY `lineid_UNIQUE` (`lineid`)
) ENGINE=InnoDB AUTO_INCREMENT=9469 DEFAULT CHARSET=utf8;

CREATE TABLE `team` (
  `teamid` int(11) NOT NULL AUTO_INCREMENT,
  `instructorid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '팀의 이',
  `emblem` varchar(500) DEFAULT NULL COMMENT '팀 엠블럼',
  `description` varchar(255) DEFAULT NULL COMMENT '팀소개',
  `enabled` varchar(1) DEFAULT NULL COMMENT '팀의 활동 상태',
  `approveflag` varchar(1) DEFAULT NULL,
  `creationdate` datetime NOT NULL,
  `updatedate` datetime NOT NULL,
  UNIQUE KEY `teamid_UNIQUE` (`teamid`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='강사의 온라인 팀';

CREATE TABLE `team_apply` (
  `applyid` int(11) NOT NULL AUTO_INCREMENT,
  `teamid` int(11) NOT NULL,
  `instructorid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `approval` varchar(255) NOT NULL COMMENT 'Request , Approval, Reject',
  `enabled` varchar(1) NOT NULL,
  `reply` varchar(255) DEFAULT NULL,
  `creationdate` datetime NOT NULL,
  `updatedate` datetime NOT NULL,
  UNIQUE KEY `applyid_UNIQUE` (`applyid`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

CREATE TABLE `teammember` (
  `teammemberid` int(11) NOT NULL AUTO_INCREMENT,
  `teamid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `enabled` varchar(1) DEFAULT NULL,
  `authority` varchar(200) DEFAULT NULL COMMENT 'member(팀원),owner(강사)',
  `creationdate` datetime NOT NULL,
  `updatedate` datetime NOT NULL,
  PRIMARY KEY (`teammemberid`),
  UNIQUE KEY `teammemberid_UNIQUE` (`teammemberid`),
  KEY `teammember_n1` (`uid`,`authority`),
  KEY `teammember_n2` (`uid`),
  KEY `teammember_n3` (`teamid`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `useremail` varchar(200) NOT NULL,
  `username` varchar(200) DEFAULT NULL,
  `snsid` varchar(200) DEFAULT NULL,
  `snsname` varchar(200) DEFAULT NULL,
  `snstype` varchar(200) DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `profileimgurl` varchar(250) DEFAULT NULL,
  `googleemail` varchar(250) DEFAULT NULL,
  `location` int(11) DEFAULT NULL COMMENT '주',
  `teampushflag` varchar(1) DEFAULT NULL COMMENT '자신의 팀 서비스 공지를 받겠는가?',
  `apppushflag` varchar(1) DEFAULT NULL COMMENT '서비스 공지를 수신하겠는가?',
  `commontokenid` int(11) DEFAULT NULL COMMENT 'FCM 토큰 아이디',
  `age` int(11) DEFAULT NULL,
  `wifi` varchar(1) DEFAULT NULL,
  `backimage` varchar(200) DEFAULT NULL,
  `creationdate` datetime NOT NULL,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uid_UNIQUE` (`uid`),
  UNIQUE KEY `usermail_UNIQUE` (`useremail`,`snstype`),
  KEY `usern_n1` (`snstype`),
  KEY `usern_n2` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=302 DEFAULT CHARSET=utf8;

CREATE TABLE `user_daily_history` (
  `dailyhistoryid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `yyyymmdd` varchar(8) NOT NULL,
  `creationdate` datetime NOT NULL,
  UNIQUE KEY `dailyhistoryid_UNIQUE` (`dailyhistoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

CREATE TABLE `user_friend` (
  `friendid` int(11) NOT NULL AUTO_INCREMENT,
  `parentuid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `flag` varchar(45) NOT NULL COMMENT '내가 신청해서 친구가 되었을 경우 R\n수락을해서 친구가 되었을 경우     A',
  `applyid` int(11) NOT NULL,
  `creationdate` datetime NOT NULL,
  UNIQUE KEY `friendid_UNIQUE` (`friendid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='친구테이블';

CREATE TABLE `user_friend_apply` (
  `applyid` int(11) NOT NULL AUTO_INCREMENT,
  `requid` int(11) NOT NULL COMMENT '친구 신청자',
  `resuid` int(11) NOT NULL COMMENT '친구요청 받은 사람',
  `flag` varchar(255) NOT NULL COMMENT '신청시 : REQUEST, \n거부시 : REJECT,\n수락시 : ACCEPT 와 동시에 User_friend에 자료 생성',
  `requestmessage` varchar(500) DEFAULT NULL COMMENT '친구 신청 메세지',
  `creationdate` datetime NOT NULL,
  `updatedate` datetime NOT NULL,
  PRIMARY KEY (`applyid`),
  UNIQUE KEY `applyid_UNIQUE` (`applyid`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

CREATE TABLE `user_mission_pass` (
  `passid` int(11) NOT NULL AUTO_INCREMENT,
  `seq` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `instructorid` int(11) DEFAULT NULL,
  `missionid` int(11) DEFAULT NULL,
  `usermissionid` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT 'REQUEST 요청시, success   SUCCESS심사끝일경우',
  `passflag` varchar(45) DEFAULT NULL COMMENT '패스시 Y, 실패시 N',
  `failuredisp` varchar(500) DEFAULT NULL COMMENT '실패 사유',
  `inscomment` varchar(500) DEFAULT NULL COMMENT '강사의 코멘',
  `evaltype` varchar(45) DEFAULT NULL COMMENT '자기팀인지 다른 팀 강사인지',
  `cashpoint` int(11) DEFAULT NULL,
  `creationdate` datetime NOT NULL,
  `updatedate` datetime NOT NULL,
  `calculateflag` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`passid`),
  UNIQUE KEY `passid_UNIQUE` (`passid`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8 COMMENT='유저가 미션을 패스했는지 관리하는 테이블';

CREATE TABLE `user_video_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `missionid` int(11) NOT NULL,
  `filename` varchar(255) NOT NULL COMMENT '중복된 파일명은 유투브에서 재생이 안된다. 검증용으로 기록한다',
  `creationdate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8 COMMENT='유저가 업로드했던 동영상 목록 유투브 업로드 검증용으로 활용';

CREATE TABLE `usermission` (
  `usermissionid` int(11) NOT NULL AUTO_INCREMENT,
  `missionid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `subject` varchar(200) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `uploadflag` varchar(2) DEFAULT NULL COMMENT '영상업로드 표시 Y업로드함, N 업로드 안했음',
  `youtubeaddr` varchar(200) DEFAULT NULL,
  `passflag` varchar(2) DEFAULT NULL COMMENT 'Y: 패스\nN:패스안함',
  `videoaddr` varchar(200) DEFAULT NULL,
  `filename` varchar(255) NOT NULL,
  `grade` int(11) DEFAULT NULL,
  `passgrade` int(11) DEFAULT NULL,
  `updatedate` datetime NOT NULL,
  `creationdate` datetime NOT NULL,
  PRIMARY KEY (`usermissionid`),
  KEY `usermission_n1` (`usermissionid`,`missionid`,`uid`),
  KEY `usermission_n2` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8 COMMENT='유저 미션';

CREATE TABLE `usermission_eval` (
  `evalid` int(11) NOT NULL AUTO_INCREMENT,
  `usermissionid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `instructorid` int(11) DEFAULT NULL,
  `coment` varchar(500) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `creationdate` datetime DEFAULT NULL,
  PRIMARY KEY (`evalid`),
  UNIQUE KEY `evalid_UNIQUE` (`evalid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `userrole` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleid`),
  UNIQUE KEY `roleid_UNIQUE` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;
