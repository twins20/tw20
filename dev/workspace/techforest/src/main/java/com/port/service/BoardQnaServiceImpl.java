package com.port.service;

import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardQnaServiceImpl implements BoardQnaMapper {
	
	@Autowired
	private SqlSession sqlSession;

	
	@Override  
	public ArrayList<BoardVo> boardQnaList(int idx){
		  
		int sess_idx = 0;
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();	  
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		alist = boardQnaMapper.boardQnaList(sess_idx);
		  
		return alist;
		  
	}	
	
	@Override 
	public BoardVo boardQnaCon(int bIdx){
		
		BoardVo vo = new BoardVo();
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		vo = boardQnaMapper.boardQnaCon(bIdx);
					  	
		 return vo;
		  
	 }

	
	@Override
	public int boardQnaWrite(BoardVo vo){
		
		int row = 0;
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		row = boardQnaMapper.boardQnaWrite(vo);
			 		 
		return row;
		  
	  }

	@Override
	public int boardQnaMod(BoardVo vo){
		
		int row = 0;
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);	  
		row = boardQnaMapper.boardQnaMod(vo);	  
		  
		  return row;
		  
	  }

	@Override 
	public int boardQnaDel(int bIdx){
		  
		int row = 0; 
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);	
		row = boardQnaMapper.boardQnaDel(bIdx);	  
			
		  return row;
	  
	  }

	@Override
	public int boardQnaHit(int bIdx){
		
		int row = 0;
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		row = boardQnaMapper.boardQnaHit(bIdx);
			
		return row;	 
	
	}
		
	@Override
	public int boardQnaGood(int bIdx){
		
		int row = 0;
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		row = boardQnaMapper.boardQnaGood(bIdx);

		return row;	 
		
	}
	
	@Override
	public int boardQnaBad(int bIdx){

		int row = 0;
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		row = boardQnaMapper.boardQnaBad(bIdx);
		
		return row;	 
	
	}
		
}
