package com.goott.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goott.member.model.Member;
import com.goott.member.model.MemberMapper;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MemberController {

	@Autowired
	private MemberMapper mapper;
	
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	
	@GetMapping("member_list.go")
	public String list(Model model) {
		
		List<Member> list = this.mapper.list();
		
		model.addAttribute("List", list);
		
		return "member_list";
	}
	
	
	@GetMapping("member_insert.go")
	public String insert() {
		
		return "member_insert";
	}
	
	
	@PostMapping("member_insert_ok.go")
	public void insertOk(Member dto,
			HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int result = this.mapper.add(dto);
		
		if(result > 0) {
			out.println("<script>");
			out.println("alert('회원 추가 성공!!!')");
			out.println("location.href='member_list.go'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원 추가 실패~~')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	
}






