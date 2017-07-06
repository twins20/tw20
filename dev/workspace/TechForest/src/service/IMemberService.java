package service;

import java.util.ArrayList;

import org.apache.catalina.tribes.util.Arrays;

public interface IMemberService {
	
	//투자자 펀드 리스트
	public void IMemberFundList();
	
	//투자자 인덱스페이지 프로젝트 리스트
	public ArrayList<MemberVo> IMemberIndexPProjectList();

	//투자자 회원정보
	public MemberVo IMemberInfoCon(int idx);
	
	//투자자 회원정보수정
	public void IMemberInfoMod();
	
	//투자자 충전 및 금액조회 페이지
	public void IMemberMoneyHis();
	
	//투자자 충전 및 금액조회 페이지 충전신청
	public void IMemberMoneyCharge_Action();
		
	//투자자 위시리스트 
	public void IMemberWishList();

	//투자자 위시리스트 삭제
	public void IMemberWIshListDel_Action();

	
	
}
