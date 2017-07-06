package controller.boardFaq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardFaqServiceImpl;
import service.BoardNewsServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class FaqConServlet
 */
@WebServlet("/FaqConServlet")
public class FaqConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bidx = 0;
				
		if(request.getParameter("bidx") != null) bidx = Integer.parseInt(request.getParameter("bidx"));
			
		BoardFaqServiceImpl bs = new BoardFaqServiceImpl();
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		list = bs.boardFaqCon(bidx);		
		request.setAttribute("list", list);
		
//		ArrayList<BoardVo> list2 = (ArrayList<BoardVo>) request.getAttribute("list");
		for(BoardVo vo : list) {
			
//			System.out.println(vo.getCate());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getContents());
//			System.out.println(vo.getHit());
//			System.out.println(vo.getInsDate());
		
		}
	 
		bs.boardFaqHit(bidx);
		
		PageRedirect pr = new PageRedirect(false, "/boardFaq/FaqCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
