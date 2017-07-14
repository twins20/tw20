package controller.boardNotice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardNoticeServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class NoticeConServlet
 */
@WebServlet("/NoticeConServlet")
public class NoticeConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null) {
		sess_idx = (Integer) request.getAttribute("idx");
		}
    	
    	int bIdx = 0;
    	
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
    	
		BoardNoticeServiceImpl bs = new BoardNoticeServiceImpl(); 	
		BoardVo vo = bs.boardNoticeCon(bIdx);	

		bs.boardNoticeHit(bIdx);
		request.setAttribute("vo", vo);
		
		PageRedirect pr = new PageRedirect(false,"/boardNotice/NoticeCon.jsp",request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
