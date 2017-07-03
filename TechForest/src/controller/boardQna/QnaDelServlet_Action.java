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
 * Servlet implementation class QnaDelServlet_Action
 */
@WebServlet("/QnaDelServlet_Action")
public class QnaDelServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDelServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bidx = 0, idx = 0;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null) idx = (Integer) request.getAttribute("idx");
		if(request.getParameter("bidx") != null) bidx = Integer.parseInt(request.getParameter("bidx"));
		
		BoardQnaServiceImpl bs = new BoardQnaServiceImpl(); 

		bs.boardQnaDel(bidx); 
		
		PageRedirect pr = new PageRedirect(true,"/QnaListServlet.do",request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
				
	}

}
