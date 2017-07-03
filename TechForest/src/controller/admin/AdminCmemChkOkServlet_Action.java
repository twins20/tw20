package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.AdminServiceImpl;


@WebServlet("/AdminCmemChkOkServlet_Action")
public class AdminCmemChkOkServlet_Action extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public AdminCmemChkOkServlet_Action() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();	
		
		//관리자 사업자 등록 승인
			
		int idx = Integer.parseInt(request.getParameter("idx"));		
//		int idx = 1;
		
		int row = as.adminCmemChkOk(idx);
						
		if(row != 0){
			System.out.println("승인 성공");							
		}else{
			System.out.println("승인 실패");	
		}
			
		PageRedirect pr = new PageRedirect(true, "/admin/AdminCmemChkList.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
