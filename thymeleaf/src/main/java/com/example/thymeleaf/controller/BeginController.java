package com.example.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BeginController {
		
	@GetMapping("/")
	public String aaa() {
		
		return "index";
	}
	
	@RequestMapping("/{num}")
	public String abc(@PathVariable("num") int no, Model model) {
		int result = 0;
		
		for(int i=1; i<=no; i++) {
			result = result + i;		
		}
		model.addAttribute("sum", "total: "+result);
		
		return "index"; 
	}
	
}
