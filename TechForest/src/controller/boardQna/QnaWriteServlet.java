package controller.boardQna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardQnaServiceImpl;


/**
 * Servlet implementation class QnaWriteServlet
 */
@WebServlet("/QnaWriteServlet")
public class QnaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int idx = (Integer) null;
		if(session.getAttribute("idx") !=null ) idx = (Integer) request.getAttribute("idx");
		
		
		PageRedirect pr = new PageRedirect(false, "/boardQna/QnaWrite.jsp", request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
