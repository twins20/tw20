package controller.boardNews;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardCommVo;
import service.BoardNewsServiceImpl;
import service.BoardQnaServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class NewsCommModServlet_Action
 */
@WebServlet("/NewsCommModServlet_Action")
public class NewsCommModServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsCommModServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int idx = 0, bIdx = 0, commidx = 0;
		String comments = null;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null ) idx = (Integer) session.getAttribute("idx");
		if(request.getParameter("bidx") != null) bIdx = Integer.parseInt(request.getParameter("bidx"));
		if(request.getParameter("commidx") != null) commidx = Integer.parseInt(request.getParameter("commidx").trim());
		if(request.getParameter("comments") != null) comments = request.getParameter("comments").trim();
		
		BoardNewsServiceImpl bs = new BoardNewsServiceImpl();

		BoardCommVo vc = new BoardCommVo();		
		vc.setCommIdx(commidx);
		vc.setComments(comments);
		
		int row = 0;
		
		row = bs.boardNewsCommWriteCntMod(vc);
				
		PageRedirect pr = new PageRedirect(true,"/NewsListServlet.do", request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
