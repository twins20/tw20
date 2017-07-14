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
import service.AdminServiceImpl;
import service.ItemVo;
import service.MemberVo;
import service.MoneyVo;
import service.ProjectVo;


@WebServlet("/AdminProjChkConServlet")
public class AdminProjChkConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminProjChkConServlet() {
        super();      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}		
		
		int pIdx = 0;		
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		}
		
		//관리자 프로젝트 등록 승인 내용  
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
					
		AdminServiceImpl as = new AdminServiceImpl();	
		alist = as.adminProJChkCon(pIdx);		
		request.setAttribute("alist", alist);
				
//		ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist"); 
//		
//		for(Map<String, Object> hashmap : alist1){
//			
//			ProjectVo pvo = (ProjectVo) hashmap.get("pvo");						
//			System.out.println("프로젝트 승인전 컨텐츠");
//			System.out.println(pvo.getpName());
//			System.out.println(pvo.getpCate());
//			System.out.println(pvo.getContents());
//			System.out.println(pvo.getItList());
//			System.out.println(pvo.getItListCnt());
//			System.out.println(pvo.getPtFunds());
//			System.out.println(pvo.getPnFunds());
//			System.out.println(pvo.getpGrade());
//			System.out.println(pvo.getStatus());
//			System.out.println(pvo.getInsDate());
//			System.out.println(pvo.getPsDate());
//			System.out.println(pvo.getPeDate());
//			System.out.println(pvo.getPcDate());
//			
//			ItemVo ivo = (ItemVo) hashmap.get("ivo");
//			System.out.println(ivo.getItIdx());
//			System.out.println(ivo.getItName());
//			System.out.println(ivo.getItPrice());
//			System.out.println(ivo.getContents());
//			System.out.println(ivo.getItTCnt());
//			System.out.println(ivo.getItSCnt());
//			System.out.println(ivo.getStatus());
//					
//		}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminProjChkCon.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
