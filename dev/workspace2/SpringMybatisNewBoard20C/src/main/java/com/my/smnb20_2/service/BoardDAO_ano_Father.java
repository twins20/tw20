package com.my.smnb20_2.service;

import java.sql.SQLException;
import java.util.ArrayList;

//import com.my.smnb20_2.Domain.BidxSearchCriteria;
import com.my.smnb20_2.Domain.BoardVO;
import com.my.smnb20_2.Domain.Criteria;
import com.my.smnb20_2.Domain.SearchCriteria;
import com.my.smnb20_2.Domain.PageMaker;
import com.my.smnb20_2.service.*;

// 설계 : 나를 상속 받아서 구현해라느 뜻
public interface BoardDAO_ano_Father {
	
	public ArrayList<BoardVO> getBoardList();
	public ArrayList<BoardVO> getBoardList_T(Criteria cri);
	public ArrayList<BoardVO> getBoardList_TS(SearchCriteria scri);
	public ArrayList<BoardVO> getBoardList_R_TS(SearchCriteria scri, int bidx);
	public int countPaging(Criteria cri) throws Exception;
	public int searchCountPaging(SearchCriteria scri) throws Exception;
	public int searchCountPaging_R(SearchCriteria scri) throws Exception;
	public BoardVO getContent(int Bidxx);
	public int InsertDB(BoardVO bv, int mxx)throws SQLException;
	public int ReplyInsertDB(BoardVO bv, int bidx)throws SQLException;
	public int MaxIdx();
	public int UpdateDB(BoardVO bv, int bidx);
	public int ReplyUpdateDB(int originbidx, int updown);
	public int DeleteDB(int bidx);
	public String OrdinarytoSQL(String ordinaryDate);
	public String CreateyyMMdd();
}
