package com.scg.api.user;

import com.scg.model.User;
import com.scg.persistence.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserMapper userMapper;



	public User getLevel(int uid){
		return userMapper.getLevel(uid);
	};


	//안드로이드 관련 신규 메서드
	public void saveUser(User user){
		userMapper.saveUser(user);
	}

	public User getUser(User user){
		return userMapper.getUser(user);
	}

	public int getUserCount(User user){

		logger.info("getUseremail : "+user.getUseremail());
		logger.info("getPassword : "+user.getPassword());

		return userMapper.getUserCount(user);
	}

	public void update(User user){
		userMapper.update(user);
	}

	//자체 회원 가입 유무를 판단하는 쿼리
	public int getAcctCount(String type, String email){
		return userMapper.getAcctCount(type, email);
	}

	//로그인 검증
	public int getAcctCheck(String type, String email){
		return userMapper.getAcctCheck(type, email);
	}

	public List<User> getUserList(){
		return userMapper.getUserList();
	};

	public void updateUser(User user){
		userMapper.updateUser(user);
	};

	public List<User> getUserSearchList(User user){
		return userMapper.getUserSearchList(user);
	}

	public User getProfileUser(int uid){

		return userMapper.getProfileUser(uid);
	};

	public User getInsUser(User user){
		return userMapper.getInsUser(user);
	};



}