package com.port.service;

import java.util.ArrayList;

public interface BoardFaqService {
	public ArrayList<BoardVo> boardFaqList();
	public BoardVo boardFaqCon(int bIdx);
}
