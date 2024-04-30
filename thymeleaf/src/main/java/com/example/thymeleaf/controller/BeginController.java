package com.example.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping("form")
	public String abc() {
		return "index_01";
	}
	
	@GetMapping("data")
	public ModelAndView bcd(ModelAndView mav, @RequestParam("txt1") String msg) {
		mav.addObject("message", msg);
		mav.setViewName("index_01");
		
		return mav;
	}
	@GetMapping("date")
	public String ccc() {
		return "index_02";
	}
	@GetMapping("object")
	public String ddd(Model model) {
		DataObject obj = new DataObject(100, "sejong", "sejong@gmail.com");
		
		model.addAttribute("Object", obj);
		
		return "index_03";
	}
	@GetMapping("data/{num}")
	public String eee(@PathVariable("num") int no, Model model) {
		model.addAttribute("No", no).addAttribute("check", no>=0)
		.addAttribute("trueVal", "양수입니다").addAttribute("falseVal", "음수입니다");
		
		return "index_04";
	}
	@GetMapping("info")
	public String ggg(Model mod) {
		PCObject[] pbj = {
		new PCObject(1, "intel i5-3570", "ASRock Z68 Pro-3 M", "DDR3-1600 16GB", "GTX 1050"),
		new PCObject(2, "intel i5-11400F", "Gigabyte H510M", "DDR4-3200 16GB", null),
		new PCObject(3, "intel i5-4690", "ASRock H81M DGS R2.0", "DDR3 12GB", "GTX 960")
		};
		mod.addAttribute("Info", pbj);
		
		return "index_05";
	}
	@GetMapping("score/{jumsu}")
	public String eee(@PathVariable("jumsu") double avg, Model model) {
		model.addAttribute("score", avg).
		addAttribute("hakjum", Math.floor(avg/10));
		
		return "index_06";
	}
	@GetMapping("each")
	public String ggg() {
		
		return "index_07";
	}
	@GetMapping("array") 
	public String bcd(Model model) {
		List<String[]> data = new ArrayList<>();
		
		data.add(new String[] {"몬스타", "hp", "한성컴퓨터", "TG삼보"});
		data.add(new String[] {"몬스타", "hp", "한성컴퓨터", "TG삼보"});
		data.add(new String[] {"몬스타", "hp", "한성컴퓨터", "TG삼보"});
		data.add(new String[] {"몬스타", "hp", "한성컴퓨터", "TG삼보"});
		data.add(new String[] {"몬스타", "hp", "한성컴퓨터", "TG삼보"});
		model.addAttribute("data", data);
		
		return "index_08";
	}
	@GetMapping("array1")
	public String def(Model model) {
		List<DataObject> data = new ArrayList<>();
		
		data.add(new DataObject(1, "hong", "hong@naver.com"));
		data.add(new DataObject(2, "hong", "lee@daum.net"));
		data.add(new DataObject(3, "hong", "hong@naver.com"));
		data.add(new DataObject(4, "hong", "hong@naver.com"));
		data.add(new DataObject(5, "hong", "hong@naver.com"));
		
		model.addAttribute("Data", data);
		
		return "index_09";
	}
	
	@GetMapping("tax/{num}")
	public String hhh(@PathVariable("num") int tax, Model model) {
		
		model.addAttribute("tax", tax);
		
		return "index_10";
	}
	
	@GetMapping("href")
	public String kkk() {
		return "index_11";
	}
	
	@GetMapping("param")
	public String mmm(Model model) {
		model.addAttribute("name", "김삼순")
		.addAttribute("weight", "140kg");
		
		return "index_12";
	}
	
	@GetMapping("include")
	public String nnn() {
		return "index_13";
	}
}
	
	

