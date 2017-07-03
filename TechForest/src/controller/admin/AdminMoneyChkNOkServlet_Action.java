package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.AdminServiceImpl;


@WebServlet("/AdminMoneyChkNOkServlet_Action")
public class AdminMoneyChkNOkServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AdminMoneyChkNOkServlet_Action() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();
		
//		int midx = Integer.parseInt(request.getParameter("midx"));
		int midx = 1;
		
		//관리자 머니 충전 거부
		
		int row2 = as.adminMoneyModNOk(midx);
		
		if(row2 != 0){
			System.out.println("관리자에 의해 승인이 거부 되었습니다.");		
		}else{
			System.out.println("승인 거부 실패");
		}
		
//		PageRedirect pr = new PageRedirect(false, "/admin/AdminMoneyList.jsp", request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
