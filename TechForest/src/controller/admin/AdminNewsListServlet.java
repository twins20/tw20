package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.AdminServiceImpl;
import service.BoardVo;


@WebServlet("/AdminNewsListServlet")
public class AdminNewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AdminNewsListServlet() {
        super();      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminServiceImpl as = new AdminServiceImpl();	
		
		//관리자 뉴스관리 페이지 뉴스 리스트  
		ArrayList<BoardVo> alist = new  ArrayList<BoardVo>();
		 
		alist = as.adminBoardNewsList();
		request.setAttribute("alist", alist);
		
//		ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("alist");		
//		for(BoardVo vo : alist1){
//			
//			System.out.println("뉴스리스트");
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
//		}	
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminNewsList.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
