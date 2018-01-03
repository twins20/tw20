package com.twins.t20.Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.twins.t20.Domain.JobMemberVo;

@Service
public class JobMemberDaoSon implements JobMemberDaoFather{

	@Override
	public int insertJobMember(JobMemberVo jmv) {
	
		return 0;
	}

	@Override
	public int confirmJobMemberID(String jmid) {
		
		return 0;
	}

	@Override
	public JobMemberVo loginJobMember(HashMap<String, Object> map) {
		
		return null;
	}

	@Override
	public String getIDJobMember(HashMap<String, Object> map) {
		
		return null;
	}

	@Override
	public String getPswordJobMember(HashMap<String, Object> map) {
		
		return null;
	}

	@Override
	public int deleteJobMember(HashMap<String, Object> map) {
		
		return 0;
	}

	@Override
	public int changePsword(HashMap<String, Object> map) {
		
		return 0;
	}

	@Override
	public int modifyJobMember(HashMap<String, Object> map) {
		
		return 0;
	}

}
