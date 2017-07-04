package controller.boardNews;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardNewsServiceImpl;

/**
 * Servlet implementation class NewsCommDelServlet_Action
 */
@WebServlet("/NewsCommDelServlet_Action")
public class NewsCommDelServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsCommDelServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = 0;
		HttpSession session =request.getSession();
		if(session.getAttribute("idx") !=null) idx = (Integer) session.getAttribute("idx");
		
		int bIdx = 0;
		
		if(request.getParameter("bidx") != null) bIdx = Integer.parseInt(request.getParameter("bidx"));
		
		BoardNewsServiceImpl bs = new BoardNewsServiceImpl();				
		bs.boardNewsCommDel(bIdx); 		
		
		PageRedirect pr = new PageRedirect(true,"/NewsListServlet.do",request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
