package com.goott.EComponents.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository 
@RequiredArgsConstructor
public class PCImageRepository { //이 클래스가 DAO역할을 함
	
	private final SqlSessionTemplate sqlSession;
	
	public void addFile(PCImages file) {
		this.sqlSession.insert("imgin", file);
	}

}
