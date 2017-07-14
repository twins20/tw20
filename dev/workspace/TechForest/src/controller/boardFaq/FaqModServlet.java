package controller.boardFaq;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardFaqServiceImpl;
import service.BoardQnaServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class FaqModServlet
 */
@WebServlet("/FaqModServlet")
public class FaqModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqModServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//FAQ 모듈화 
		/*
		int sess_idx = 0;
		int bIdx =0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null) {
		sess_idx = (Integer) session.getAttribute("idx");
		}

		if(request.getParameter("bidx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bidx").trim());
		}
		
		BoardFaqServiceImpl bs = new BoardFaqServiceImpl();	
		BoardVo vo = new BoardVo();
		
		vo = bs.boardFaqCon(bIdx);
		
		request.setAttribute("idx", sess_idx);
		request.setAttribute("vo", vo);
		PageRedirect pr = new PageRedirect(false,"/boardFaq/FaqMod.jsp",request,response);	
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
