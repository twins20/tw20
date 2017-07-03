package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;


@WebServlet("/AdminQnaWriteServlet")
public class AdminQnaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminQnaWriteServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminQnaWrite.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
