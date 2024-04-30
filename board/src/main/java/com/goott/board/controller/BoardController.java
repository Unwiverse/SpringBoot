package com.goott.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goott.board.model.Board;
import com.goott.board.model.BoardRepository;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //초기화 안된 final 필드나 @NotNull이 붙은 필드에 생성자를 만들어줌
//클래스에 선언된 final 변수들, 필드들을 매개변수로 하는 생성자를 자동 생성하는 Annotation임
public class BoardController {
	
	private final BoardRepository repository;
	
	@GetMapping("board_list")
	public String list(Model model) {
		//전체 게시물 목록을 조회하는 메서드 호출
		List<Board> list =  this.repository.list();
		model.addAttribute("List", list);
		return "board_list";
	}
	
	@GetMapping("board_write")
	public String write() {
		return "board_write";
	}
	
	@PostMapping("board_write_ok")
	public void writeOk(Board dto, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		int result = this.repository.add(dto);
		
		if(result > 0) {
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='board_list'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
	@GetMapping("board_content")
	public String content(Model model, @RequestParam("no") int no) {
		Board dto = this.repository.content(no);
		
		model.addAttribute("Info", dto);
		
		return "board_content";
		
	}
		
}