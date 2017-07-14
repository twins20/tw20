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


@WebServlet("/AdminMemoSendServlet")
public class AdminMemoSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminMemoSendServlet() {
        super();      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}
		
		int param_idx = 0;
		if(request.getParameter("param_idx") != null){
			param_idx = Integer.parseInt(request.getParameter("param_idx").trim(),10);
		}
		
		request.setAttribute("sess_idx", sess_idx);
		request.setAttribute("param_idx", param_idx);
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminMemoSend.jsp", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
