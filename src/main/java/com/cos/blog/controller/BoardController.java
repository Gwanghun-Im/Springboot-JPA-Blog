package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) { //컨트롤러에서 세션을 찾는 방법
		model.addAttribute("boards",boardService.articles(pageable));
		return "index";
	}
	@GetMapping("/board/saveForm")
	public String saveForm() { //컨트롤러에서 세션을 찾는 방법
		return "board/saveForm";
	}
}
