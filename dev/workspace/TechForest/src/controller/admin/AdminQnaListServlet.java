package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import common.PagingQ;
import service.AdminServiceImpl;
import service.BoardVo;


@WebServlet("/AdminQnaListServlet")
public class AdminQnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminQnaListServlet() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}
			
		int ttCnt = 0, listCnt = 10, pageCnt = 1;
		if(request.getParameter("pageCnt") != null){
			pageCnt = Integer.parseInt(request.getParameter("pageCnt").trim(),10);			
		}
		
		//관리자 고객센터 페이지 QNA리스트 
		String pageList = null;
		ArrayList<BoardVo> alist = new  ArrayList<BoardVo>();
		 
		AdminServiceImpl as = new AdminServiceImpl();
		alist =  as.adminBoardQnaList(listCnt, pageCnt);	
		ttCnt = as.adminBoardQnaListTtCnt();
		pageList = new PagingQ().pagingList(listCnt, pageCnt, ttCnt);
		String[] tmpPageInfo = pageList.split(" ");
		
		request.setAttribute("alist", alist);
		request.setAttribute("pageList", pageList);
		request.setAttribute("startPage", tmpPageInfo[0]);
		request.setAttribute("pageCnt", tmpPageInfo[1]);
		request.setAttribute("endPage", tmpPageInfo[2]);

		
//		ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("alist");
//		
//		for(BoardVo vo : alist1){
//			
//			System.out.println("QNA리스트");
//			System.out.println(vo.getrNum());
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getCate());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getHit());
//			System.out.println(vo.getGood());
//			System.out.println(vo.getBad());
//			System.out.println(vo.getCommCnt());
//			System.out.println(vo.getObIdx());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getModDate());	
//			System.out.println(vo.getViewStat());
//		}
		
	 PageRedirect pr = new PageRedirect(false, "/admin/AdminQnaList.jsp", request, response);		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
