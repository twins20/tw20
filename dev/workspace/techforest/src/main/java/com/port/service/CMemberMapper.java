package com.port.service;

import java.util.ArrayList;
import java.util.Map;

public interface CMemberMapper {
	
	//사업자 인덱스 현재 진행중 프로젝트 리스트
	public ProjectVo cMemberIndexProjNowList(int sess_idx);
	
	//사업자 인덱스 댓글 리스트
	public ArrayList<Map<String, Object>> cMemberIndexCommList(int sess_idx);
	
	//사업자 등록 확인
	public int cMemberInfoExtWriteChk(int sess_idx);
	
	//사업자 등록 
	public int cMemberInfoExtWrite(Map<String, Object> data);
	
	//사업자 회원정보
	public Map<String, Object> cMemberInfoCon(int sess_idx);
	
	//사업자 회원정보 비밀번호 체크
	public int cMemberInfoModChk(MemberVo mv);
	
	//사업자 회원정보 수정
	public int cMemberInfoMod(MemberVo mv);
	
	//사업자 현재 진행중인 프로젝트 리스트
	public ProjectVo cMemberProjNowList(int sess_idx);
	
	//사업자 완료된 프로젝트 리스트
	public ArrayList<ProjectVo> cMemberProjHisList(int sess_idx);
}
