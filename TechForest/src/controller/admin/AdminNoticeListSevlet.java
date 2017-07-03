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


@WebServlet("/AdminNoticeListSevlet")
public class AdminNoticeListSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminNoticeListSevlet() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminServiceImpl as = new AdminServiceImpl();	
		
		//관리자 고객센터 페이지 전체 공지사항 리스트  
		 ArrayList<BoardVo> alist = new  ArrayList<BoardVo>();
		 
		alist = as.adminBoardNoticeList();
		request.setAttribute("alist", alist);
		
//		ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("alist");
//		
//		for(BoardVo vo : alist1){
//			
//			System.out.println("공지사항리스트");
//			System.out.println(vo.getrNum());
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getIdx());
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
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminNoticeList.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
