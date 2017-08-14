package com.port.service;

import java.util.Map;

public interface MemberMapper {
	
	//멤버 로그인
	public Map<String, Object> memberLogIn(MemberVo mv);
	
	//멤버 회원가입
	public int memberJoin(MemberVo mv);

	//멤버 아이디 찾기
	public MemberVo memberFindMail(MemberVo mv);
	
	//멤버 비밀번호 찾기
	public MemberVo memberFindPass(MemberVo mv);
	
}
