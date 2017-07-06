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


@WebServlet("/AdminCmemInfoConServlet")
public class AdminCmemInfoConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminCmemInfoConServlet() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();
		int idx = 0; 
		idx = Integer.parseInt(request.getParameter("idx"));
//		int idx = 2;	
		
		//관리자 사업자 회원정보 페이지 회원별 상세정보 
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>();	
		alist = as.adminCmemInfoCon(idx);
		request.setAttribute("alist", alist);		
		
		//관리자 사업자 회원정보 페이지 진행중 프로젝트
		ArrayList<ProjectVo> blist = new ArrayList<ProjectVo>();
		blist = as.adminCmemInfoProj(idx);
		request.setAttribute("blist", blist);
		
		ArrayList<FundVo> clist = new ArrayList<FundVo>();
		clist = as.adminCmemInfoProj1(idx);
		request.setAttribute("clist", clist);
		
		//관리자 사업자 회원정보 페이지 지난 프로젝트 리스트 
		ArrayList<ProjectVo> dlist = new ArrayList<ProjectVo>();
		dlist = as.adminCmemInfoProjHis(idx, 10, 1);
		request.setAttribute("dlist", dlist);
		
		//관리자 사업자 회원정보 페이지 진행중 프로젝트 투자 회원리스트
		ArrayList<Map<String, Object>> elist = new ArrayList<Map<String, Object>>();		
		elist =  as.adminCmemInfoProjFundHis(idx, 10, 1);		
		request.setAttribute("elist", elist);
		
		//관리자 사업자 회원정보 페이지 뉴스 리스트		
		ArrayList<Map<String, Object>> flist = new ArrayList<Map<String, Object>>();		
		flist =  as.adminCmemInfoProjNewsHis(idx, 10, 1);		
		request.setAttribute("flist", flist);
		
		//관리자 사업자 회원정보 페이지 QNA 리스트
		ArrayList<BoardVo> glist = new ArrayList<BoardVo>();
		glist = as.adminCmemInfoProjQna(idx, 10, 1);
		request.setAttribute("glist", glist);
		
//		ArrayList<MemberVo> alist1 = (ArrayList<MemberVo>) request.getAttribute("alist");
//		
//		for(MemberVo vo : alist1){
//			System.out.println("사업자 회원정보 페이지 회원별 상세정보");
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getId());
//			System.out.println(vo.getName());
//			System.out.println(vo.getPhone());
//			System.out.println(vo.getAddr());	
//			System.out.println(vo.getcNumber());
//			System.out.println(vo.getcAddr());
//		}

//		ArrayList<ProjectVo> blist1 = (ArrayList<ProjectVo>) request.getAttribute("blist");
//		
//		for(ProjectVo vo : blist1){
//			System.out.println("진행중 프로젝트 정보");
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getPnFunds());
//			System.out.println(vo.getPtFunds());
//			System.out.println(vo.getpName());
//		}

//		ArrayList<FundVo> clist1 = (ArrayList<FundVo>) request.getAttribute("clist");
//		
//		for(FundVo vo : clist1){
//			System.out.println("사업자 현재 펀드 정보");
//			System.out.println(vo.getInFunds());
//			System.out.println(vo.getbFunds());
//			System.out.println(vo.getaFunds());
//			System.out.println(vo.getInsDate());
//		}

//		ArrayList<ProjectVo> dlist1 = (ArrayList<ProjectVo>) request.getAttribute("dlist");
//		
//		for(ProjectVo vo : dlist1){
//			System.out.println("지난 프로젝트 리스트 ");
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getpName());
//			System.out.println(vo.getPnFunds());
//			System.out.println(vo.getPtFunds());
//			System.out.println(vo.getInsDate());
//		}
		
//		ArrayList<Map<String, Object>> elist1 = (ArrayList<Map<String, Object>>) request.getAttribute("elist"); 
//		
//		for(Map<String, Object> hashmap : elist1){
//			System.out.println("진행중 프로젝트 투자 회원리스트");
//			
//			MemberVo mvo = (MemberVo) hashmap.get("mvo");
//			System.out.println(mvo.getNick());
//			
//			FundVo fvo = (FundVo) hashmap.get("fvo");
//			System.out.println(fvo.getaFunds());
//			System.out.println(fvo.getInsDate());
//			System.out.println(fvo.getStatus());					
//		}
	
//		ArrayList<Map<String, Object>> flist1 = (ArrayList<Map<String, Object>>) request.getAttribute("flist"); 
//		
//		for(Map<String, Object> hashmap : flist1){
//			System.out.println("뉴스 리스트");
//			
//			BoardVo bvo = (BoardVo) hashmap.get("bvo");			
//			System.out.println(bvo.getbIdx());
//			System.out.println(bvo.getTitle());
//			System.out.println(bvo.getInsDate());
//			
//			ProjectVo pvo = (ProjectVo) hashmap.get("pvo");
//			System.out.println(pvo.getpName());							
//		}

//		ArrayList<BoardVo> glist1 = (ArrayList<BoardVo>) request.getAttribute("glist");
//		
//		for(BoardVo vo : glist1){
//			System.out.println("QNA 리스트");
//			System.out.println(vo.getrNum());
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getCate());			
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getHit());
//			System.out.println(vo.getGood());
//			System.out.println(vo.getBad());
//			System.out.println(vo.getCommCnt());
//			System.out.println(vo.getObIdx());	
//			System.out.println(vo.getRbIdx());
//			System.out.println(vo.getbDepth());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getModDate());
//		}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminCmemInfoCon.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
