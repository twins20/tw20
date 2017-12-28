package com.my.smnb20_2.service;

import java.sql.SQLException;

import com.my.smnb20_2.Domain.MemberVO;

public interface MemberDAO_Father {

	public MemberVO loginCheck(MemberVO mv) throws SQLException, Exception;
	
}

