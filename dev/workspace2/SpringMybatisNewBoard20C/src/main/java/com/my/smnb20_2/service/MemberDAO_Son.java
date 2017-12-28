package com.my.smnb20_2.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper;
import com.my.smnb20_2.Dao.MemberDAO_Father_Mapper;
import com.my.smnb20_2.Domain.BoardVO;
import com.my.smnb20_2.Domain.MemberVO;

@Service
public class MemberDAO_Son implements MemberDAO_Father{

	
	@Autowired
	SqlSession sqlSession;   	
	
	@Override
	public MemberVO loginCheck(MemberVO mv) throws Exception {
		
		MemberVO resultmv = new MemberVO();
		MemberDAO_Father_Mapper mdfm = sqlSession.getMapper(com.my.smnb20_2.Dao.MemberDAO_Father_Mapper.class);
		
		
		
//		String id = mv.getId();
//		String password = mv.getPassword();
				
//		HashMap<String,Object> map = new HashMap<String,Object>();
		
//		map.put("id",id);
//		map.put("password",password);
		
//		resultmv = mdfm.loginCheck(map);
		
		resultmv = mdfm.loginCheck(mv);
				
		return resultmv;
	}
	
}


