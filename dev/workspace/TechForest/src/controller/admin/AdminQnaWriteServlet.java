package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.AdminServiceImpl;
import service.BoardVo;


@WebServlet("/AdminQnaWriteServlet")
public class AdminQnaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminQnaWriteServlet() {
        super();       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}	
		
		int bIdx = 0;
		if(Integer.parseInt(request.getParameter("bIdx")) != 0){
			bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
		}			
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();	
		
		AdminServiceImpl as = new AdminServiceImpl();	
		alist = as.adminBoardQnaCon(bIdx);		
		request.setAttribute("alist", alist);	
				
		PageRedirect pr = new PageRedirect(false, "/admin/AdminQnaWrite.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
