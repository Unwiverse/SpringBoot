package com.example.sample.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


/*
 * - RestController?
 * 'REST(REpresentive State Transfer)'를 위한 전용 컨트롤러임
 * - 분산 시스템을 위한 아키텍쳐를 말한다
 * - 네트워크를 경유해 외부 서버에 접속하거나 필요한 정보를 불러오기 위한 
 *   구조라고 보면 됨 
 * - 이 개념을 바탕으로 설계된 시스템이 'RESTFul'이라는 시스템임
 * - 이런 RESTFul한 웹 서비스를 구축하려고 쓰는게 RestController임
 * - RestController는 웹 어플의 일반적 페이지(HTML 페이지)에 비해 구조가 간단하다
 *   대부분 html을 안쓰고 단순 텍스트로 정보를 전송함
 * - 따라서 HTML 기반의 웹 페이지보다도 사용법이 간단함
 */
@RestController
public class TestController {
	
	@GetMapping("/hello")
	public String hello() {
		
		return "Hello, Spring Boot!";
	}
	
	String[] names = {"hong", "sejong", "yoo", "lee", "shin"};
	String[] emails = {"hong@naver.com", "sejong@email", "yoo@naver.com", "lee@daum.net"
						,"shin@gmail.com"};
	
	@GetMapping("info")
	public HashMap<Integer, DataObject> aaa() {
		
		var map = new HashMap<Integer, DataObject>();
		for(int i=0; i<names.length; i++) {
			
			map.put(i, new DataObject(i, names[i], emails[i]));
		}
		return map;
	}
	
	@GetMapping("info/{no}")
	public DataObject bbb(@PathVariable("no") int num) {
		
		return new DataObject(num, names[num], emails[num]);
		}
	}

