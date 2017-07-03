package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
		AdminServiceImpl as = new AdminServiceImpl();	
		int pidx = Integer.parseInt(request.getParameter("pidx"));	
		
		//관리자 프로젝트 등록 승인 내용  
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
					
		alist =  as.adminProJChkCon(pidx);		
		request.setAttribute("alist", alist);
				
		ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist"); 
		
		for(Map<String, Object> hashmap : alist1){
			
			ProjectVo pv = (ProjectVo) hashmap.get("pv");
			ItemVo iv = (ItemVo) hashmap.get("iv");
						
			System.out.println("프로젝트 승인전 컨텐츠");
			System.out.println(pv.getpName());
			System.out.println(pv.getpCate());
			System.out.println(pv.getContents());
			System.out.println(pv.getItList());
			System.out.println(pv.getItListCnt());
			System.out.println(pv.getPtFunds());
			System.out.println(pv.getPnFunds());
			System.out.println(pv.getpGrade());
			System.out.println(pv.getStatus());
			System.out.println(pv.getInsDate());
			System.out.println(pv.getPsDate());
			System.out.println(pv.getPeDate());
			System.out.println(pv.getPcDate());
			System.out.println(iv.getItIdx());
			System.out.println(iv.getItName());
			System.out.println(iv.getItPrice());
			System.out.println(iv.getContents());
			System.out.println(iv.getItTCnt());
			System.out.println(iv.getItSCnt());
			System.out.println(iv.getStatus());
					
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
