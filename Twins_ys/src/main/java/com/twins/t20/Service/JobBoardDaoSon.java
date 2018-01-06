package com.twins.t20.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.twins.t20.Domain.JobBoardCommentVo;
import com.twins.t20.Domain.JobBoardVo;
import com.twins.t20.Domain.SearchCriteria;

@Service
public class JobBoardDaoSon implements JobBoardDaoFather{

	@Override
	public HashMap<String, Object> getJobBoardList(SearchCriteria scri) {
		
		return null;
	}

	@Override
	public HashMap<String, Object> getJobBoardList_rm(SearchCriteria scri) {
		
		return null;
	}

	@Override
	public HashMap<String, Object> getJobBoardList_nfcrd(SearchCriteria scri) {
		
		return null;
	}

	@Override
	public HashMap<String, Object> getJobBoardList_nfcrd_rm(SearchCriteria scri) {
		
		return null;
	}

	@Override
	public int writeJobBoard(JobBoardVo jbv) {
	
		return 0;
	}

	@Override
	public int updateJobBoard(HashMap<String, Object> map) {
		
		return 0;
	}

	@Override
	public HashMap<String, Object> getJobBoardContent(int jbidx) {
		
		return null;
	}

	@Override
	public int deleteJobBaoard(int jbidx) {
		
		return 0;
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
}
