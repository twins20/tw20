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


@WebServlet("/AdminCmemChkConServlet")
public class AdminCmemChkConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminCmemChkConServlet() {
        super();    
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int idx = Integer.parseInt(request.getParameter("idx"));					
		PageRedirect pr = new PageRedirect(false, "/admin/AdminCmemInfoCon.jsp", request, response);				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
