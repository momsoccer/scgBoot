package com.scg;

import com.scg.api.user.common.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import java.nio.charset.Charset;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired private PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder).and();

        //inMemoryAuthentication 와 디비 인증을 동시에 사용할 수 없다.
        //auth.inMemoryAuthentication().withUser("mom@mom.com").password("ss780323").roles("USER");
        //auth.inMemoryAuthentication().withUser("sungbo").password("ss780323").roles("USER");
    }


    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

/*        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);*/

        http
                .authorizeRequests()
                .antMatchers("/mom/index").permitAll()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/member/**").hasAnyAuthority("INS", "USER", "ADMIN")
                //.antMatchers("/api/ins/**").hasAnyAuthority("INS", "ADMIN")
                //.antMatchers("/api/data/**").hasAnyAuthority("INS", "USER", "ADMIN")
                //.antMatchers("/api/team/**").hasAnyAuthority("INS", "USER","ADMIN")
                //.antMatchers("/api/mission/**").hasAnyAuthority("INS","USER","ADMIN")
                //.antMatchers("/api/usermission/**").hasAnyAuthority("INS","USER","ADMIN")
                //.antMatchers("/api/common/**").hasAnyAuthority("INS","USER","ADMIN")
                //.antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/api/**").permitAll()
                .antMatchers("/ins/**").permitAll()
                .antMatchers("/all/**").permitAll()
                .and()
                .authorizeRequests()
                //.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/mom/index")  //home
                .loginPage("/mom/index")
                .loginProcessingUrl("/mom/index")
                .passwordParameter("pwd")
                .usernameParameter("username")
                .failureUrl("/mom/loginerror")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/mom/logout"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/mom/logoutsuccess")
                .and()
                .authorizeRequests()
                .and()
                .csrf().disable()  //파일업로드시 걸린다
                .httpBasic()
//anyRequest().authenticated();
        ;

    }

    /*
    hasIpAddress(ip) : 접근자의 IP주소가 매칭하는지 확인합니다.
hasRole(role) : 역할이 부여된 권한(Granted Authority)와 일치하는지 확인합니다.
hasAnyRole(role) : 부여된 역할 중 일치하는 항목이 있는지 확인합니다.
				 예 - access = "hasAnyRole('ROLE_USER','ROLE_ADMIN')"

위의 표현식 외에도 다음과 같은 조건들을 access에서 사용할 수 있습니다.

permitAll : 모든 접근자를 항상 승인합니다.
denyAll : 모든 사용자의 접근을 거부합니다.
anonymous : 사용자가 익명 사용자인지 확인합니다.
authenticated : 인증된 사용자인지 확인합니다.
rememberMe : 사용자가 remember me를 사용해 인증했는지 확인합니다.
fullyAuthenticated : 사용자가 모든 크리덴셜을 갖춘 상태에서 인증했는지 확인합니다.

     */

}