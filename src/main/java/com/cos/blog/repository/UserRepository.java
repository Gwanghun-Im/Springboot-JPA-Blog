package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

// DAO
// 자동으로 bean으로 등록
public interface UserRepository extends JpaRepository<User, Integer>{
	//JPA Naming 쿼리
	// 자동으로 아래의 쿼리를 만들어줌.
	// select * from user where username=username and password=password
	User findByUsernameAndPassword(String Username, String Password);
	
	//@Query(value = "SELECT * FROM user WHERE username=?1 AND password=?2", nativeQuery=true)
	//User login(String username, String Password);
}
