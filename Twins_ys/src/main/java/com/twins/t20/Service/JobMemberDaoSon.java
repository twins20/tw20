package com.twins.t20.Service;

import java.util.HashMap;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.twins.t20.Dao.JobMemberDaoFatherMapper;
import com.twins.t20.Domain.JobMemberVo;

@Service
public class JobMemberDaoSon implements JobMemberDaoFather{

	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	@Autowired
	JobMemberVo jmv;
	
	@Override
	public int insertJobMember(JobMemberVo jmv) {
		
	JobMemberDaoFatherMapper jmdfm = sqlSession.getMapper(com.twins.t20.Dao.JobMemberDaoFatherMapper.class);
	
	
		int cf = jmdfm.getJobMemberMaxIdx();
	//System.out.println("¸Æ½º:"+cf);
		jmv.setJmidx(cf+1);
		
		cf = jmdfm.insertJobMember(jmv);
	
		return cf;
	}

	@Override
	public boolean confirmJobMemberID(String jmid) {
		
		JobMemberDaoFatherMapper jmdfm = sqlSession.getMapper(com.twins.t20.Dao.JobMemberDaoFatherMapper.class);
		boolean cf = jmdfm.confirmJobMemberID(jmid);
		
		return cf;
	}

	@Override
	public JobMemberVo loginJobMember(HashMap<String, Object> map) {
		
		JobMemberDaoFatherMapper jmdfm = sqlSession.getMapper(com.twins.t20.Dao.JobMemberDaoFatherMapper.class);
//		map.put("jmid",jmv.getJmname());
//		map.put("jmpsword", jmv.getJmpsword());
		
		JobMemberVo jmvr = jmdfm.loginJobMember(map);

		return jmvr;
	}

	@Override
	public String getIDJobMember(HashMap<String, Object> map) {
		
		JobMemberDaoFatherMapper jmdfm = sqlSession.getMapper(com.twins.t20.Dao.JobMemberDaoFatherMapper.class);
//		map.put("jmname", jmv.getJmname());
//		map.put("jmemail", jmv.getJmemail());
//			
		String id = jmdfm.getIDJobMember(map);
		
		return id;
	}

	@Override
	public String getPswordJobMember(HashMap<String, Object> map) {
		
		JobMemberDaoFatherMapper jmdfm = sqlSession.getMapper(com.twins.t20.Dao.JobMemberDaoFatherMapper.class);
		
//			map.put("jmid", jmv.getJmid());
//			map.put("jmemail",jmv.getJmemail());
//			
			String psword = jmdfm.getPswordJobMember(map);
		
		return psword;
	}

	@Override
	public int deleteJobMember(HashMap<String, Object> map) {
		
		JobMemberDaoFatherMapper jmdfm = sqlSession.getMapper(com.twins.t20.Dao.JobMemberDaoFatherMapper.class);
		
			map.put("jmregister", jmv.getJmregister());
			map.put("jmidx", jmv.getJmidx());
		
		int drop = jmdfm.deleteJobMember(map);
		
		return drop;
	}

	@Override
	public int changePsword(HashMap<String, Object> map) {
		
		JobMemberDaoFatherMapper jmdfm = sqlSession.getMapper(com.twins.t20.Dao.JobMemberDaoFatherMapper.class);
//		map.put("jmpsword",jmv.getJmpsword());
//		map.put("jmidx", jmv.getJmidx());
			
		int cp = jmdfm.changePsword(map);
			
		return cp;
	}

	@Override
	public int modifyJobMember(HashMap<String, Object> map) {
		
		JobMemberDaoFatherMapper jmdfm = sqlSession.getMapper(com.twins.t20.Dao.JobMemberDaoFatherMapper.class);
				map.put("jmemail", jmv.getJmemail());
				map.put("jmaddr", jmv.getJmemail());
		int mdjm = jmdfm.modifyJobMember(map);
		
		return mdjm;
	}

	@Override
	public JobMemberVo selectJobMember(int jmidx) {
		
		
		JobMemberDaoFatherMapper jmdfm = sqlSession.getMapper(com.twins.t20.Dao.JobMemberDaoFatherMapper.class);
		JobMemberVo jmv = jmdfm.selectJobMember(jmidx);
		
		return jmv;
	}

}
