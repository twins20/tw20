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
import service.MemberVo;
import service.MoneyVo;


@WebServlet("/AdminMoneyListServlet")
public class AdminMoneyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminMoneyListServlet() {
        super();    
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminServiceImpl as = new AdminServiceImpl();
		
		//관리자 머니 충전 기록 리스트
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
		
		alist =  as.adminIndexPMoneyChkList(10, 1);		
		request.setAttribute("alist", alist);
				
//		ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist"); 
//		
//		for(Map<String, Object> hashmap : alist1){
//			
//			MemberVo mbv = (MemberVo) hashmap.get("mbv");						
//			System.out.println(mbv.getIdx());
//			System.out.println(mbv.getName());
//			System.out.println(mbv.getNick());
//			
//			MoneyVo mnv = (MoneyVo) hashmap.get("mnv");	
//			System.out.println(mnv.getmIdx());
//			System.out.println(mnv.getChgMoney());
//			System.out.println(mnv.getInsDate());
//			System.out.println(mnv.getStatus());			
//		}
									
			PageRedirect pr = new PageRedirect(false, "/admin/AdminMoneyList.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
