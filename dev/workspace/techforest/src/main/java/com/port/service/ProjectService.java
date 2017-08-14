package com.port.service;

import java.util.ArrayList;
import java.util.Map;

public interface ProjectService {
	
	//카테고리별 프로젝트 리스트
	public ArrayList<ProjectVo> projListByCate(String pCate);
	
	//현재 투자금액순 프로젝트 리스트
	public ArrayList<ProjectVo> projListByPower();
	
	//현재 프로젝트 기술순 프로젝트 리스트
	public ArrayList<ProjectVo> projListByTech();
	
	//프로젝트 내용
	public ProjectVo projCon(int pIdx);

	//프로젝트 내용(사업자 정보)
	public MemberVo projConCmem(int pIdx);
	
	//프로젝트 내용(댓글 리스트)
	public ArrayList<ProjectCommVo> projConCommList(int pIdx);
	
	//프로젝트 내용(아이템 리스트)
	public ArrayList<ItemVo> projConItemList(int pIdx);
	
	//프로젝트 결제(아이템)
	public ItemVo projPayItem(int itIdx);
	
	//프로젝트 결제(멤버정보)
	public Map<String, Object> projPayMyMoney(int sess_idx);

}