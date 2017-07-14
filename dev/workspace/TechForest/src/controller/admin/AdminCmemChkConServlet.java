package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.AdminServiceImpl;
import service.MemberVo;


@WebServlet("/AdminCmemChkConServlet")
public class AdminCmemChkConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminCmemChkConServlet() {
        super();    
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}
		
		int param_idx = 0; 
		param_idx = Integer.parseInt(request.getParameter("param_idx").trim(),10);	
		
		//관리자 사업자 회원정보 페이지 회원별 상세정보 
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>();
		
		AdminServiceImpl as = new AdminServiceImpl();
		alist = as.adminCmemInfoCon(param_idx);
		request.setAttribute("alist", alist);			
//		request.setAttribute("param_idx", param_idx);
					
		PageRedirect pr = new PageRedirect(false, "/admin/AdminCmemChkCon.jsp", request, response);				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
