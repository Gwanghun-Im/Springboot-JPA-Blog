package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/join/Proc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController");
		userService.Signup(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){ //@RequestBody 로 json객체를 받을 수 있다. 
		userService.update(user);
		// db의 값은 변경 하지만, 섹션값은 변경이 되지 않는다. => 로그아웃을 해야 회원정보가 수정된다. 
		// 직접 섹션값을 변경해야 한다. 
		return new ResponseDto<Integer> (HttpStatus.OK.value(),1);
	}
}
