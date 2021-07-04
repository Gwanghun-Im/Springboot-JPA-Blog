package com.cos.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;


// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다. => 자동으로 메모리에 띄어줌
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void post(Board board,User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	@Transactional
	public void update(int id, Board reqBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("실패");
				});
		board.setTitle(reqBoard.getTitle());
		board.setContent(reqBoard.getContent());
		// 해당함수 종료시 트랜잭션이 종료되고 더티체킹을 한다. 그다음 자동 업데이트가 flush
}
	
	@Transactional(readOnly = true)
	public Page<Board> articles(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	@Transactional(readOnly = true)
	public Board detail(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("실패");
				});
	}
	@Transactional
	public void delete(int id) {
		boardRepository.deleteById(id);
	}
}

