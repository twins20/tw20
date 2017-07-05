package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.AdminServiceImpl;
import service.BoardVo;
import service.ProjectVo;


@WebServlet("/AdminNewsModServlet")
public class AdminNewsModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminNewsModServlet() {
        super();       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();
		
		int bIdx = 0;
		bIdx = Integer.parseInt(request.getParameter("bIdx"));	
//		int bidx = 1;
		
		//관리자 뉴스관리 페이지 뉴스 상세내용  
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
		alist = as.adminBoardNewsCon(bIdx, 10, 1);
		
		request.setAttribute("alist", alist);	
		
//		ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist");
//		
//		for(Map<String, Object> hashmap : alist1){
//			
//			BoardVo bvo = (BoardVo) hashmap.get("bvo");
//			System.out.println(bvo.getbIdx());
//			System.out.println(bvo.getIdx());
//			System.out.println(bvo.getpIdx());
//			System.out.println(bvo.getCate());
//			System.out.println(bvo.getTitle());
//			System.out.println(bvo.getHit());	
//			System.out.println(bvo.getGood());
//			System.out.println(bvo.getBad());
//			System.out.println(bvo.getObIdx());
//			System.out.println(bvo.getRbIdx());
//			System.out.println(bvo.getContents());
//			System.out.println(bvo.getInsDate());
//			System.out.println(bvo.getModDate());
//			
//			ProjectVo pvo = (ProjectVo) hashmap.get("pvo");
//			System.out.println(pvo.getpIdx());
//			System.out.println(pvo.getpName());
//			System.out.println(pvo.getPnFunds());
//			System.out.println(pvo.getpGrade());
//			System.out.println(pvo.getStatus());			
//			
//		}
		
		PageRedirect pr = new PageRedirect(true, "/AdminNewsMod.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
