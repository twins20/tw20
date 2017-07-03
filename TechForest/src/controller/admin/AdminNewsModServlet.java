package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int bidx = Integer.parseInt(request.getParameter("bidx"));	
//		int bidx = 1;
		
		//관리자 뉴스관리 페이지 뉴스 상세내용  
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
		alist = as.adminBoardNewsCon(bidx);
		
		request.setAttribute("alist", alist);	
		ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist");
		
		for(Map<String, Object> hashmap : alist1){
			
			BoardVo vo = (BoardVo) hashmap.get("vo");
			ProjectVo pv = (ProjectVo) hashmap.get("pv");
						
			System.out.println("뉴스 상세 내용");
			System.out.println(vo.getbIdx());
			System.out.println(vo.getIdx());
			System.out.println(vo.getpIdx());
			System.out.println(vo.getCate());
			System.out.println(vo.getTitle());
			System.out.println(vo.getHit());	
			System.out.println(vo.getGood());
			System.out.println(vo.getBad());
			System.out.println(vo.getObIdx());
			System.out.println(vo.getRbIdx());
			System.out.println(vo.getContents());
			System.out.println(vo.getInsDate());
			System.out.println(vo.getModDate());
			
			System.out.println(pv.getpIdx());
			System.out.println(pv.getpName());
			System.out.println(pv.getPnFunds());
			System.out.println(pv.getpGrade());
			System.out.println(pv.getStatus());			
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
