package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.AdminServiceImpl;


@WebServlet("/AdminFaqDelServlet_Action")
public class AdminFaqDelServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminFaqDelServlet_Action() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AdminServiceImpl as = new AdminServiceImpl();
		
		int bIdx = 0;
		bIdx = Integer.parseInt(request.getParameter("bIdx"));		
//		int bIdx = 1;
		
		//관리자 고객센터 페이지 FAQ 삭제  
		int row = as.adminBoardFaqDel(bIdx);
				
//		if (row != 0) {
//	    	System.out.println("성공적으로 삭제 되었습니다.");
//	    	
//	    }else{ 
//    		System.out.println("삭제에 실패 했습니다.");
//    		
//	    }		
		
		PageRedirect pr = new PageRedirect(true, "/AdminFaqList.do", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
