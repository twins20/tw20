package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import service.MemberVo;
import service.MoneyVo;
import service.ProjectServiceImpl;
import service.ProjectVo;


@WebServlet("/AdminIndexServlet")
public class AdminIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AdminIndexServlet() {
        super();       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}			

		int ttCnt = 0, listCnt = 2, pageCnt = 1;
		if(request.getParameter("pageCnt") != null){
			pageCnt = Integer.parseInt(request.getParameter("pageCnt").trim(),10);			
		}
		int b_ttCnt = 0, b_pageCnt = 1;
		if(request.getParameter("b_pageCnt") != null){
			b_pageCnt = Integer.parseInt(request.getParameter("b_pageCnt").trim(),10);			
		}
		int c_ttCnt = 0, c_pageCnt = 1;
		if(request.getParameter("c_pageCnt") != null){
			c_pageCnt = Integer.parseInt(request.getParameter("c_pageCnt").trim(),10);			
		}
		
		//회원 충전 대기 리스트		
		String pageList = null;
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();		
		
		AdminServiceImpl as = new AdminServiceImpl();				
		alist =  as.adminIndexPMoneyChkList(listCnt, pageCnt);
		ttCnt = as.adminIndexPMoneyChkListTtCnt();
		pageList = new PagingQ().pagingList(listCnt, pageCnt, ttCnt);
		String[] tmpPageInfo = pageList.split(" ");
		
		request.setAttribute("alist", alist);
		request.setAttribute("pageList", pageList);
		request.setAttribute("startPage", tmpPageInfo[0]);
		request.setAttribute("pageCnt", tmpPageInfo[1]);
		request.setAttribute("endPage", tmpPageInfo[2]);		
		
		//프로젝트 승인 대기 리스트
		String b_pageList = null;
		ArrayList<ProjectVo> blist = new ArrayList<ProjectVo>();
		
		blist = as.adminIndexPProjectChkList(listCnt, b_pageCnt);
		b_ttCnt = as.adminIndexPProjectChkListTtCnt();
		b_pageList = new PagingQ().pagingList(listCnt, b_pageCnt, b_ttCnt);
		String[] b_tmpPageInfo = b_pageList.split(" ");
				
		request.setAttribute("blist", blist);
		request.setAttribute("b_pageList", b_pageList);
		request.setAttribute("b_startPage", b_tmpPageInfo[0]);
		request.setAttribute("b_pageCnt", b_tmpPageInfo[1]);
		request.setAttribute("b_endPage", b_tmpPageInfo[2]);	
				
		//사업자 승인 대기 리스트
		String c_pageList = null;
		ArrayList<MemberVo> clist = new ArrayList<MemberVo>();
		
		clist = as.adminIndexPCmemChkList(listCnt, c_pageCnt);
		c_ttCnt = as.adminIndexPCmemChkListTtCnt();
		c_pageList = new PagingQ().pagingList(listCnt, c_pageCnt, c_ttCnt);
		String[] c_tmpPageInfo = c_pageList.split(" ");
		
		request.setAttribute("clist", clist);	
		request.setAttribute("c_pageList", c_pageList);
		request.setAttribute("c_startPage", c_tmpPageInfo[0]);
		request.setAttribute("c_pageCnt", c_tmpPageInfo[1]);
		request.setAttribute("c_endPage", c_tmpPageInfo[2]);	
		
		ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist"); 
		
//		for(Map<String, Object> hashmap : alist1){
//			
//			MemberVo mbv = (MemberVo) hashmap.get("mbv");
//			System.out.println(mbv.getIdx());
//			System.out.println(mbv.getName());		
//		
//			MoneyVo mnv = (MoneyVo) hashmap.get("mnv");
//			System.out.println(mnv.getChgMoney());
//			System.out.println(mnv.getInsDate());
//			System.out.println(mnv.getStatus());			
//		}
//					
//		ArrayList<ProjectVo> blist1 = (ArrayList<ProjectVo>) request.getAttribute("blist");
//		
//		for(ProjectVo vo : blist1){
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getpName());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getStatus());			
//		}
//
//		ArrayList<MemberVo> clist1 = (ArrayList<MemberVo>) request.getAttribute("clist");
//		for(MemberVo vo : clist1){
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getName());
//			System.out.println(vo.getCompany());
//			System.out.println(vo.getModDate());	
//		}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminIndex.jsp", request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
