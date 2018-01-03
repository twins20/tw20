package com.twins.t20.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twins.t20.Dao.JobBoardDaoFatherMapper;
import com.twins.t20.Domain.JobBoardCommentVo;
import com.twins.t20.Domain.JobBoardVo;
import com.twins.t20.Domain.SearchCriteria;

@Service("jobBoardDaoSon")
public class JobBoardDaoSon implements JobBoardDaoFather{
	
	@Autowired
	SqlSession sqlSession;   
	
	@Transactional
	@Override
	public HashMap<String, Object> getJobBoardList(SearchCriteria scri) {
		
		ArrayList<JobBoardVo> alist = new ArrayList<JobBoardVo>();
		JobBoardDaoFatherMapper jbdfm = sqlSession.getMapper(com.twins.t20.Dao.JobBoardDaoFatherMapper.class);
		
		alist = jbdfm.getJobBoardList(scri);
		int cnt = jbdfm.getJobBoardTotalRecordCount(scri);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", alist);
		map.put("cnt", cnt);
		
		return map;
	}

	@Transactional
	@Override
	public HashMap<String, Object> getJobBoardList_rm(SearchCriteria scri) {
		
		ArrayList<JobBoardVo> alist = new ArrayList<JobBoardVo>();
		JobBoardDaoFatherMapper jbdfm = sqlSession.getMapper(com.twins.t20.Dao.JobBoardDaoFatherMapper.class);
		
		alist = jbdfm.getJobBoardList_rm(scri);
		int cnt = jbdfm.getJobBoardTotalRecordCount_rm(scri);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", alist);
		map.put("cnt", cnt);
		
		return map;
	}

	@Transactional
	@Override
	public HashMap<String, Object> getJobBoardList_nfcrd(SearchCriteria scri) {
		
		ArrayList<JobBoardVo> alist = new ArrayList<JobBoardVo>();
		JobBoardDaoFatherMapper jbdfm = sqlSession.getMapper(com.twins.t20.Dao.JobBoardDaoFatherMapper.class);
		
		alist = jbdfm.getJobBoardList_nfcrd(scri);
		int cnt = jbdfm.getJobBoard_nfcrd_TotalRecordCount(scri);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", alist);
		map.put("cnt", cnt);
		
		return map;
	}

	@Transactional
	@Override
	public HashMap<String, Object> getJobBoardList_nfcrd_rm(SearchCriteria scri) {
		
		ArrayList<JobBoardVo> alist = new ArrayList<JobBoardVo>();
		JobBoardDaoFatherMapper jbdfm = sqlSession.getMapper(com.twins.t20.Dao.JobBoardDaoFatherMapper.class);
		
		alist = jbdfm.getJobBoardList_nfcrd_rm(scri);
		int cnt = jbdfm.getJobBoard_nfcrd_TotalRecordCount_rm(scri);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", alist);
		map.put("cnt", cnt);
		
		return map;
	}

	@Transactional
	@Override
	public int writeJobBoard(JobBoardVo jbv) {
	
		JobBoardDaoFatherMapper jbdfm = sqlSession.getMapper(com.twins.t20.Dao.JobBoardDaoFatherMapper.class);
		int maxjbidx = jbdfm.getJobBoardMaxIdx();
		jbv.setJbidx(maxjbidx+1);

		if (maxjbidx == 0) return 0;
		
		int RD = jbdfm.insertJobBoard(jbv);	
		return RD;
	}

	@Override
	public int updateJobBoard(HashMap<String, Object> map) {
		
		return 0;
	}

	@Transactional
	@Override
	public HashMap<String, Object> getJobBoardContent(int jbidx) {
		
		JobBoardDaoFatherMapper jbdfm = sqlSession.getMapper(com.twins.t20.Dao.JobBoardDaoFatherMapper.class);		
		JobBoardVo jbv = jbdfm.getJobBoardContent(jbidx);
		int replyCount = jbdfm.updateJobBoardReadrnum(jbidx);
		
		jbv.setJbwritedate( OrdinarytoSQL( jbv.getJbwritedate() ) );
		jbv.setJbmodifydate( OrdinarytoSQL( jbv.getJbmodifydate() ) );
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("jbv",  jbv);
		map.put("replyCount", replyCount);
		
		return map;
	}

	@Transactional
	@Override
	public int deleteJobBaoard(SearchCriteria scri) {
		JobBoardDaoFatherMapper jbdfm = sqlSession.getMapper(com.twins.t20.Dao.JobBoardDaoFatherMapper.class);
		int RD = jbdfm.deleteJobBaoard(scri.getJbidx());
		if (RD == 0) return 0;
		
		int cnt;
		if(scri.getJbcategory() == null) {
			cnt= jbdfm.getJobBoardTotalRecordCount(scri);
		}else {
			cnt= jbdfm.getJobBoard_nfcrd_TotalRecordCount(scri);
		}
		return cnt;
	}

	@Override
	public int replyWriteJobBoard(JobBoardVo jbv) {
		
		return 0;
	}

	@Override
	public JobBoardVo getMyJobBoardList(int jmidx) {
		
		return null;
	}

	@Override
	public ArrayList<JobBoardCommentVo> getMyJobBoardCommentContent(int jmidx) {
		
		return null;
	}	
	
	@Override
	public int getJobBoardTotalRecordCount(SearchCriteria scri) {
		JobBoardDaoFatherMapper jbdfm = sqlSession.getMapper(com.twins.t20.Dao.JobBoardDaoFatherMapper.class);
		
		int cnt;
		if(scri.getJbcategory() == null) {
			cnt= jbdfm.getJobBoardTotalRecordCount(scri);
		}else {
			cnt= jbdfm.getJobBoard_nfcrd_TotalRecordCount(scri);
		}
		return cnt;
	}
	
	public String OrdinarytoSQL(String ordinaryDate) {
		
		String dt = "";
    	dt = ordinaryDate;
    	java.sql.Date sqlDate = null;
    	String  convertedDate = "";
    					
        // 날짜를 SQL 데이터 포맷으로 바꾸어 주는 부분  예) 2017-10-19
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
		
        try {
			date = sdf.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
                  
        sqlDate = new Date(date.getTime());       
        convertedDate = sqlDate.toString();
        
        return convertedDate;
	}

	public String CreateyyMMdd() {
			  
		java.util.Date dt = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String indate = "";
		indate = sdf.format(dt).toString();
		indate = indate.substring(2);
		
		return indate;
	}
}
