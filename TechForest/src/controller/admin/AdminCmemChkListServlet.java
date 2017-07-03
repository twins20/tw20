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
import service.MemberVo;


@WebServlet("/AdminCmemChkListServlet")
public class AdminCmemChkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminCmemChkListServlet() {
        super();       
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();
		
		//관리자 사업자 등록 승인 리스트
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>();
		alist = as.adminCmemChkList();
		request.setAttribute("alist", alist);
		
//		ArrayList<MemberVo> alist1 = (ArrayList<MemberVo>) request.getAttribute("alist");
//		
//		for(MemberVo vo : alist1){
//			System.out.println("사업자 등록 승인 리스트");			
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getName());		
//			System.out.println(vo.getModDate());
//			System.out.println(vo.getStatus());
//		}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminCmemChkList.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
