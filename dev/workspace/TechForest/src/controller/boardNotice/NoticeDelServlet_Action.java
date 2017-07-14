package controller.boardNotice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardNoticeServiceImpl;
import service.BoardQnaServiceImpl;

/**
 * Servlet implementation class NoticeDelServlet_Action
 */
@WebServlet("/NoticeDelServlet_Action")
public class NoticeDelServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDelServlet_Action() {
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
		if(session.getAttribute("idx") !=null) {
		sess_idx = (Integer) request.getAttribute("idx");
		}
		
		int bIdx = 0;
		if(request.getParameter("bidx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bidx"));
		}
		
		BoardNoticeServiceImpl bs = new BoardNoticeServiceImpl(); 

		bs.boardNoticeDel(bIdx); 
		
		PageRedirect pr = new PageRedirect(true,"/NoticeList.do",request, response);
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
