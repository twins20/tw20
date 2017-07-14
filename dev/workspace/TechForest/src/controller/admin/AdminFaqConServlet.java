package controller.admin;

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
import service.AdminServiceImpl;
import service.BoardVo;
import service.ProjectVo;


@WebServlet("/AdminFaqConServlet")
public class AdminFaqConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminFaqConServlet() {
        super();       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}	
				
		int bIdx = 0;		
		bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);	
		
		//관리자 고객센터 페이지 FAQ 상세내용 
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		AdminServiceImpl as = new AdminServiceImpl();		
		alist = as.adminBoardFaqCon(bIdx);
		
		request.setAttribute("alist", alist);	
		
//		ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("alist");
//		
//		for(BoardVo vo : alist1){
//												
//			System.out.println("FAQ 상세내용");
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getIdx());
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
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminFaqCon.jsp", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
