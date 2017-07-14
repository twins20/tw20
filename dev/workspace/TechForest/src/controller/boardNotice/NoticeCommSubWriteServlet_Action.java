package controller.boardNotice;

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
import service.BoardNoticeServiceImpl;

/**
 * Servlet implementation class NoticeCommSubWriteServlet_Action
 */
@WebServlet("/NoticeCommSubWriteServlet_Action")
public class NoticeCommSubWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommSubWriteServlet_Action() {
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
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
		sess_idx = (Integer) session.getAttribute("idx");	
		}
				
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}		
		int commIdx = 0;
		if(request.getParameter("commIdx") != null) {
			commIdx = Integer.parseInt(request.getParameter("commIdx"));
		}
		String comments = null;
		
		if(request.getParameter("dcomments") != null) {
			comments = request.getParameter("dcomments").trim();  
		}
			
		BoardCommVo vc = new BoardCommVo();
		vc.setIdx(sess_idx);
		vc.setbIdx(bIdx);
		vc.setCommIdx(commIdx);	
		vc.setComments(comments);
		
		
		int row = 0;
		
		
		BoardNoticeServiceImpl bs = new BoardNoticeServiceImpl();
		row = bs.boardNoticeSubCommWriteTransaction(vc);
		
		PageRedirect pr = new PageRedirect(true, "/NoticeCon.do?bIdx="+bIdx+"&commIdx="+commIdx+"", request, response);
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
