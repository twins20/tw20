package controller.boardFaq;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.AdminServiceImpl;
import service.BoardFaqServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class FaqReplayWrite_Action
 */
@WebServlet("/FaqReplayWrite_Action")
public class FaqReplayWrite_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqReplayWrite_Action() {
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
		if(session.getAttribute("idx") != null) {
		sess_idx = (Integer) session.getAttribute("idx");
		}
		
		
		String cate = null, title = null, contents = null;
				
		if(request.getParameter("cate") != null) {
			cate = request.getParameter("cate").trim();
		}
		if(request.getParameter("title") != null) {
			title = request.getParameter("title").trim();
		}
		if(request.getParameter("contents") != null) {
			contents = request.getParameter("contents").trim();
		}

		BoardVo inputBV = new BoardVo();
		inputBV.setIdx(sess_idx);
		inputBV.setCate(cate);
		inputBV.setTitle(title);
		inputBV.setContents(contents);
				
		int row = 0;
		
		BoardFaqServiceImpl bs = new BoardFaqServiceImpl();
		row = bs.boardFaqReplyWrite(inputBV);
		
		PageRedirect pr = new PageRedirect(true, "/FaqList.do", request, response);
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
