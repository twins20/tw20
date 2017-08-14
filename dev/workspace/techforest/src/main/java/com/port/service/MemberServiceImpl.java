package com.port.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Map<String, Object> memberLogIn(MemberVo mv) {
		
		Map<String, Object> data = new HashMap<String, Object>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		data = memberMapper.memberLogIn(mv);
		
		return data;
	}
	
	@Override
	public int memberJoin(MemberVo mv) {
		
		int row = 0; 
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		row = memberMapper.memberJoin(mv);
	
		return row;
	}
	
	@Override
	public MemberVo memberFindMail(MemberVo mv){
		
		MemberVo vo = new MemberVo();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		vo = memberMapper.memberFindMail(mv);
	
		return vo;		
	}
	
	@Override
	public MemberVo memberFindPass(MemberVo mv) {
		
		MemberVo vo = new MemberVo();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		vo = memberMapper.memberFindPass(mv);
	
		return vo;		
	}
	
}
