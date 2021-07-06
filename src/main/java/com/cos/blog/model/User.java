package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User클래스가 자동으로 MySQL에 테이블이 생성
// @DynamicInsert insert시에 null인 테이블을 제외시킨다.
public class User {
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB(MySQL)의 넘버링 전략을 이어간다. 
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 100,unique = true)
	private String username;
	
	@Column(nullable = false, length = 100) //password를 해쉬로 변경하기 위해 넉넉하게
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
   //	@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 써야한다.  admin, user, manager
	
	private String oauth;
	
	@CreationTimestamp //시간이 자동으로 변경됨
	private Timestamp createDate;

}
