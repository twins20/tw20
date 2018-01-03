package com.twins.t20.Service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.twins.t20.Domain.JobBoardFdownloadVo;

@Service
public class JobBoardFdownloadDaoSon implements JobBoardFdownloadDaoFather {

	@Override
	public int writeJobBoardFdownload(JobBoardFdownloadVo jbfv) {
		
		return 0;
	}

	@Override
	public int orderUpJobBoardFdownload(HashMap<String, Object> map) {
		
		return 0;
	}

	@Override
	public int orderDownJobBoardFdownload(HashMap<String, Object> map) {
		
		return 0;
	}

	@Override
	public int deleteJobBoardFdownload(HashMap<String, Object> map) {
	
		return 0;
	}

	@Override
	public ArrayList<JobBoardFdownloadVo> getListJobBoardFdownload(int jbidx) {
	
		return null;
	}


}
