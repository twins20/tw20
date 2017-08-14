package com.port.service;

import java.util.ArrayList;

public interface BoardNoticeMapper {
	public ArrayList<BoardVo> boardNoticeList();
	public BoardVo boardNoticeCon(int bIdx);
}
