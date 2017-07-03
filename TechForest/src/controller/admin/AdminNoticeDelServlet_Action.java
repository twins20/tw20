package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.AdminServiceImpl;


@WebServlet("/AdminNoticeDelServlet_Action")
public class AdminNoticeDelServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public AdminNoticeDelServlet_Action() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();
//		int bidx = Integer.parseInt(request.getParameter("bidx"));
			
		int bidx = 1;
		
		//관리자 뉴스관리 페이지 뉴스 삭제 	
		int row = as.adminBoardNoticeQnaDel(bidx);
				
		if (row != 0) {
	    	System.out.println("성공적으로 삭제 되었습니다.");
	    	PageRedirect pr = new PageRedirect(false, "/AdminNoticeListSevlet", request, response);
	    }else{ 
    		System.out.println("삭제에 실패 했습니다.");
    		PageRedirect pr = new PageRedirect(false, "/AdminNoticeListSevlet", request, response);
	    }	

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
