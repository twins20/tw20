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
		
//		int midx = Integer.parseInt(request.getParameter("midx"));
		int midx = 1;
		
		//관리자 머니 충전 승인				
		
		int row = as.adminMoneyModOkTransaction(midx);		
		
		if(row == 2){				
			System.out.println("승인 성공");	 //row = 2			
		}else{
			System.out.println("승인 실패");	 //row = 0 or 1
		}
		
//		PageRedirect pr = new PageRedirect(false, "/admin/AdminMoneyList.jsp", request, response);		
		
		
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
