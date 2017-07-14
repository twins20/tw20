package controller.boardQna;

import java.io.IOException;
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
 * Servlet implementation class QnaConGoodBadServlet_Action
 */
@WebServlet("/QnaConGoodBadServlet_Action")
public class QnaConGoodBadServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaConGoodBadServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//QNA 모듈화 
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

		String GoodBad = null;
		if(request.getParameter("goodbad") != null) {
			GoodBad = request.getParameter("goodbad");
		}
		
		BoardVo vo = new BoardVo();
		
		BoardNoticeServiceImpl bs = new BoardNoticeServiceImpl();	

		int row = 0;
		
		if(GoodBad.equals("up")){
			row = bs.boardNoticeBad(bIdx);
			if(row == 1){
				PageRedirect pr = new PageRedirect(true, "/NoticeCon.do?bIdx="+bIdx ,request ,response);
			}
		
		}else if(GoodBad.equals("down")){
			row = bs.boardNoticeGood(bIdx);
			if(row == 1){
				PageRedirect pr = new PageRedirect(true, "/NoticeCon.do?bIdx="+bIdx ,request ,response);
		}
		
	}
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
