package com.scg.persistence;

import com.scg.model.User;
import com.scg.wep.controller.PreludebUser;
import com.scg.wep.controller.WebRole;

import java.util.List;

public interface UserMapper {

	/*********************************************************
	 *  User
	 *********************************************************/

	public PreludebUser webGetUser(String useremail);
	public PreludebUser webGetUserLogin(String useremail);

	public List<WebRole> getRole(String useremail);

	public User getLevel(int uid);

	public int getUserCount(User user);
	public User getUser(User user);
	public int saveUser(User user);
	public void update(User user);

	//자체회원가입할 경우 메일과 타입으로 검증 usermail_UNIQUE(useremail,snstype) 으로 유니크키가 걸려있다
	public int getAcctCount(String accttype, String emailaddr);

	//안드로이드 로그인 자체 아이디 검증
	public int getAcctCheck(String accttype, String emailaddr);

	public List<User> getUserList();

	//개인프로파일 업데이트
	public void updateUser(User user);

	/*********************************************************
	 *  User Firend
	 *********************************************************/

	//조회용
	public List<User> getUserSearchList(User user);

	public User getProfileUser(int uid);

	public User getInsUser(User user);

}