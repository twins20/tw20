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
import service.BoardVo;

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
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
		sess_idx = (Integer) session.getAttribute("idx");	
		}
				
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx").trim());
		}		
		
		String comments = null;
		
		if(request.getParameter("comments") != null) {
			comments = request.getParameter("comments").trim();  
		}

		request.setAttribute("idx", sess_idx);
		
		BoardNewsServiceImpl bs = new BoardNewsServiceImpl();
		BoardCommVo vc = new BoardCommVo();
		vc.setIdx(sess_idx);
		vc.setbIdx(bIdx);
		vc.setComments(comments);

		int row = 0;
		
		row = bs.boardNewsCommWrite(vc);
		
		PageRedirect pr = new PageRedirect(true, "/NewsCon.do?bIdx="+bIdx+"", request, response);	
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
