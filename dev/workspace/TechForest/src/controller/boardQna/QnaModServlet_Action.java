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
 * Servlet implementation class QnaModServlet_Action
 */
@WebServlet("/QnaModServlet_Action")
public class QnaModServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaModServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		
		int sess_idx = 0;
		int bIdx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = (Integer) session.getAttribute("idx");
		}	
		
		String Title = null, Contents = null;
		
		if(request.getParameter("bidx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bidx").trim());
		}
		if(request.getParameter("title") != null) {
			Title = request.getParameter("title").trim();
		}
		if(request.getParameter("contents") != null) {
			Contents = request.getParameter("contents").trim();
		}
				
		BoardQnaServiceImpl bs = new BoardQnaServiceImpl();	
		BoardVo vo = new BoardVo();

		vo.setTitle(Title);
		vo.setContents(Contents);	
		vo.setbIdx(bIdx);		
			
		int row = 0; 
		
		row = bs.boardQnaMod(vo);

		PageRedirect pr = new PageRedirect(true,"/QnaList.do",request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	
			doGet(request, response);
	
	}

}
