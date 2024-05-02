package com.goott.member.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public List<Member> list();
	
	public int add(Member dto);
	
	public Member cont(int num);
	
	public int modify(Member dto);
	
	public int del(int num);
	
	public void seq(int num);
	
	public List<Member> search(Map<String, String> map);
	
	
}
