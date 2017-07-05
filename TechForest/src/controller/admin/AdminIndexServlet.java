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
					
		alist =  as.adminIndexPMoneyChkList(10, 1);		
		request.setAttribute("alist", alist);
		
		//프로젝트 승인 대기 리스트
		ArrayList<ProjectVo> blist = new ArrayList<ProjectVo>();
		
		blist = as.adminIndexPProjectChkList(10, 1);
		request.setAttribute("blist", blist);
				
		//사업자 승인 대기 리스트
		ArrayList<MemberVo> clist = new ArrayList<MemberVo>();
		
		clist = as.adminIndexPCmemChkList(10, 1);
		request.setAttribute("clist", clist);	
		
		ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist"); 
		
//		for(Map<String, Object> hashmap : alist1){
//			
//			MemberVo mbv = (MemberVo) hashmap.get("mbv");
//			System.out.println(mbv.getIdx());
//			System.out.println(mbv.getName());		
//		
//			MoneyVo mnv = (MoneyVo) hashmap.get("mnv");
//			System.out.println(mnv.getChgMoney());
//			System.out.println(mnv.getInsDate());
//			System.out.println(mnv.getStatus());			
//		}
//					
//		ArrayList<ProjectVo> blist1 = (ArrayList<ProjectVo>) request.getAttribute("blist");
//		
//		for(ProjectVo vo : blist1){
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getpName());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getStatus());			
//		}
//
//		ArrayList<MemberVo> clist1 = (ArrayList<MemberVo>) request.getAttribute("clist");//		
//		for(MemberVo vo : clist1){
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getName());
//			System.out.println(vo.getCompany());
//			System.out.println(vo.getModDate());	
//		}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminIndex.jsp", request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
