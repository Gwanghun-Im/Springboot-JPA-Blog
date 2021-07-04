package com.cos.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service //Bean등록
public class PrincipalDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	//스프링이 로그인 요청을 가로챌때 유저네임, 패스워드를 가로채는데 
	// pw부분처리는 알아서함.
	// 해당유저네임이 db에 있는지 확인한 후 return.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. "+username);
				});
		return new PrincipalDetail(principal); //시큐리티 세션에 유저 정보가 저장됨.
	}
}
