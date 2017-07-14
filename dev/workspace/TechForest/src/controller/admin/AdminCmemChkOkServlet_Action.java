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
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}
				
		//관리자 사업자 등록 승인			
		int param_idx = 0;
		param_idx = Integer.parseInt(request.getParameter("param_idx").trim(),10);		
		
		int row = 0;
		
		AdminServiceImpl as = new AdminServiceImpl();	
		row = as.adminCmemChkOkMem(param_idx);
		row += as.adminCmemChkOkCmem(sess_idx, param_idx);
		
//		System.out.println(row);
//		if(row == 2){
//			System.out.println("승인 성공");							
//		}else{
//			System.out.println("승인 실패");	
//		}
			
		PageRedirect pr = new PageRedirect(true, "/AdminCmemChkList.do", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
