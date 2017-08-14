package com.port.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface IMemberMapper {
	
	//투자자 투자리스트
	public ArrayList<Map<String,Object>> iMemberProjectList(int sess_idx, int start, int end);
	
	//투자자 게시물 개수
	public int iMemberProjectListTc(Map<String, Integer> data);
	
	//투자자 qna 리스트
	public ArrayList<BoardVo> iMemberQnaList(int sess_idx, int start, int end);
	
	//투자자 qna 리스트 게시물 개수
	public int iMemberQnaListTc(Map<String, Integer> data);
	
	//투자자 회원정보
	public MemberVo iMemberInfoCon(int sess_idx);
		
	//투자자 회원정보 수정 체크
	public int iMemberInfoModChk(MemberVo mv);

	//투자자 회원정보 수정 
	public int iMemInfoModAction(Map<String,Object> data);

	//투자자 머니 충전 리스트
	public ArrayList<Map<String, Object>> iMemberMoneyHisList(int sess_idx, int start, int end);
	
	//투자자 머니 충전 리스트 게시물 개수
	public int iMemberMoneyHisListTc(Map<String, Integer> data);
	
	//투자자 머니 충전
	public int iMemberMoneyCharge(MoneyVo mov);
	
	//투자자 위시리스트
	public ArrayList<ProjectVo> iMemberWishList(int sess_idx);

	//투자자 위시리스트 삭제
	public int iMemberWishListDel(int pidx);

}
