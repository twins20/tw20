package controller.boardFaq;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardCommVo;
import service.BoardFaqServiceImpl;
import service.BoardNewsServiceImpl;

/**
 * Servlet implementation class FaqCommModServlet_Action
 */
@WebServlet("/FaqCommModServlet_Action")
public class FaqCommModServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqCommModServlet_Action() {
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
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null ) {
		sess_idx = (Integer) session.getAttribute("idx");
		}
		int bIdx = 0;
		if(request.getParameter("bIdx") != null ) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		
		int commIdx = 0;		
		if(request.getParameter("commIdx") != null ) {
			commIdx = Integer.parseInt(request.getParameter("commIdx"));
		}
		
		String comments = null;
		if(request.getParameter("rcomments") != null ) {
			comments = request.getParameter("rcomments").trim();
		}

		BoardCommVo vc = new BoardCommVo();		
		vc.setbIdx(bIdx);
		vc.setCommIdx(commIdx);
		vc.setComments(comments);

		int row = 0;
		
		BoardFaqServiceImpl bs = new BoardFaqServiceImpl();
		row = bs.boardFaqCommWriteCntMod(vc);

		
		PageRedirect pr = new PageRedirect(true,"/FaqCon.do?bIdx="+bIdx+"&commIdx="+commIdx+"", request, response);		
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
