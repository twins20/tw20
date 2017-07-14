package controller.boardQna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardQnaServiceImpl;
import service.BoardVo;
import service.ProjectVo;

/**
 * Servlet implementation class QnaConServlet
 */
@WebServlet("/QnaConServlet")
public class QnaConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaConServlet() {
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
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}

		BoardQnaServiceImpl bs = new BoardQnaServiceImpl(); 		
	
		BoardVo vo = bs.boardQnaCon(bIdx);
		request.setAttribute("vo", vo);
		
		bs.boardQnaHit(bIdx);


		PageRedirect pr = new PageRedirect(false, "/boardQna/QnaCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
