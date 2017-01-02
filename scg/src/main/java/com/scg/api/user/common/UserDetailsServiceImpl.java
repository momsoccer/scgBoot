package com.scg.api.user.common;

import com.scg.model.User;
import com.scg.model.UserRole;
import com.scg.persistence.UserMapper;
import com.scg.persistence.UserRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {

		User user = userMapper.getUser(new User(useremail));

		if (user == null) {
			throw new UsernameNotFoundException("Could not find the userId '" + useremail + "'");
		}else{
			logger.info("접속 : " + useremail);
		}

		UserRole role = new UserRole();
		role.setUid(user.getUid());

		List<UserRole> userRoleList = userRoleMapper.getUserRoleList(role);

		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();

		for (UserRole userRole : userRoleList) {
			authority.add(new SimpleGrantedAuthority(userRole.getRolename()));
		}

		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUseremail(), user.getPassword(), authority);

		return userDetails;
	}
}