package controller.boardNotice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeModServlet
 */
@WebServlet("/NoticeModServlet")
public class NoticeModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeModServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//NOTICE 모듈화 
		/*
		int sess_idx = 0;
		int bIdx =0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null) {
		sess_idx = (Integer) session.getAttribute("idx");
		}

		if(request.getParameter("bidx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bidx").trim());
		}
		
		BoardNoticeServiceImpl bs = new BoardNoticeServiceImpl();	
		BoardVo vo = new BoardVo();
		
		vo = bs.boardNewsCon(bIdx);
		
		request.setAttribute("idx", sess_idx);
		request.setAttribute("vo", vo);
		PageRedirect pr = new PageRedirect(false,"/boardNotice/NoticeMod.jsp",request,response);	
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
