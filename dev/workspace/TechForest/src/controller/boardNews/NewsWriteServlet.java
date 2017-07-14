package controller.boardNews;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;

/**
 * Servlet implementation class NewsWriteServlet
 */
@WebServlet("/NewsWriteServlet")
public class NewsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//NEWS 모듈화 
		/*
		int sess_idx = 0;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null ) {
		sess_idx = (Integer) request.getAttribute("idx");
		}
		
		request.setAttribute("idx",sess_idx);
		PageRedirect pr = new PageRedirect(false, "/boardNews/NewsWrite.jsp", request, response);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
