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

/**
 * Servlet implementation class NewsCommWriteServlet_Action
 */
@WebServlet("/NewsCommWriteServlet_Action")
public class NewsCommWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsCommWriteServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		BoardNewsServiceImpl br = new BoardNewsServiceImpl();				
		HttpSession session = request.getSession();
		
		int bidx = (Integer) null;
		if(session.getAttribute("bidx") != null) bidx = (Integer) session.getAttribute("bidx");
		
		int idx = (Integer) null; 
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");		
		
		String comments = null;
		if(session.getAttribute("comments") != null) comments = request.getParameter("commnets").trim();
		
		BoardCommVo vc = new BoardCommVo();
		
		vc.setIdx(idx);
		vc.setbIdx(bidx);
		vc.setComments(comments);
		
		int row = 0;
		row = br.boardNewsCommWrite(vc);
			
		PageRedirect pr = new PageRedirect(true,"/NewsConServlet.do",request, response);	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
