package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.blog.config.auth.PrincipalDetailService;

// Bean등록은 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration
@EnableWebSecurity //시큐리티 필터 추가 = 스프링 시큐리티가 활성화가 되어 있는데 어떤 설정(SecurityConfig)을 해당 파일에서 하겠다 .
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면, 권한 및 인증을 미리 테크하겠다. 
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	//시큐리티가 대신 로그인 해줄때 pw를 가로채주는데 
	//해당 pw가 어떤 해쉬로 되어있는지 알아야
	//같은 해쉬로 암호화해서 db에 비교를 해야한다. 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable() //csrf토큰 비활성화(테스트 시 걸어두는것이 좋음)
			.authorizeRequests()
				.antMatchers("/","/auth/**","/js/**","/css/**","/image/**") // 이 주소로 들어오면
				.permitAll() // 모두 허용
				.anyRequest() //위 주소가 아닌 나머지주소는
				.authenticated() //인증이 필요하다.
			.and()
				.formLogin()
				.loginPage("/auth/loginForm")
				.loginProcessingUrl("/auth/loginProc")
				.defaultSuccessUrl("/"); //스프링 시큐리티가 해당 주소로 오는 로그인을 가로채서 대신 로그인 시켜줌
	}	
}
