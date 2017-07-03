package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;


@WebServlet("/AdminFaqWriteServlet")
public class AdminFaqWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminFaqWriteServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int idx = 0;
//		HttpSession session = request.getSession();
//		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
//		
//		ProjectVo vo = new ProjectVo();
//	
//		AdminServiceImpl as = new AdminServiceImpl();
//		vo = as.cMemNewsWriteProjNow(idx);
//		
//		request.setAttribute("vo", vo);
				
//		vo = (ProjectVo) request.getAttribute("vo"); 
//	
//		System.out.println(vo.getpIdx());
//		System.out.println(vo.getpName());
//		System.out.println(vo.getpCate());
				
		PageRedirect pr = new PageRedirect(false, "/admin/AdminFaqWrite.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
