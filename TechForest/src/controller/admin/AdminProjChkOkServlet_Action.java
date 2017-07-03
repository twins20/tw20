package controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBConnect;
import service.AdminServiceImpl;


@WebServlet("/AdminProjChkOkServlet_Action")
public class AdminProjChkOkServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminProjChkOkServlet_Action() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DBConnect dbconnect = new DBConnect();
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null;
		
		AdminServiceImpl as = new AdminServiceImpl();		
		int pidx = Integer.parseInt(request.getParameter("pidx"));		
		int row = 0;
		
		//관리자 프로젝트 등록 승인		
		as.adminProJChkOk(pidx);			
		
		if(row != 0){				
			System.out.println("승인 성공");	
				
		}else{			
			System.out.println("승인 실패");	
		}
		
		//관리자 프로젝트 등록 반려 
		as.adminProJChkNOk(pidx);
		
		if(row != 0){				
			System.out.println("반려 성공");	
				
		}else{			
			System.out.println("반려 실패");	
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
