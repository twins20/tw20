package controller.boardNews;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardNewsServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class NewsListServlet
 */
@WebServlet("/NewsListServlet")
public class NewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sess_idx = 0;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
		sess_idx = (Integer) session.getAttribute("idx");	
		}
		String cate = null;
		
		if(request.getParameter("cate") != null) {
			cate = request.getParameter("cate");
		}
				
		BoardNewsServiceImpl bs = new BoardNewsServiceImpl(); 
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		alist = bs.boardNewsListCate(cate,10,1); 
		
		request.setAttribute("alist", alist);	

		
		PageRedirect pr = new PageRedirect(false,"/boardNews/NewsList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
