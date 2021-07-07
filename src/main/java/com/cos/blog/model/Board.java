package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User클래스가 자동으로 MySQL에 테이블이 생성
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@ Lob //대용량 데이터 일때 사용
	private String content; //섬머노트 라이브러리<html>태그가 섞여서 디자인 됨
	
	
	private int count; //조회수
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //mappedBy 연관관계의 주인이 아니다, DB에 컬럼을 만들지 마라.
	@JsonIgnoreProperties({"board"})
//	@OrderBy("id desc")
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
