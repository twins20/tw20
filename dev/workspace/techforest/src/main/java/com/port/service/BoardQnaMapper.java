package com.port.service;

import java.util.ArrayList;

public interface BoardQnaMapper {
	public int boardQnaWrite(BoardVo vo);
	public ArrayList<BoardVo> boardQnaList(int idx);
	public BoardVo boardQnaCon(int bIdx);
	public int boardQnaMod(BoardVo vo);
	public int boardQnaDel(int bIdx);
	public int boardQnaHit(int bIdx);
	public int boardQnaGood(int bIdx);
	public int boardQnaBad(int bIdx);
	

}
