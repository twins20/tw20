package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;

import service.AdminServiceImpl;
import service.MemberVo;
import service.MoneyVo;
import service.ProjectServiceImpl;
import service.ProjectVo;


@WebServlet("/AdminIndexServlet")
public class AdminIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AdminIndexServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();	
		
		//회원 충전 대기 리스트
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
					
		alist =  as.adminIndexPMoneyChkList();		
		request.setAttribute("alist", alist);
				
		ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist"); 
		
		for(Map<String, Object> hashmap : alist1){
			
			MemberVo mv = (MemberVo) hashmap.get("mv");
			MoneyVo mv1 = (MoneyVo) hashmap.get("mv1");
			
			System.out.println("test");
			System.out.println(mv.getIdx());
			System.out.println(mv.getName());
			System.out.println(mv1.getChgMoney());
			System.out.println(mv1.getInsDate());
			System.out.println(mv1.getStatus());			
		}
				
			
		//프로젝트 승인 대기 리스트
		ArrayList<ProjectVo> blist = new ArrayList<ProjectVo>();
		
		blist = as.adminIndexPProjectChkList();
		request.setAttribute("blist", blist);		
		ArrayList<ProjectVo> blist1 = (ArrayList<ProjectVo>) request.getAttribute("blist");
		
		for(ProjectVo pv : blist1){
			System.out.println(pv.getpIdx());
			System.out.println(pv.getpName());
			System.out.println(pv.getInsDate());
			System.out.println(pv.getStatus());			
		}
		
		//사업자 승인 대기 리스트
		ArrayList<MemberVo> clist = new ArrayList<MemberVo>();
		
		clist = as.adminIndexPCmemChkList();
		request.setAttribute("clist", clist);		
		ArrayList<MemberVo> clist1 = (ArrayList<MemberVo>) request.getAttribute("clist");
		
		for(MemberVo mv : clist1){
			System.out.println(mv.getIdx());
			System.out.println(mv.getName());
			System.out.println(mv.getCompany());
			System.out.println(mv.getModDate());	
		}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminIndex.jsp", request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
