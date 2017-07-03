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
	   	
		int idx = 0, pIdx = 0;
		String cate = null, title = null, contents = null;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		if(request.getParameter("cate") != null) cate = request.getParameter("cate").trim();  
		if(request.getParameter("title") != null) title = request.getParameter("title").trim(); 
		if(request.getParameter("contents") != null) contents = request.getParameter("contents").trim(); 
		if(request.getParameter("pidx") != null) pIdx = Integer.parseInt(request.getParameter("pidx").trim()); 
	    
	    BoardVo vo = new BoardVo();
	    
	    vo.setIdx(idx);
	    vo.setCate(cate);
	    vo.setTitle(title);
	    vo.setContents(contents);
	    vo.setpIdx(pIdx);
	    
	    int row = 0;
	    
	    BoardQnaServiceImpl bs = new BoardQnaServiceImpl();
	    row = bs.boardQnaWrite(vo); 

//	    System.out.println(row);
	    
	    PageRedirect pr = new PageRedirect(true, "/NewsConServlet.do", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);


	}

}
