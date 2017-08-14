package com.port.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private SqlSession sqlSession;	
	
	//관리자 인덱스 페이지 충전 대기 리스트 
	@Override
	public ArrayList<Map<String, Object>> adminIndexPMoneyChkList(){
			
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminIndexPMoneyChkList();
		
		return alist;
	}
	
		
	//관리자 인덱스 페이지 프로젝트 승인 대기 리스트
	@Override
	public ArrayList<ProjectVo> adminIndexPProjectChkList(){		
				
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminIndexPProjectChkList();
			
		return alist;	
	}
	
	//관리자 프로젝트 등록 승인 내용  
	@Override
	public Map<String, Object> adminProJChkCon(ProjectVo pv){

		Map<String, Object> data = new HashMap<String, Object>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		data = adminMapper.adminProJChkCon(pv);
		return data;
		
	}

	//관리자 인덱스 페이지 사업자 승인 대기 리스트
	@Override
	public ArrayList<MemberVo> adminIndexPCmemChkList(){
		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminIndexPCmemChkList();			

		return alist;
	}
		

	//관리자 사업자 회원정보 페이지 회원리스트  
	@Override
	public ArrayList<Map<String, Object>> adminCmemInfoList(){
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminCmemInfoList();

		return alist;
	}
	
	//관리자 사업자 회원정보 페이지 회원별 상세정보  
	@Override
	public Map<String, Object> adminCmemInfoCon(MemberVo mv){

		Map<String, Object> data = new HashMap<String, Object>();			
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		data = adminMapper.adminCmemInfoCon(mv);
		
		return data;	
	}
	
	//관리자 사업자 회원정보 페이지 진행중 프로젝트	
	@Override
	public ArrayList<ProjectVo> adminCmemInfoProj(int sess_idx){
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminCmemInfoProj(sess_idx);
		
		return alist;
	}

	//관리자 사업자 회원정보 페이지 지난 프로젝트 리스트
	@Override
	public ArrayList<ProjectVo> adminCmemInfoProjHis(int sess_idx){
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminCmemInfoProjHis(sess_idx);

		return alist;	
	}
	
	//관리자 사업자 회원정보 페이지 진행중 프로젝트 투자 회원리스트
	@Override
	public ArrayList<Map<String, Object>> adminCmemInfoProjFundHis(int sess_idx){
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminCmemInfoProjFundHis(sess_idx);	
		
		return alist;
	}
	
	
	//관리자 사업자 회원정보 페이지 QNA 리스트
	@Override
	public ArrayList<BoardVo> adminCmemInfoProjQna(int sess_idx){
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminCmemInfoProjQna(sess_idx);	

		return alist;	
	}

	//관리자 투자자 회원정보 페이지 회원리스트
	@Override
	public ArrayList<MemberVo> adminImemInfoList(){
		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminImemInfoList();

		return alist;
	}
	
	//관리자 투자자 회원 정보 페이지 회원별 상세 정보
	@Override
	public	MemberVo adminImemInfoCon(int sess_idx){
			 
		MemberVo mv = new MemberVo();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		mv = adminMapper.adminImemInfoCon(sess_idx);

		return mv;	
	}
	
	//관리자 투자자 회원정보 페이지 회원별 충전 기록 리스트
	@Override
	public ArrayList<MoneyVo> adminImemInfoMoneyHis(int sess_idx){
			
		ArrayList<MoneyVo> alist = new ArrayList<MoneyVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminImemInfoMoneyHis(sess_idx);	

		return alist;
	}
	
	//관리자 투자자 회원정보 페이지 프로젝트 참가 기록 리스트
	@Override
	public ArrayList<Map<String, Object>> adminImemInfoProjHis(int sess_idx){

		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminImemInfoProjHis(sess_idx);
	
		return alist;
	}	
		
	//관리자 투자자 회원정보 페이지 QNA 참가기록 리스트	
	@Override
	public ArrayList<Map<String, Object>> adminImemInfoQnaHis(int sess_idx){
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminImemInfoQnaHis(sess_idx);

		return alist;
	}

	//관리자 고객센터 페이지 FAQ 리스트 
	@Override
	public ArrayList<BoardVo> adminBoardFaqList(){
				
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminBoardFaqList();	


		return alist;	
	}	
	
	//관리자 고객센터 페이지 FAQ 상세내용 
	@Override
	public BoardVo adminBoardFaqCon(int bIdx){

		BoardVo bv = new BoardVo();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		bv = adminMapper.adminBoardFaqCon(bIdx);
		
		return bv;	
	}
	
	//관리자 뉴스관리 페이지 뉴스 리스트  
	@Override
	public ArrayList<BoardVo> adminBoardNewsList(){
	
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminBoardNewsList();
	
		return alist;	
	}

	//관리자 고객센터 페이지 QNA리스트 
	@Override
	public ArrayList<BoardVo> adminBoardQnaList(){

		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminBoardQnaList();	
		
		return alist;	
	}
	
	//관리자 고객센터 페이지 QNA 상세내용
	@Override
	public BoardVo adminBoardQnaCon(int bIdx){

		BoardVo bv = new BoardVo();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		bv = adminMapper.adminBoardQnaCon(bIdx);			
		
		return bv;	
	}
	
	//관리자 고객센터 페이지 전체 공지사항 리스트 
	@Override
	public ArrayList<BoardVo> adminBoardNoticeList(){

		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminBoardNoticeList();	

		return alist;	
	}	
	
	//관리자 고객센터 페이지 전체 공지사항 상세내용 
	@Override
	public BoardVo adminBoardNoticeCon(int bIdx){
		
		BoardVo bv = new BoardVo();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		bv = adminMapper.adminBoardNoticeCon(bIdx);						
		
		return bv;
	}
	
	//관리자 사업자 등록 승인 리스트
	@Override
	public ArrayList<MemberVo> adminCmemChkList(){
		
		ArrayList<MemberVo> mlist = new ArrayList<MemberVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		mlist = adminMapper.adminCmemChkList();
		
		return mlist;
	}	
	
	
}

