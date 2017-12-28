package com.my.smnb20_2.Dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.my.smnb20_2.service.*;
//import com.my.smnb20_2.Domain.BidxSearchCriteria;
import com.my.smnb20_2.Domain.BoardVO;
import com.my.smnb20_2.Domain.Criteria;
import com.my.smnb20_2.Domain.MemberVO;
import com.my.smnb20_2.Domain.SearchCriteria;
import com.my.smnb20_2.Domain.PageMaker;
import com.my.smnb20_2.service.*;



public interface BoardDAO_ano_Father_Mapper {
  
	public ArrayList<BoardVO> getBoardList(); 
	public ArrayList<BoardVO> getBoardList_T(Criteria cri); 
	public ArrayList<BoardVO> getBoardList_TS(SearchCriteria scri); 
	public ArrayList<BoardVO> getBoardList_R_TS(SearchCriteria scri);
	public int countPaging(Criteria cri) throws Exception;
	public int searchCountPaging(SearchCriteria scri) throws Exception;
	public int searchCountPaging_R(SearchCriteria scri) throws Exception;
	public BoardVO getContent(int Bidxx);
	public int InsertDB(HashMap<String,Object> map);
	public int ReplyInsertDB(HashMap<String,Object> map);
	public int MaxIdx();
	public int UpdateDB(HashMap<String,Object> map);
	public int ReplyUpdateDB(HashMap<String,Object> map);
	public int DeleteDB(int bidx);	
}

