package controller.boardFaq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardFaqServiceImpl;
import service.BoardNewsServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class FaqConServlet
 */
@WebServlet("/FaqConServlet")
public class FaqConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqConServlet() {
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
			
		BoardFaqServiceImpl bs = new BoardFaqServiceImpl();
		BoardVo vo = bs.boardFaqCon(bIdx);		

			 
		bs.boardFaqHit(bIdx);
		request.setAttribute("vo", vo);
		
		PageRedirect pr = new PageRedirect(false, "/boardFaq/FaqCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
