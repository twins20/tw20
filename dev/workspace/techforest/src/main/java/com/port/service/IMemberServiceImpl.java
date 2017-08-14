package com.port.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.port.common.PagingHelper;

@Service
public class IMemberServiceImpl implements IMemberService {
	
	@Autowired
	SqlSession sqlSession;
	
	private PagingHelper pagingHelper;

	@Override
	public ArrayList<Map<String,Object>> iMemberProjectList(int sess_idx, int start, int end) {

		ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);	
		dataList = iMemberMapper.iMemberProjectList(sess_idx, start, end);
		
		return dataList;	
	}
	
	@Override
	public int iMemberProjectListTc(int sess_idx) {
		
		Map<String, Integer> data = new HashMap<String, Integer>();
		data.put("sess_idx", sess_idx);

		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);
		
		return iMemberMapper.iMemberProjectListTc(data);
	}
	
	@Override
	public ArrayList<BoardVo> iMemberQnaList(int sess_idx, int start, int end) {
		
		ArrayList<BoardVo> blist = new ArrayList<BoardVo>();
		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);
		blist = iMemberMapper.iMemberQnaList(sess_idx, start, end);
		
		return blist;	
	}
	
	@Override
	public int iMemberQnaListTc(int sess_idx) {
		
		Map<String, Integer> data = new HashMap<String, Integer>();
		data.put("sess_idx", sess_idx);

		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);
		
		return iMemberMapper.iMemberQnaListTc(data);
	}
	
	@Override
	public MemberVo iMemberInfoCon(int sess_idx) {
		
		MemberVo mv = new MemberVo();
		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);
		mv = iMemberMapper.iMemberInfoCon(sess_idx);
		
		return mv;
	}
	
	@Override
	public int iMemberInfoModChk(MemberVo mv) {
		
		int row = 0;
		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);
		row = iMemberMapper.iMemberInfoModChk(mv);
		
		return row;
	}
	
	@Override
	public int iMemInfoModAction(MemberVo mv, int sess_idx) {
	
		int row = 0;
		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("sess_idx", sess_idx);
		data.put("pw", mv.getPw());
		data.put("nick", mv.getNick());
		data.put("phone", mv.getPhone());
		data.put("addr", mv.getAddr());
		
		row = iMemberMapper.iMemInfoModAction(data);
		
		return row; 
	}
	
	@Override
	public ArrayList<Map<String, Object>> iMemberMoneyHisList(int sess_idx, int start, int end) {
			
		ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);
		dataList = iMemberMapper.iMemberMoneyHisList(sess_idx, start, end);
		
		return dataList;	
	}
	
	@Override
	public int iMemberMoneyHisListTc(int sess_idx) {
		
		Map<String, Integer> data = new HashMap<String, Integer>();
		data.put("sess_idx", sess_idx);
		
		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);
		
		return iMemberMapper.iMemberMoneyHisListTc(data);
	}
	
	@Override
	public int iMemberMoneyCharge(MoneyVo mov) {

		int row = 0; 		
		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);
		row = iMemberMapper.iMemberMoneyCharge(mov);
		
		return row; 	
	}
	
	@Override
	public ArrayList<ProjectVo> iMemberWishList(int sess_idx) {
		
		ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>();  
		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);
		plist = iMemberMapper.iMemberWishList(sess_idx);
		
		return plist;		
	}
	
	@Override
	public int iMemberWishListDel(int pidx) {

		int row = 0;
		IMemberMapper iMemberMapper = sqlSession.getMapper(IMemberMapper.class);
		row = iMemberMapper.iMemberWishListDel(pidx);
		
		return row;
	} 	
	
	/*
	 * paging
	 */
	
	@Override
	public int getListNo() {
	  
		return pagingHelper.getListNo(); 
	}
	
	@Override
	public int getPrevLink() {

		return pagingHelper.getPrevLink();
	}
	
	@Override
	public int getFirstPage() {

		return pagingHelper.getFirstPage();
	}
	
	@Override
	public int getLastPage() {

		return pagingHelper.getLastPage();
	}

	@Override
	public int getNextLink() {

		return pagingHelper.getNextLink();
	}

	@Override
	public int[] getPageLinks() {

		return pagingHelper.getPageLinks();
	}

	
	public PagingHelper getPagingHelper() {

		return pagingHelper;
	}

	public void setPagingHelper(PagingHelper pagingHelper) {

		this.pagingHelper = pagingHelper;
	}
}
