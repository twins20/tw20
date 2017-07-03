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
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		AdminServiceImpl as = new AdminServiceImpl();	
		
		//관리자 사업자 등록 승인			
		int tmpCidx = 0; 
		tmpCidx = Integer.parseInt(request.getParameter("idx"));		
		
		int row = 0;
		row = as.adminCmemChkOkMem(tmpCidx);
		row += as.adminCmemChkOkCmem(idx, tmpCidx);
		
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
