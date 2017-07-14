package controller.boardNotice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardNewsServiceImpl;
import service.BoardNoticeServiceImpl;

/**
 * Servlet implementation class NoticeCommDelServlet_Action
 */
@WebServlet("/NoticeCommDelServlet_Action")
public class NoticeCommDelServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommDelServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//NOTICE 모듈화 
		/*
		int sess_idx = 0;
		HttpSession session =request.getSession();
		if(session.getAttribute("idx") != null) {
		sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int commIdx = 0;
		
		if(request.getParameter("commIdx") != null) {
			commIdx = Integer.parseInt(request.getParameter("commIdx"));
		}
		
		int bIdx = 0;
		
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		
		BoardNoticeServiceImpl bs = new BoardNoticeServiceImpl();				
		bs.boardNoticeCommDel(commIdx); 	
								
		PageRedirect pr = new PageRedirect(true, "/NoticeCon.do?bIdx="+bIdx+"", request, response);
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
