package com.goott.EComponents.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goott.EComponents.model.EComponents;
import com.goott.EComponents.model.EComponentsRepository;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EComponentsController {
	
	public final EComponentsRepository repository;
	
	@GetMapping("pc_list")
	public String list(Model model) {
		List<EComponents> list = this.repository.list();
		model.addAttribute("List", list);
		return "pc_list";
	}
	
	@GetMapping("pc_add")
	public String add() {
		return "pc_add";
	}
	
	@GetMapping("pc_add_ok")
	public void addOk(HttpServletResponse res, EComponents dto) throws IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		int check = this.repository.add(dto);
		
		PrintWriter out = res.getWriter();
		
		if(check > 0) {
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='pc_list'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨')");
			out.println("history.back()");
			out.println("</script>");
		}
	}	
	@GetMapping("pc_content")
	public String content(@RequestParam("no") int no, Model model) {
		EComponents dto = this.repository.content(no);
		model.addAttribute("O", dto);
		
		return "pc_content";
	}
	@GetMapping("pc_update")
	public String update(@RequestParam("no") int no, Model model) {
		EComponents dto = this.repository.content(no);
		model.addAttribute("upt", dto);
		
		return "pc_update";
	}
	@GetMapping("pc_update_ok")
	public void updateOk(EComponents dto, HttpServletResponse res) throws IOException {
		int po = this.repository.update(dto);
		
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		if(po > 0) {
			out.println("<script>");
			out.println("alert('7')");
			out.println("location.href='pc_list'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('6')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	@GetMapping("pc_delete")
	public void delete(@RequestParam("no") int no, HttpServletResponse res) throws IOException {
		int check = this.repository.delete(no);
		
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		if(check>0) {
			this.repository.updateSeq(no);
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='pc_list'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
