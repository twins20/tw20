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


@WebServlet("/AdminProjChkNOkServlet_Action")
public class AdminProjChkNOkServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminProjChkNOkServlet_Action() {
        super();      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();		
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		int pIdx = 0;
		pIdx = Integer.parseInt(request.getParameter("pIdx"));		
		
		int row = 0;
		
		//관리자 프로젝트 등록 반려 
		as.adminProJChkNOk(idx, pIdx);
		
		if(row != 0){				
//			System.out.println("반려 성공");					
		}else{			
//			System.out.println("반려 실패");	
		}
		
		PageRedirect pr = new PageRedirect(true, "/AdminProjChkList.do", request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
