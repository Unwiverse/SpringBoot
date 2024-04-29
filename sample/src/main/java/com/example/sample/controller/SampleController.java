package com.example.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * 우선 패키지를 만들 때 주의할 내용 있음
 * - 부트에선 @Controller에서 지정한 url을
 *   찾지 못하는 경우가 있음. 이유야 있겠다만 가장 설득력 있는 건 
 *   @Controller이 붙은 컨트롤러 클래스는 메인 클래스(xxxAplication.class)가
 *   있는 패키지의 하위에 있어야됨
 * - 부트는 시작점인 메인 클래스가 위치한 하위 패키지에 있는 클래스들을 검색해
 *   Bean으로 등록을 하기 때문에 하위 패키지에 속하지 않는다면 스프링 부트 컨테이너
 *   를 해당 클래스를 bean으로 등록하지 않게됨
 * 
 */
@Controller
public class SampleController {
	@GetMapping("/main")
	public String main() {
		return "main";	
	}
	@GetMapping("/{num}")
	public String aaa(@PathVariable("num")int no, Model model) {
		model.addAttribute("No", no);
		
		return "index";
		
	}
	
}
