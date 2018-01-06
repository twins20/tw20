package com.twins.t20.Dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.twins.t20.Domain.JobBoardCommentVo;

public interface JobBoardCommentDaoFatherMapper {
	 
	public int replyUpdateJobBoardComment(HashMap<String, Object> map);
	public int replyInsertJobBoardComment(JobBoardCommentVo jbcv);
	public int deleteJobBoardComment(int jbcidx);
	public ArrayList<JobBoardCommentVo> getJobBoardCommentContent(int jbidx);
}
