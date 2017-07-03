package controller.boardQna;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class QnaListServlet
 */
@WebServlet("/QnaListServlet")
public class QnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		int idx = (Integer) null;
		if(session.getAttribute("idx") !=null) idx = (Integer) request.getAttribute("idx");
		
		
		int bidx = 0;
		if(request.getParameter("bidx") != null) bidx = Integer.parseInt(request.getParameter("bidx"));
		
		BoardQnaServiceImpl bs = new BoardQnaServiceImpl(); 
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		int listCnt = 1;
		int pageCnt = 1;
		list = bs.boardQnaList(idx, listCnt, pageCnt); 
		
		request.setAttribute("list", list);
		list = (ArrayList<BoardVo>) request.getAttribute("list");
		
		for(BoardVo vo : list){
			
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
	
		PageRedirect pr = new PageRedirect(false, "/boardQna/QnaList.jsp", request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
