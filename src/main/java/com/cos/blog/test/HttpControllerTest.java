package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


// 사용자 요청 -> 응답(DATA)
@RestController
public class HttpControllerTest {
	
	private static final String TAG="HttpControllerTest";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = new Member.MemberBuilder().username("ssar").password("1234").email("email").build();
		System.out.println(TAG+"getter:"+m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG+"getter:"+m.getUsername());
		return "lombok test완료";
	}
	
	// http://localhost:8004/http/get
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get: "+m.getId() + ","+ m.getUsername();
	}
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		return "post 요청: " +m.getId() + ","+ m.getUsername() + "," +m.getPassword() + ","+m.getEmail();
	}
	@PutMapping("/http/put")
	public String putTest() {
		return "put";
	}
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete";
	}
}
