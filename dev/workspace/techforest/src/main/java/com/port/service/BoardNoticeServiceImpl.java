package com.port.service;


import java.util.ArrayList;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardNoticeServiceImpl implements BoardNoticeMapper{
	
	@Autowired
	private SqlSession sqlSession;
			
	@Override 
	public ArrayList<BoardVo> boardNoticeList(){
			
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		BoardNoticeMapper boardNoticeMapper = sqlSession.getMapper(BoardNoticeMapper.class);
		alist = boardNoticeMapper.boardNoticeList();
		
		return alist;
	}	

	@Override 
	public BoardVo boardNoticeCon(int bIdx){
		
		BoardVo vo = new BoardVo();	
		BoardNoticeMapper boardNoticeMapper = sqlSession.getMapper(BoardNoticeMapper.class);
		vo = boardNoticeMapper.boardNoticeCon(bIdx);	
		
		return vo;
	}
	
}
