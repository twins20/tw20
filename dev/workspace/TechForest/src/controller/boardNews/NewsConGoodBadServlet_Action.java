package controller.boardNews;

import java.io.IOException;
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
 * Servlet implementation class NewsConGoodBadServlet_Action
 */
@WebServlet("/NewsConGoodBadServlet_Action")
public class NewsConGoodBadServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsConGoodBadServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
		sess_idx = (Integer) session.getAttribute("idx");	
		}
		
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}

		String GoodBad = null;
		if(request.getParameter("goodbad") != null) {
			GoodBad = request.getParameter("goodbad");
		}
		
		BoardVo vo = new BoardVo();
		
		BoardNewsServiceImpl bs = new BoardNewsServiceImpl();	

		int row = 0;
		
		if(GoodBad.equals("up")){
			row = bs.boardNewsGood(bIdx);
			if(row == 1){
				PageRedirect pr = new PageRedirect(true, "/NewsCon.do?bIdx="+bIdx ,request ,response);
			}
		
		}else if(GoodBad.equals("down")){
			row = bs.boardNewsBad(bIdx);
			if(row == 1){
				PageRedirect pr = new PageRedirect(true, "/NewsCon.do?bIdx="+bIdx ,request ,response);
		}
		
	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
