package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import common.PagingQ;
import service.AdminServiceImpl;
import service.BoardVo;
import service.FundVo;
import service.MemberVo;
import service.MoneyVo;
import service.ProjectVo;


@WebServlet("/AdminCmemInfoConServlet")
public class AdminCmemInfoConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminCmemInfoConServlet() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}	
		
		int ttCnt = 0, listCnt = 3, pageCnt = 1;
		if(request.getParameter("pageCnt") != null){
			pageCnt = Integer.parseInt(request.getParameter("pageCnt").trim(),10);			
		}			
		int d_ttCnt = 0, d_pageCnt = 1;
		if(request.getParameter("d_pageCnt") != null){
			d_pageCnt = Integer.parseInt(request.getParameter("d_pageCnt").trim(),10);			
		}
		int e_ttCnt = 0, e_pageCnt = 1;
		if(request.getParameter("e_pageCnt") != null){
			e_pageCnt = Integer.parseInt(request.getParameter("e_pageCnt").trim(),10);			
		}
		int f_ttCnt = 0, f_pageCnt = 1;
		if(request.getParameter("f_pageCnt") != null){
			f_pageCnt = Integer.parseInt(request.getParameter("f_pageCnt").trim(),10);			
		}
		int g_ttCnt = 0, g_pageCnt = 1;
		if(request.getParameter("g_pageCnt") != null){
			g_pageCnt = Integer.parseInt(request.getParameter("g_pageCnt").trim(),10);			
		}
		
		int param_idx = 0; 
		param_idx = Integer.parseInt(request.getParameter("param_idx").trim(),10);	
		
		//관리자 사업자 회원정보 페이지 회원별 상세정보 
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>();
		
		AdminServiceImpl as = new AdminServiceImpl();
		alist = as.adminCmemInfoCon(param_idx);
		request.setAttribute("alist", alist);		
		
		//관리자 사업자 회원정보 페이지 진행중 프로젝트
		ArrayList<ProjectVo> blist = new ArrayList<ProjectVo>();
		blist = as.adminCmemInfoProj(param_idx);
		request.setAttribute("blist", blist);
		
		ArrayList<FundVo> clist = new ArrayList<FundVo>();
		clist = as.adminCmemInfoProj1(param_idx);
		request.setAttribute("clist", clist);
		
		//관리자 사업자 회원정보 페이지 지난 프로젝트 리스트 
		String d_pageList = null;
		
		ArrayList<ProjectVo> dlist = new ArrayList<ProjectVo>();
		dlist = as.adminCmemInfoProjHis(param_idx, listCnt, d_pageCnt);
		d_ttCnt = as.adminCmemInfoProjHisTtCnt(param_idx);
		d_pageList = new PagingQ().pagingList(listCnt, d_pageCnt, d_ttCnt);
		String[] d_tmpPageInfo = d_pageList.split(" ");
		
		request.setAttribute("dlist", dlist);
		request.setAttribute("d_pageList", d_pageList);
		request.setAttribute("d_startPage", d_tmpPageInfo[0]);
		request.setAttribute("d_pageCnt", d_tmpPageInfo[1]);
		request.setAttribute("d_endPage", d_tmpPageInfo[2]);	
				
		//관리자 사업자 회원정보 페이지 진행중 프로젝트 투자 회원리스트
		String e_pageList = null;
		
		ArrayList<Map<String, Object>> elist = new ArrayList<Map<String, Object>>();		
		elist =  as.adminCmemInfoProjFundHis(param_idx, listCnt, pageCnt);	
		e_ttCnt = as.adminCmemInfoProjFundHisTtCnt(param_idx);
		e_pageList = new PagingQ().pagingList(listCnt, e_pageCnt, e_ttCnt);
		String[] e_tmpPageInfo = e_pageList.split(" ");
		
		request.setAttribute("elist", elist);
		request.setAttribute("e_pageList", e_pageList);
		request.setAttribute("e_startPage", e_tmpPageInfo[0]);
		request.setAttribute("e_pageCnt", e_tmpPageInfo[1]);
		request.setAttribute("e_endPage", e_tmpPageInfo[2]);	
				
		//관리자 사업자 회원정보 페이지 뉴스 리스트	
		String f_pageList = null;
		
		ArrayList<Map<String, Object>> flist = new ArrayList<Map<String, Object>>();		
		flist =  as.adminCmemInfoProjNewsHis(param_idx, listCnt, pageCnt);		
		f_ttCnt = as.adminCmemInfoProjNewsHisTtCnt(param_idx);
		f_pageList = new PagingQ().pagingList(listCnt, f_pageCnt, f_ttCnt);
		String[] f_tmpPageInfo = f_pageList.split(" ");
		
		request.setAttribute("flist", flist);
		request.setAttribute("f_pageList", f_pageList);
		request.setAttribute("f_startPage", f_tmpPageInfo[0]);
		request.setAttribute("f_pageCnt", f_tmpPageInfo[1]);
		request.setAttribute("f_endPage", f_tmpPageInfo[2]);		
		
		//관리자 사업자 회원정보 페이지 QNA 리스트
		String g_pageList = null;
		
		ArrayList<BoardVo> glist = new ArrayList<BoardVo>();
		glist = as.adminCmemInfoProjQna(param_idx, listCnt, pageCnt);
		g_ttCnt = as.adminCmemInfoProjQnaTtCnt(param_idx);
		g_pageList = new PagingQ().pagingList(listCnt, g_pageCnt, g_ttCnt);
		String[] g_tmpPageInfo = g_pageList.split(" ");
		
		request.setAttribute("glist", glist);
		request.setAttribute("g_pageList", g_pageList);
		request.setAttribute("g_startPage", g_tmpPageInfo[0]);
		request.setAttribute("g_pageCnt", g_tmpPageInfo[1]);
		request.setAttribute("g_endPage", g_tmpPageInfo[2]);
				
