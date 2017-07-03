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
import service.FundVo;
import service.MemberVo;
import service.MoneyVo;
import service.ProjectVo;


@WebServlet("/AdminImemInfoConServlet")
public class AdminImemInfoConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminImemInfoConServlet() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();
		int idx = 0;
		idx = Integer.parseInt(request.getParameter("idx"));	
		
		//관리자 투자자 회원 정보 페이지 회원별 상세 정보
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>();		
			alist = as.adminlmemInfoCon(idx);
			request.setAttribute("alist", alist);
	
		//관리자 투자자 회원정보 페이지 회원별 충전 기록
		ArrayList<MoneyVo> blist = new ArrayList<MoneyVo>();		
			blist = as.adminImemInfoMoneyHis(idx);
			request.setAttribute("blist", blist);
			
		//관리자 투자자 회원정보 페이지 프로젝트 참가 기록 리스트
		ArrayList<Map<String, Object>> clist = new ArrayList<Map<String, Object>>();		
			clist =  as.adminImemInfoProjHis(idx);		
			request.setAttribute("clist", clist);		
		
		//관리자 투자자 회원정보 페이지 QNA 참가기록 리스트		
		ArrayList<Map<String, Object>> dlist = new ArrayList<Map<String, Object>>();				
			dlist =  as.adminImemInfoQnaHis(idx);		
			request.setAttribute("dlist", dlist);	
				
//		ArrayList<MemberVo> alist1 = (ArrayList<MemberVo>) request.getAttribute("alist");
//		
//		for(MemberVo vo : alist1){
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getId());
//			System.out.println(vo.getName());
//			System.out.println(vo.getPhone());
//			System.out.println(vo.getAddr());	
//		}
//
//		ArrayList<MoneyVo> blist1 = (ArrayList<MoneyVo>) request.getAttribute("blist");
//		
//		for(MoneyVo vo : blist1){
//			System.out.println(vo.getmIdx());
//			System.out.println(vo.getChgMoney());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getStatus());					
//		}
//
//		ArrayList<Map<String, Object>> clist1 = (ArrayList<Map<String, Object>>) request.getAttribute("clist"); 
//		
//		for(Map<String, Object> hashmap : clist1){
//			
//			ProjectVo pvo = (ProjectVo) hashmap.get("pvo");
//			System.out.println(pvo.getpIdx());
//			System.out.println(pvo.getpName());				
//			System.out.println(pvo.getPnFunds());
//			System.out.println(pvo.getPtFunds());	
//				
//			FundVo fvo = (FundVo) hashmap.get("fvo");	
//			System.out.println(fvo.getInFunds());
//			System.out.println(fvo.getInsDate());
//			
//		}	
//		
//		ArrayList<Map<String, Object>> dlist1 = (ArrayList<Map<String, Object>>) request.getAttribute("dlist"); 
//		
//		for(Map<String, Object> hashmap : dlist1){
//			
//			MemberVo mvo = (MemberVo) hashmap.get("mvo");
//			System.out.println(mvo.getIdx());
//			System.out.println(mvo.getInsDate());
//			
//			BoardVo bvo = (BoardVo) hashmap.get("bvo");	
//			System.out.println(bvo.getContents());
//			System.out.println(bvo.getbDepth());
//			
//		}	
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminImemInfoCon.jsp", request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
