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


@WebServlet("/AdminImemInfoConServlet")
public class AdminImemInfoConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminImemInfoConServlet() {
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
		int c_ttCnt = 0, c_pageCnt = 1;
		if(request.getParameter("c_pageCnt") != null){
			c_pageCnt = Integer.parseInt(request.getParameter("c_pageCnt").trim(),10);			
		}
		int d_ttCnt = 0, d_pageCnt = 1;
		if(request.getParameter("d_pageCnt") != null){
			d_pageCnt = Integer.parseInt(request.getParameter("d_pageCnt").trim(),10);			
		}
		
		int param_idx = 0;
		param_idx = Integer.parseInt(request.getParameter("param_idx").trim(),10);		
		
		//관리자 투자자 회원 정보 페이지 회원별 상세 정보		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>();		
		AdminServiceImpl as = new AdminServiceImpl();
			alist = as.adminImemInfoCon(param_idx);
			request.setAttribute("alist", alist);
	
		//관리자 투자자 회원정보 페이지 회원별 충전 기록
		String pageList = null;
		ArrayList<MoneyVo> blist = new ArrayList<MoneyVo>();	
			blist = as.adminImemInfoMoneyHis(param_idx, listCnt, pageCnt);
			ttCnt = as.adminImemInfoMoneyHisTtCnt(param_idx);
			pageList = new PagingQ().pagingList(listCnt, pageCnt, ttCnt);
			String[] tmpPageInfo = pageList.split(" ");
	
			request.setAttribute("blist", blist);
			request.setAttribute("pageList", pageList);
			request.setAttribute("startPage", tmpPageInfo[0]);
			request.setAttribute("pageCnt", tmpPageInfo[1]);
			request.setAttribute("endPage", tmpPageInfo[2]);	
			
			
		//관리자 투자자 회원정보 페이지 프로젝트 참가 기록 리스트
		String c_pageList = null;
		ArrayList<Map<String, Object>> clist = new ArrayList<Map<String, Object>>();		
		
			clist = as.adminImemInfoProjHis(param_idx, listCnt, c_pageCnt);
			c_ttCnt = as.adminImemInfoProjHisTtCnt(param_idx);
			c_pageList = new PagingQ().pagingList(listCnt, c_pageCnt, c_ttCnt);
			String[] c_tmpPageInfo = c_pageList.split(" ");
			
			request.setAttribute("clist", clist);	
			request.setAttribute("c_pageList", c_pageList);
			request.setAttribute("c_startPage", c_tmpPageInfo[0]);
			request.setAttribute("c_pageCnt", c_tmpPageInfo[1]);
			request.setAttribute("c_endPage", c_tmpPageInfo[2]);
			
		//관리자 투자자 회원정보 페이지 QNA 참가기록 리스트
		String d_pageList = null;
		ArrayList<Map<String, Object>> dlist = new ArrayList<Map<String, Object>>();				
			dlist = as.adminImemInfoQnaHis(param_idx, listCnt, d_pageCnt);
			d_ttCnt = as.adminImemInfoQnaHisTtCnt(param_idx);
			d_pageList = new PagingQ().pagingList(listCnt, d_pageCnt, d_ttCnt);
			String[] d_tmpPageInfo = d_pageList.split(" ");
					
			request.setAttribute("dlist", dlist);	
			request.setAttribute("d_pageList", d_pageList);
			request.setAttribute("d_startPage", d_tmpPageInfo[0]);
			request.setAttribute("d_pageCnt", d_tmpPageInfo[1]);
			request.setAttribute("d_endPage", d_tmpPageInfo[2]);		
			
//		ArrayList<MemberVo> alist1 = (ArrayList<MemberVo>) request.getAttribute("alist");
//		
//		for(MemberVo vo : alist1){
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getId());
//			System.out.println(vo.getName());
//			System.out.println(vo.getPhone());
//			System.out.println(vo.getAddr());	
//		}
//
//		ArrayList<MoneyVo> blist1 = (ArrayList<MoneyVo>) request.getAttribute("blist");
//		
//		for(MoneyVo vo : blist1){
//			System.out.println(vo.getmIdx());
//			System.out.println(vo.getChgMoney());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getStatus());					
//		}
//
//		ArrayList<Map<String, Object>> clist1 = (ArrayList<Map<String, Object>>) request.getAttribute("clist"); 
//		
//		for(Map<String, Object> hashmap : clist1){
//			
//			ProjectVo pvo = (ProjectVo) hashmap.get("pvo");
//			System.out.println(pvo.getpIdx());
//			System.out.println(pvo.getpName());				
//			System.out.println(pvo.getPnFunds());
//			System.out.println(pvo.getPtFunds());	
//				
//			FundVo fvo = (FundVo) hashmap.get("fvo");	
//			System.out.println(fvo.getInFunds());
//			System.out.println(fvo.getInsDate());
//			
//		}	
//		
//		ArrayList<Map<String, Object>> dlist1 = (ArrayList<Map<String, Object>>) request.getAttribute("dlist"); 
//		
//		for(Map<String, Object> hashmap : dlist1){
//			
//			MemberVo mvo = (MemberVo) hashmap.get("mvo");
//			System.out.println(mvo.getIdx());
//			System.out.println(mvo.getInsDate());
//			
//			BoardVo bvo = (BoardVo) hashmap.get("bvo");	
//			System.out.println(bvo.getContents());
//			System.out.println(bvo.getbDepth());
//			
//		}	
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminImemInfoCon.jsp", request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
