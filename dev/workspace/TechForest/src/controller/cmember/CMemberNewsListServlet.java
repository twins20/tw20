package controller.cmember;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberNewsListServlet
 */
@WebServlet("/CMemberNewsListServlet")
public class CMemberNewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberNewsListServlet() {
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
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int ttCnt = 0, listCnt = 10, pageCnt = 1;
		
		if(request.getParameter("pageCnt") != null){
			pageCnt = Integer.parseInt(request.getParameter("pageCnt").trim(),10);
		}
				
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		String pageList = null;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
			
		ttCnt = cs.cMemNewsListTtCnt(sess_idx);
		pageList = new PagingQ().pagingList(listCnt, pageCnt, ttCnt);
		String[] tmpPageInfo = pageList.split(" ");
				
		alist = cs.cMemNewsList(sess_idx, listCnt, pageCnt);
		
		request.setAttribute("alist", alist);
		request.setAttribute("startPage", tmpPageInfo[0]);
		request.setAttribute("pageCnt", tmpPageInfo[1]);
		request.setAttribute("endPage", tmpPageInfo[2]);
		
//		alist = (ArrayList<BoardVo>) request.getAttribute("alist"); 
//		
//		System.out.println("total count " + ttCnt);
//		System.out.println("page list " + pageList);
//		System.out.println("start page " + tmpPageInfo[0]);
//		System.out.println("now page " + tmpPageInfo[1]);
//		System.out.println("end page " + tmpPageInfo[2]);
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberNewsList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
