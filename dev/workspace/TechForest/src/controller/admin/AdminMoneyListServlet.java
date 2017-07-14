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
import common.PagingQ;
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

		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}
		
		int ttCnt = 0, listCnt = 10, pageCnt = 1;
		if(request.getParameter("pageCnt") != null){
			pageCnt = Integer.parseInt(request.getParameter("pageCnt").trim(),10);			
		}
		
		//관리자 머니 충전 기록 리스트
		String pageList = null;
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();

		AdminServiceImpl as = new AdminServiceImpl();
		alist =  as.adminIndexPMoneyChkList(listCnt, pageCnt);	
		ttCnt = as.adminIndexPMoneyChkListTtCnt();
		pageList = new PagingQ().pagingList(listCnt, pageCnt, ttCnt);
		String[] tmpPageInfo = pageList.split(" ");
		
		request.setAttribute("alist", alist);
		request.setAttribute("pageList", pageList);
		request.setAttribute("startPage", tmpPageInfo[0]);
		request.setAttribute("pageCnt", tmpPageInfo[1]);
		request.setAttribute("endPage", tmpPageInfo[2]);

				
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
//			
//			System.out.println(hashmap.get("rNum"));
//		}
									
			PageRedirect pr = new PageRedirect(false, "/admin/AdminMoneyList.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
