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
import service.ProjectVo;


@WebServlet("/AdminProjChkListServlet")
public class AdminProjChkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminProjChkListServlet() {
        super();       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AdminServiceImpl as = new AdminServiceImpl();	
		
		//관리자 프로젝트 등록 승인 리스트 
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>();
				
			alist = as.adminIndexPProjectChkList();
			request.setAttribute("alist", alist);
			
//			ArrayList<ProjectVo> alist1 = (ArrayList<ProjectVo>) request.getAttribute("alist");
//			
//			for(ProjectVo vo : alist1){
//				System.out.println(vo.getpIdx());
//				System.out.println(vo.getpName());
//				System.out.println(vo.getInsDate());
//				System.out.println(vo.getStatus());			
//			}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminProjChkList.jsp", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
