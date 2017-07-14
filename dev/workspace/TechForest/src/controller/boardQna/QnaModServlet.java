package controller.boardQna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardQnaServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class QnaModServlet
 */
@WebServlet("/QnaModServlet")
public class QnaModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sess_idx = 0;
		int bIdx =0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null) {
		sess_idx = (Integer) session.getAttribute("idx");
		}

		if(request.getParameter("bidx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bidx").trim());
		}
		
		BoardQnaServiceImpl bs = new BoardQnaServiceImpl();	
		BoardVo vo = new BoardVo();
		
		vo = bs.boardQnaCon(bIdx);
		
		request.setAttribute("sess_idx", sess_idx);
		request.setAttribute("vo", vo);
		PageRedirect pr = new PageRedirect(false,"/boardQna/QnaMod.jsp",request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
