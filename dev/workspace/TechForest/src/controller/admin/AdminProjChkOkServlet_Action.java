package controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.DBConnect;
import common.PageRedirect;
import service.AdminServiceImpl;


@WebServlet("/AdminProjChkOkServlet_Action")
public class AdminProjChkOkServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminProjChkOkServlet_Action() {
        super();      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}

		int pIdx = 0;
		int row = 0;
		pIdx = Integer.parseInt(request.getParameter("pIdx").trim());		
				
//		관리자 프로젝트 등록 승인			
		AdminServiceImpl as = new AdminServiceImpl();			
		row = as.adminProJChkOk(sess_idx, pIdx);			

//		if(row != 0){				
//			System.out.println("승인 성공");				
//		}else{			
//			System.out.println("승인 실패");	
//		}
		
		PageRedirect pr = new PageRedirect(true, "/AdminProjChkList.do", request, response);			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
