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
		
		int bIdx = 0;
		String cate = null;
		
		if(request.getParameter("bidx") != null) bIdx = Integer.parseInt(request.getParameter("bidx"));
		if(request.getParameter("cate") != null) cate = request.getParameter("cate");
				
		BoardNewsServiceImpl bs = new BoardNewsServiceImpl(); 
		ArrayList<BoardVo> list = bs.boardNewsListCate(cate,10,1); 
		
		request.setAttribute("list", list);		
		
		ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("list");			
		for(BoardVo vo : alist1){
			
//			System.out.println(vo.getrNum());
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getCate());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getHit());
//			System.out.println(vo.getGood());
//			System.out.println(vo.getBad());
//			System.out.println(vo.getCommCnt());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getModDate());
//			System.out.println(vo.getExtColumn());

		}	
		
		PageRedirect pr = new PageRedirect(false,"/boardQna/QnaList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
