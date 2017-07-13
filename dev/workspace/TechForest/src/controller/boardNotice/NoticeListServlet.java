package controller.boardNotice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardNoticeServiceImpl;
import service.BoardVo;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/NoticeListServlet")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
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
		if(request.getParameter("cate") != null) cate = request.getParameter("cate");

    	BoardNoticeServiceImpl bs = new BoardNoticeServiceImpl(); 
    	ArrayList<BoardVo> list = new ArrayList<BoardVo>();

    	list = bs.boardNoticeList(bidx, 10, 1);
    	
    	request.setAttribute("list", list);		
		
		ArrayList<BoardVo> list2 = (ArrayList<BoardVo>) request.getAttribute("list");		
		for(BoardVo vo : list2){	
			
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getHit());
		
		}
		
		ArrayList<BoardVo> blist = new ArrayList<BoardVo>();
		
		blist = bs.boardNoticeListCate(cate, 10, 1);		
		request.setAttribute("blist", blist);
		
		ArrayList<BoardVo> list3 = (ArrayList<BoardVo>) request.getAttribute("blist");
		for(BoardVo vo : list3){
			
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getHit());
		
		}

		
		PageRedirect pr = new PageRedirect(false, "/boardNotice/NoticeList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}