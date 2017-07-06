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
 * Servlet implementation class NoticeConServlet
 */
@WebServlet("/NoticeConServlet")
public class NoticeConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	int bIdx = 0;
    	
		if(request.getParameter("bidx") != null) bIdx = Integer.parseInt(request.getParameter("bidx"));
    	
		BoardNoticeServiceImpl bs = new BoardNoticeServiceImpl(); 
    	ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
    	
		alist = bs.boardNoticeCon(bIdx);	
		request.setAttribute("alist", alist);
		
		ArrayList<BoardVo> alist2 = (ArrayList<BoardVo>) request.getAttribute("alist");		
		for(BoardVo vo : alist2) {
					
//			System.out.println(vo.getCate());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getContents());
//			System.out.println(vo.getHit());
//			System.out.println(vo.getInsDate());
//			
		}	
		
		bs.boardNoticeHit(bIdx);			
		
		PageRedirect pr = new PageRedirect(false,"/boardNotice/NoticeCon.jsp",request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
