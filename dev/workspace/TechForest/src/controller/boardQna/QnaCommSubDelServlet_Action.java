package controller.boardQna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QnaCommSubDelServlet_Action
 */
@WebServlet("/QnaCommSubDelServlet_Action")
public class QnaCommSubDelServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaCommSubDelServlet_Action() {
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
		HttpSession session=request.getSession();
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
		
		BoardQnaServiceImpl bs = new BoardQnaServiceImpl();
		
		bs.boardQnaCommDel(commIdx);
		
		PageRedirect pr = new PageRedirect(true, "/QnaCon.do?bIdx="+bIdx+"&commIdx="+commIdx+"", request, response);
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
