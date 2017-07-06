package controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.DBClose;
import common.DBConnect;
import common.PageRedirect;
import service.AdminServiceImpl;


@WebServlet("/AdminMoneyChkOkServlet_Action")
public class AdminMoneyChkOkServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminMoneyChkOkServlet_Action() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		int mIdx = 0;
		mIdx = Integer.parseInt(request.getParameter("mIdx"));

		
		//관리자 머니 충전 승인	
//		int idx = 1;
//		int mIdx = 1;
		int row = 0;
		row = as.adminMoneyModOkTransaction(idx, mIdx);		
		
//		if(row == 2){				
//			System.out.println("승인 성공");	 	
//		}else{
//			System.out.println("승인 실패");	 
//		}
		
		PageRedirect pr = new PageRedirect(true, "/AdminMoneyList.do", request, response);							
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
