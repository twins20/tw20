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
		// TODO Auto-generated method stub
		
	    BoardQnaServiceImpl bs = new BoardQnaServiceImpl();
	   	
		int idx = 2;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		String cate = null;
		if(request.getParameter("cate") != null) cate = request.getParameter("cate").trim();  
		
	    String title = null;
		if(request.getParameter("title") != null) title = request.getParameter("title").trim(); 
	    
	    String contents = null;
		if(request.getParameter("contents") != null) contents = request.getParameter("contents").trim(); 
	    
	    String extcolumn = null;
		if(request.getParameter("extcolumn") != null) extcolumn = request.getParameter("extcolumn").trim(); 
	    
	    BoardVo vo = new BoardVo();
	    
	    vo.setIdx(idx);
	    vo.setCate(cate);
	    vo.setTitle(title);
	    vo.setContents(contents);
//	    vo.setExtColumn(extcolumn);
	    
	    int row = 0;
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