//		ArrayList<MemberVo> alist1 = (ArrayList<MemberVo>) request.getAttribute("alist");
//		
//		for(MemberVo vo : alist1){
//			System.out.println("사업자 회원정보 페이지 회원별 상세정보");
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getId());
//			System.out.println(vo.getName());
//			System.out.println(vo.getPhone());
//			System.out.println(vo.getAddr());	
//			System.out.println(vo.getcNumber());
//			System.out.println(vo.getcAddr());
//		}
//
//		ArrayList<ProjectVo> blist1 = (ArrayList<ProjectVo>) request.getAttribute("blist");
//		
//		for(ProjectVo vo : blist1){
//			System.out.println("진행중 프로젝트 정보");
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getPnFunds());
//			System.out.println(vo.getPtFunds());
//			System.out.println(vo.getpName());
//		}
//
//		ArrayList<FundVo> clist1 = (ArrayList<FundVo>) request.getAttribute("clist");
//		
//		for(FundVo vo : clist1){
//			System.out.println("사업자 현재 펀드 정보");
//			System.out.println(vo.getInFunds());
//			System.out.println(vo.getbFunds());
//			System.out.println(vo.getaFunds());
//			System.out.println(vo.getInsDate());
//		}
//
//		ArrayList<ProjectVo> dlist1 = (ArrayList<ProjectVo>) request.getAttribute("dlist");
//		
//		for(ProjectVo vo : dlist1){
//			System.out.println("지난 프로젝트 리스트 ");
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getpName());
//			System.out.println(vo.getPnFunds());
//			System.out.println(vo.getPtFunds());
//			System.out.println(vo.getInsDate());
//		}
//		
//		ArrayList<Map<String, Object>> elist1 = (ArrayList<Map<String, Object>>) request.getAttribute("elist"); 
//		
//		for(Map<String, Object> hashmap : elist1){
//			System.out.println("진행중 프로젝트 투자 회원리스트");
//			
//			MemberVo mvo = (MemberVo) hashmap.get("mvo");
//			System.out.println(mvo.getNick());
//			
//			FundVo fvo = (FundVo) hashmap.get("fvo");
//			System.out.println(fvo.getaFunds());
//			System.out.println(fvo.getInsDate());
//			System.out.println(fvo.getStatus());					
//		}
//	
//		ArrayList<Map<String, Object>> flist1 = (ArrayList<Map<String, Object>>) request.getAttribute("flist"); 
//		
//		for(Map<String, Object> hashmap : flist1){
//			System.out.println("뉴스 리스트");
//			
//			BoardVo bvo = (BoardVo) hashmap.get("bvo");			
//			System.out.println(bvo.getbIdx());
//			System.out.println(bvo.getTitle());
//			System.out.println(bvo.getInsDate());
//			
//			ProjectVo pvo = (ProjectVo) hashmap.get("pvo");
//			System.out.println(pvo.getpName());							
//		}
//
//		ArrayList<BoardVo> glist1 = (ArrayList<BoardVo>) request.getAttribute("glist");
//		
//		for(BoardVo vo : glist1){
//			System.out.println("QNA 리스트");
//			System.out.println(vo.getrNum());
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getCate());			
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getHit());
//			System.out.println(vo.getGood());
//			System.out.println(vo.getBad());
//			System.out.println(vo.getCommCnt());
//			System.out.println(vo.getObIdx());	
//			System.out.println(vo.getRbIdx());
//			System.out.println(vo.getbDepth());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getModDate());
//		}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminCmemInfoCon.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
