package com.twins.t20.Service;

import java.util.ArrayList;
import java.util.HashMap;

import com.twins.t20.Domain.JobBoardCommentVo;

public interface JobBoardCommentDaoFather {
	
	public int writeJobBoardComment(JobBoardCommentVo jbcv);
	public int deleteJobBoardComment(int jbcidx);
}
