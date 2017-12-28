package com.my.smnb20_2.service;

import java.lang.annotation.Target;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper;
//import com.my.smnb20_2.Domain.BidxSearchCriteria;
import com.my.smnb20_2.Domain.BoardVO;
import com.my.smnb20_2.Domain.Criteria;
import com.my.smnb20_2.Domain.SearchCriteria;
import com.my.smnb20_2.Domain.PageMaker;
import com.my.smnb20_2.service.*;

@Service("boardDAO_ano_Son")
public class BoardDAO_ano_Son implements BoardDAO_ano_Father{

	//{@org.springframework.beans.factory.annotation.Autowired(required=true)}
	
	@Autowired
	SqlSession sqlSession;   
	
	@Override
	public ArrayList<BoardVO> getBoardList() {
		
		ArrayList<BoardVO> alist = new ArrayList<BoardVO>();
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		alist = bafm.getBoardList();
		return alist;
	}
	
	@Override
	public ArrayList<BoardVO> getBoardList_T(Criteria cri) {
		
		if (cri.getPage() <= 0) {
			cri.setPage(1);
		}
		
		ArrayList<BoardVO> alist_T = new ArrayList<BoardVO>();
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		alist_T = bafm.getBoardList_T(cri);
		return alist_T;
	}
	
	
	@Override
	public ArrayList<BoardVO> getBoardList_TS(SearchCriteria scri) {
		
		if (scri.getPage() <= 0) {
			scri.setPage(1);
		}
		
		ArrayList<BoardVO> alist_TS = new ArrayList<BoardVO>();
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		alist_TS = bafm.getBoardList_TS(scri);
		return alist_TS;
	}
	
	
	@Override
	public ArrayList<BoardVO> getBoardList_R_TS(SearchCriteria scri, int bidx) {
		
		if (scri.getPage() <= 0) {
			scri.setPage(1);
		}
		scri.setBidx(bidx);
		
		ArrayList<BoardVO> alist_R_TS = new ArrayList<BoardVO>();
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		alist_R_TS = bafm.getBoardList_R_TS(scri);
		return alist_R_TS;
	}
	

	public int countPaging(Criteria cri) throws Exception {
		
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		int cnt = bafm.countPaging(cri);
		
		return cnt;
	}
	
	
	
	public int searchCountPaging(SearchCriteria scri) throws Exception {
		
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		int cnt = bafm.searchCountPaging(scri);
		
		return cnt;
	}
	
	
	public int searchCountPaging_R(SearchCriteria scri) throws Exception {
		
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		int cnt = bafm.searchCountPaging_R(scri);
		
		return cnt;
	}
	
	
	@Override
	public BoardVO getContent(int Bidxx) {

		System.out.println("sqlSession값 확인 : "+ sqlSession);
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		//sqlSession.getMapper(BoardDAO_ano_Father_Mapper.class);
		BoardVO bv = bafm.getContent(Bidxx);
		bv.setWritedate( OrdinarytoSQL( bv.getWritedate() ) );
		bv.setModifydate( OrdinarytoSQL( bv.getModifydate() ) );
		
		System.out.println("bv값 확인 : "+ bv);
		return bv;
	}

	@Override
	public int InsertDB(BoardVO bv, int bidx) throws SQLException {
		
		String subject = bv.getSubject();
		String content = bv.getContent();
		String writer = bv.getWriter();
		String writedate = bv.getWritedate();
		String modifydate = bv.getModifydate();
		int idx = bv.getIdx();
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("subject",subject);
		map.put("content",content);
		map.put("writer",writer);
		map.put("writedate",writedate);
		map.put("modifydate",modifydate);
		map.put("idx",idx);
		map.put("bidx",bidx);
		
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		int RRD = bafm.InsertDB(map);	
		return RRD;
	}
	
	@Override
    public int ReplyInsertDB(BoardVO bv, int bidx) throws SQLException {
   	
		int originbidx = bv.getOriginbidx();
		int updown = bv.getUpdown();
		int leftright = bv.getLeftright();
		String subject = bv.getSubject();
		String content = bv.getContent();
		String writer = bv.getWriter();
		String writedate = bv.getWritedate();
		String modifydate = bv.getModifydate();
		int idx = bv.getIdx();
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("bidx",bidx);
		map.put("originbidx",originbidx);
		map.put("updown",updown);
		map.put("leftright",leftright);
		map.put("subject",subject);
		map.put("content",content);
		map.put("writer",writer);
		map.put("writedate",writedate);
		map.put("modifydate",modifydate);
		map.put("idx",idx);
		
		
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		int RRD = bafm.ReplyInsertDB(map);	
		return RRD;
    }

	
	@Override
	public int MaxIdx() {
		
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		int midx = bafm.MaxIdx();
		
		return midx;
	}

	@Override
	public int UpdateDB(BoardVO bv, int bidx) {
		
		String subject = bv.getSubject();
		String content = bv.getContent();
		String writer = bv.getWriter();
		String modifydate = bv.getModifydate();
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("subject",subject);
		map.put("content",content);
		map.put("writer",writer);
		map.put("modifydate",modifydate);
		map.put("bidx",bidx);
		
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		int RRD = bafm.UpdateDB(map);
		
		return RRD; 
	}

	@Override
	public int ReplyUpdateDB(int originbidx, int updown) {
					
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("originbidx",originbidx);
		map.put("updown",updown);
		
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		int RRD = bafm.ReplyUpdateDB(map);
		
		return RRD; 
	}

	@Override
	public int DeleteDB(int bidx) {
		BoardDAO_ano_Father_Mapper bafm = sqlSession.getMapper(com.my.smnb20_2.Dao.BoardDAO_ano_Father_Mapper.class);
		int RRD = bafm.DeleteDB(bidx);
		return RRD;
	}

	@Override
	public String OrdinarytoSQL(String ordinaryDate) {
		
		String dt = "";
    	dt = ordinaryDate;
    	java.sql.Date sqlDate = null;
    	String  convertedDate = "";
    					
        // 날짜를 SQL 데이터 포맷으로 바꾸어 주는 부분  예) 2017-10-19
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // java.util.Date date = sdf.parse(bv.getWritedate());
        
        java.util.Date date = null;
		
        try {
			date = sdf.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
                  
        sqlDate = new Date(date.getTime());
        
        // System.out.println(sqlDate);
        
        convertedDate = sqlDate.toString();
        
        return convertedDate;
	}

	@Override
	public String CreateyyMMdd() {
		
		/* //참고만 할 것
		// 현재시간 값을 시스템으로부터 얻어옴
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = dayTime.format(new Date(time));

		// SQL 날짜 형식으로 날짜 형식 변환
		java.util.Date date = dayTime.parse(str); 
		java.sql.Date sqlDate = new Date(date.getTime());   
		*/
		  
		java.util.Date dt = new java.util.Date();
		//System.out.println(dt.toString());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		//System.out.println(sdf.format(dt).toString());

		String indate = "";

		indate = sdf.format(dt).toString();
		indate = indate.substring(2);
		//System.out.println(indate);
		
		return indate;
	}

	
}
