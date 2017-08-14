package com.port.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardFaqServiceImpl implements BoardFaqMapper{
	
	@Autowired
	private SqlSession sqlSession;
		
	@Override
	public ArrayList<BoardVo> boardFaqList(){

		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		BoardFaqMapper boardFaqMapper = sqlSession.getMapper(BoardFaqMapper.class);
		alist = boardFaqMapper.boardFaqList();
		
		return alist;
		
	}

	@Override
	public BoardVo boardFaqCon(int bIdx){
		
		BoardVo vo = new BoardVo();	
		BoardFaqMapper boardFaqMapper = sqlSession.getMapper(BoardFaqMapper.class);
		vo = boardFaqMapper.boardFaqCon(bIdx);	
							
		return vo;
	}
		
}
