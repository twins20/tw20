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
import service.MemberVo;


@WebServlet("/AdminQnaConServlet")
public class AdminQnaConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminQnaConServlet() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();	
		int bIdx = 0;
		bIdx = Integer.parseInt(request.getParameter("bIdx"));	
//		int bIdx = 1;
		
		//관리자 고객센터 페이지 QNA 상세내용
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();	
		alist = as.adminBoardQnaCon(bIdx);
		request.setAttribute("alist", alist);	
		
//		ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("alist");
//		
//		for(BoardVo vo : alist1){
//			System.out.println("QNA 상세 내용");
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getCate());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getHit());	
//			System.out.println(vo.getGood());
//			System.out.println(vo.getBad());
//			System.out.println(vo.getObIdx());
//			System.out.println(vo.getRbIdx());
//			System.out.println(vo.getContents());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getModDate());			
//		}
				
		PageRedirect pr = new PageRedirect(false, "/admin/AdminQnaCon.jsp", request, response);			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
