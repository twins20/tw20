package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

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


@WebServlet("/AdminImemInfoListServlet")
public class AdminImemInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminImemInfoListServlet() {
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
		
		//관리자 투자자 회원정보 페이지 회원리스트
		String pageList = null;
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>();
		
		AdminServiceImpl as = new AdminServiceImpl();		
			alist = as.adminImemInfoList(listCnt, pageCnt);		
			ttCnt = as.adminImemInfoListTtCnt();
			pageList = new PagingQ().pagingList(listCnt, pageCnt, ttCnt);
			String[] tmpPageInfo = pageList.split(" ");
			
			request.setAttribute("alist", alist);
			request.setAttribute("pageList", pageList);
			request.setAttribute("startPage", tmpPageInfo[0]);
			request.setAttribute("pageCnt", tmpPageInfo[1]);
			request.setAttribute("endPage", tmpPageInfo[2]);	
			
//		ArrayList<MemberVo> alist1 = (ArrayList<MemberVo>) request.getAttribute("alist");
//		
//		for(MemberVo vo : alist1){
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getId());
//			System.out.println(vo.getName());
//			System.out.println(vo.getStatus());
//			System.out.println(vo.getMoney());	
//		}
			
		PageRedirect pr = new PageRedirect(false, "/admin/AdminImemInfoList.jsp", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
