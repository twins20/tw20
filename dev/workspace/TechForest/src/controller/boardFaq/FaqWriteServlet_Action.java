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
import service.BoardNoticeServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class FaqWriteServlet_Action
 */
@WebServlet("/FaqWriteServlet_Action")
public class FaqWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqWriteServlet_Action() {
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
		if(session.getAttribute("idx") != null){
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
	    
		request.setAttribute("idx", sess_idx);
		BoardFaqServiceImpl bs = new BoardFaqServiceImpl();
	    BoardVo vo = new BoardVo();
	    vo.setIdx(sess_idx);
	    vo.setCate(cate);
	    vo.setTitle(title);
	    vo.setContents(contents);
	    	    
	    int row = bs.boardFaqWrite(vo); 
	    PageRedirect pr = new PageRedirect(false, "/boardFaq/FaqList.jsp", request, response);
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
