package controller.boardQna;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardNewsServiceImpl;
import service.BoardQnaServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class QnaWriteServlet_Action
 */
@WebServlet("/QnaWriteServlet_Action")
public class QnaWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaWriteServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	
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
	    int idx = 0;
		BoardQnaServiceImpl bs = new BoardQnaServiceImpl();
	    BoardVo vo = new BoardVo();
	    vo.setIdx(sess_idx);
	    vo.setCate(cate);
	    vo.setTitle(title);
	    vo.setContents(contents);
	    
	    int row = bs.boardQnaWrite(vo); 
	    
		PageRedirect pr = new PageRedirect(true, "/IMemberIndexP.do", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);


	}

}
