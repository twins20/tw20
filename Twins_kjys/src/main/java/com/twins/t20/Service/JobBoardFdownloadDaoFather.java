package com.twins.t20.Service;

import java.util.ArrayList;
import java.util.HashMap;

import com.twins.t20.Domain.JobBoardFdownloadVo;

public interface JobBoardFdownloadDaoFather {
	
	public int writeJobBoardFdownload(JobBoardFdownloadVo jbfv);
	public int orderUpJobBoardFdownload(HashMap<String, Object> map);
	public int orderDownJobBoardFdownload(HashMap<String, Object> map);
	public int deleteJobBoardFdownload(HashMap<String, Object> map);
	public ArrayList<JobBoardFdownloadVo> getListJobBoardFdownload(int jbidx);	
}
