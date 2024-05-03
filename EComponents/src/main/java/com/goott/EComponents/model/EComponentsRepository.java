package com.goott.EComponents.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EComponentsRepository {
	
	private final SqlSessionTemplate sqlSession;
	
	public List<EComponents> list() {
		return this.sqlSession.selectList("list");
	}
	public int add(EComponents dto) {
		return this.sqlSession.insert("add", dto);
	}
	
}
