package com.goott.EComponents.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EComponentsRepository { //이 클래스가 DAO역할을 함
	
	private final SqlSessionTemplate sqlSession;
	
	public List<EComponents> list() {
		return this.sqlSession.selectList("list");
	}
	public int add(EComponents dto) {
		return this.sqlSession.insert("add", dto);
	}
	public EComponents content(int no) {
		return this.sqlSession.selectOne("cont", no);
	}
	public int update(EComponents dto) {
		return this.sqlSession.update("upt", dto);
	}
	public int delete(int no) {
		return this.sqlSession.delete("del", no);
	}
	public void updateSeq(int no) {
		this.sqlSession.update("seq", no);
	}
	
	
}
