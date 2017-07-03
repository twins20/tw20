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


@WebServlet("/AdminImemInfoListServlet")
public class AdminImemInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminImemInfoListServlet() {
        super();
 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();
				
		//관리자 투자자 회원정보 페이지 회원리스트
		ArrayList<MemberVo> dlist = new ArrayList<MemberVo>();		
					
			dlist = as.adminlmemInfoList();
			request.setAttribute("dlist", dlist);		
			ArrayList<MemberVo> dlist1 = (ArrayList<MemberVo>) request.getAttribute("dlist");
			
			for(MemberVo mv : dlist1){
				System.out.println(mv.getIdx());
				System.out.println(mv.getId());
				System.out.println(mv.getName());
				System.out.println(mv.getStatus());
				System.out.println(mv.getMoney());	
			}
			PageRedirect pr = new PageRedirect(false, "/admin/AdminImemInfoList.jsp", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
