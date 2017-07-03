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
		int idx = Integer.parseInt(request.getParameter("idx"));	

		
		//관리자 투자자 회원 정보 페이지 회원별 상세 정보
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>();		
		
			alist = as.adminlmemInfoCon(idx);
			request.setAttribute("alist", alist);		
			ArrayList<MemberVo> alist1 = (ArrayList<MemberVo>) request.getAttribute("alist");
			
			for(MemberVo mv : alist1){
				System.out.println(mv.getIdx());
				System.out.println(mv.getId());
				System.out.println(mv.getName());
				System.out.println(mv.getPhone());
				System.out.println(mv.getAddr());	
			}
		
		//관리자 투자자 회원정보 페이지 회원별 충전 기록
		ArrayList<MoneyVo> flist = new ArrayList<MoneyVo>();
		
			flist = as.adminImemInfoMoneyHis(idx);
			request.setAttribute("flist", flist);
			ArrayList<MoneyVo> flist1 = (ArrayList<MoneyVo>) request.getAttribute("flist");
			
			for(MoneyVo mv : flist1){
				System.out.println(mv.getmIdx());
				System.out.println(mv.getChgMoney());
				System.out.println(mv.getInsDate());
				System.out.println(mv.getStatus());					
			}
			
		//관리자 투자자 회원정보 페이지 프로젝트 참가 기록 리스트
		ArrayList<Map<String, Object>> glist = new ArrayList<Map<String, Object>>();
		
		glist =  as.adminImemInfoProjHis(idx);		
		request.setAttribute("glist", glist);				
		ArrayList<Map<String, Object>> glist1 = (ArrayList<Map<String, Object>>) request.getAttribute("glist"); 
		
		for(Map<String, Object> hashmap : glist1){
			
			ProjectVo pv = (ProjectVo) hashmap.get("pv");
			FundVo fv = (FundVo) hashmap.get("fv");		
			
			System.out.println(pv.getpIdx());
			System.out.println(pv.getpName());
			System.out.println(fv.getInFunds());
			System.out.println(fv.getInsDate());
			System.out.println(pv.getPnFunds());
			System.out.println(pv.getPtFunds());			
		}	
		
		//관리자 투자자 회원정보 페이지 QNA 참가기록 리스트		
		ArrayList<Map<String, Object>> hlist = new ArrayList<Map<String, Object>>();
				System.out.println("qna");
				hlist =  as.adminImemInfoQnaHis(idx);		
				request.setAttribute("hlist", hlist);				
				ArrayList<Map<String, Object>> hlist1 = (ArrayList<Map<String, Object>>) request.getAttribute("hlist"); 
				
				for(Map<String, Object> hashmap : hlist1){
					
					MemberVo mv = (MemberVo) hashmap.get("mv");
					BoardVo bv = (BoardVo) hashmap.get("bv");		
					
					System.out.println(mv.getIdx());
					System.out.println(bv.getContents());
					System.out.println(mv.getInsDate());
					System.out.println(bv.getbDepth());							
				}	
		
			PageRedirect pr = new PageRedirect(false, "/admin/AdminImemInfoCon.jsp", request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
