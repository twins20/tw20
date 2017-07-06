package controller.boardFaq;

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
import service.BoardFaqServiceImpl;
import service.BoardQnaServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class FaqListServlet
 */
@WebServlet("/FaqListServlet")
public class FaqListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bidx = 0;
		String cate = null;
		
		if(request.getParameter("bidx") != null) bidx = Integer.parseInt(request.getParameter("bidx"));
		if(request.getParameter("cate") !=null)	 cate = request.getParameter("cate");
		
		BoardFaqServiceImpl bs = new BoardFaqServiceImpl();
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		alist = bs.boardFaqList(10, 1);
		
		request.setAttribute("list", alist);
	
//		ArrayList<BoardVo> list2 = (ArrayList<BoardVo>) request.getAttribute("list");
//		for(BoardVo vo : list2){
			
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getCate());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getHit());
//			System.out.println(vo.getInsDate());
		
//		}
		
		alist = bs.boardListCate(cate, 10, 1);
		
		request.setAttribute("list", alist);	
		
		ArrayList<BoardVo> blist2 = (ArrayList<BoardVo>) request.getAttribute("list");
		for(BoardVo vo : blist2) {
			
//			System.out.println(vo.getrNum());
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getCate());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getHit());
//			System.out.println(vo.getInsDate());
			
		}

		PageRedirect pr = new PageRedirect(false, "boardFaq/FaqList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
