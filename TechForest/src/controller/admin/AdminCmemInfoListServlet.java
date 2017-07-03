package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.AdminServiceImpl;
import service.MemberVo;
import service.MoneyVo;
import service.ProjectVo;


@WebServlet("/AdminCmemInfoListServlet")
public class AdminCmemInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminCmemInfoListServlet() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminServiceImpl as = new AdminServiceImpl();	
		
		//관리자 사업자 회원정보 페이지 회원리스트  
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();					
		alist =  as.adminCmemInfoList();		
		request.setAttribute("alist", alist);
				
//		ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist"); 
//		
//		for(Map<String, Object> hashmap : alist1){
//			
//			MemberVo mvo = (MemberVo) hashmap.get("mvo");			
//			System.out.println(mvo.getIdx());
//			System.out.println(mvo.getId());
//			System.out.println(mvo.getName());
//			
//			ProjectVo pvo = (ProjectVo) hashmap.get("pvo");
//			System.out.println(pvo.getPnFunds());				
//		}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminCmemInfoList.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
