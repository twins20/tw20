package controller.boardNews;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardCommVo;
import service.BoardNewsServiceImpl;
import service.BoardVo;
import service.ProjectVo;

/**
 * Servlet implementation class NewsConServlet
 */
@WebServlet("/NewsConServlet")
public class NewsConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsConServlet() {
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
		
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
		bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		
		int commIdx = 0;
		
		if(request.getParameter("commIdx") != null) {
			commIdx = Integer.parseInt(request.getParameter("commIdx"));
		}
		
		BoardNewsServiceImpl bs = new BoardNewsServiceImpl();	
	
		BoardVo vo = bs.boardNewsCon(bIdx);		
		request.setAttribute("vo", vo);				
		request.setAttribute("commIdx", commIdx);
		
		ArrayList<Map<String, Object>> clist = new ArrayList<Map<String, Object>>();		
		clist = bs.boardNewsCommList(bIdx, 10, 1);
		request.setAttribute("clist", clist);
		

		bs.boardNewsHit(bIdx);
		

		ArrayList<Map<String, Object>> sclist = new ArrayList<Map<String, Object>>();		
		sclist = bs.BoardNewsSubCommList(commIdx, bIdx, 10, 1);		
		request.setAttribute("sclist", sclist);	
		request.setAttribute("bIdx", bIdx);
	
	
		PageRedirect pr = new PageRedirect(false, "/boardNews/NewsCon.jsp?" ,request ,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
