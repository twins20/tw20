package com.my.smnb20_2;

import java.util.ArrayList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.my.smnb20_2.Domain.BoardVO;
import com.my.smnb20_2.Domain.SearchCriteria;
import com.my.smnb20_2.service.BoardDAO_ano_Son;

public class TestDynamic {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(TestDynamic.class);
	
	@Autowired
	public BoardDAO_ano_Son bd;
	
	@Test
	public void testDynamic1() throws Exception{
		
		SearchCriteria scri = new SearchCriteria();
		scri.setPage(1);
		scri.setKeyword("¿€º∫");
		scri.setSearchType("writer");
		
		logger.info ("===============================");
		
		ArrayList<BoardVO> alist = bd.getBoardList_TS(scri);
		
		for (BoardVO bv : alist) {
			
			logger.info( bv.getBidx()+" : "+bv.getSubject()+" : "+bv.getWriter() );
		}
		
		logger.info ("===============================");
		
		logger.info( "COUNT : " + bd.searchCountPaging(scri) );	
	}
}
