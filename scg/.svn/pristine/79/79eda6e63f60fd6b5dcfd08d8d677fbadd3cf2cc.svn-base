package com.scg.wep.controller;

import com.scg.persistence.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import java.util.List;

/**
 * Created by sungbo on 2016-11-23.
 */
public class PreludebUserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(PreludebUserService.class);

    private String snstype;

    private UserMapper userMapper;
    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public String getSnstype() {
        return snstype;
    }

    public void setSnstype(String snstype) {
        this.snstype = snstype;
    }

    @Override
    public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {

        try {

            logger.info("UserDetails 시작 합니다");
            PreludebUser preludebUser = null;
            
            if(snstype.equals("kakao") || snstype.equals("facebook")) {
                preludebUser = userMapper.webGetUser(useremail);
            }else if (snstype.equals("web")){

                StandardPasswordEncoder encoder = new StandardPasswordEncoder();
                preludebUser = userMapper.webGetUserLogin(useremail);

            }
            
            PreludebUser entazUser = new PreludebUser();

            //해당유저의 아이디와 비번을 셋팅
            entazUser.setUsername(preludebUser.getUsername());
            entazUser.setPassword(preludebUser.getPassword());

            logger.info("스프링 권한 값을 가져옵니다.");

            //해당유저의 권한
            List<WebRole> roles = userMapper.getRole(useremail);

            for(int i=0; i < roles.size();i++){
                logger.info("권한은 : " + roles.get(i).getName());
            }

            entazUser.setAuthorities(roles);
            return entazUser;

        }catch (Exception e){
            logger.info("예외 상황 발생" + e);
            e.printStackTrace();
            PreludebUser entazUser = new PreludebUser();
            return entazUser;
        }

    }
}
