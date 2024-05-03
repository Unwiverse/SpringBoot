package com.goott.board.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
	
	private final SqlSessionTemplate sqlSession;
	
	public List<Board> list() {
		return this.sqlSession.selectList("Board.list");
	}
	public int add(Board dto) {
		return this.sqlSession.insert("Board.insert", dto);
	}
	public Board content(int no) {
		return this.sqlSession.selectOne("Board.one", no);
	}
	public void readCount(int no) {
		this.sqlSession.update("hit", no);
	}
	public int delete(int no) {
		return this.sqlSession.delete("del", no);
	}
	public void updateSeq(int no) {
		this.sqlSession.update("seq", no);
	}
	public int update(Board dto) {
		return this.sqlSession.update("update", dto);
	}
}
