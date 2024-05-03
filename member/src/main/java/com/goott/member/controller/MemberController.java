package com.goott.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("member.content.go")
	public String cont(@RequestParam("num") int no, Model model) {
		Member content = this.mapper.cont(no);
		model.addAttribute("d", content);
		
		return "member_content";
	}
	@GetMapping("member_update.go")
	public String update(Model model, @RequestParam("num") int no) {
		Member dto = this.mapper.cont(no);
		
		model.addAttribute("Upt", dto);
		
		return "member_update";
	}
	@GetMapping("member_update_ok.go")
	public void updateOk(Member dto, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		int check = this.mapper.modify(dto);
		
		if(check>0) {
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='member_list.go'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	@GetMapping("member_delete.go")
	public void delete(@RequestParam("num") int no, HttpServletResponse res) throws IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		int check = this.mapper.del(no);
		
		PrintWriter out = res.getWriter();
		
		if(check >0) {
			this.mapper.seq(no);
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='member_list.go'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	@PostMapping("member_search.go")
	public String search(@RequestParam("field") String field, 
			@RequestParam("keyword") String keyword, Model model) {
		Map<String, String> map = new HashMap<>();
		
		map.put("field", field);
		map.put("keyword", keyword);
		
		List<Member> searchList = this.mapper.search(map);
		
		model.addAttribute("search", searchList).addAttribute("map", map);
		
		return "member_search_list";
		
	}
	@GetMapping("member_search_cont.go")
	public String searchCont(@RequestParam("num") int no,
			@RequestParam("field") String field,
			@RequestParam("keyword") String keyword, Model model) {
		
		Member searchCont =	this.mapper.cont(no);
		
		model.addAttribute("SearchCont", searchCont)
			 .addAttribute("Field", field)
			 .addAttribute("Keyword", keyword);
		
		return "member_search_cont";
	}
	
	
	
}






