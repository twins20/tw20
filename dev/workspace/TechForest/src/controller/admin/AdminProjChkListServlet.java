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
import service.ProjectVo;


@WebServlet("/AdminProjChkListServlet")
public class AdminProjChkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminProjChkListServlet() {
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
		
		//관리자 프로젝트 등록 승인 리스트 
		String pageList = null;
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>();
				
			AdminServiceImpl as = new AdminServiceImpl();	
			alist =  as.adminIndexPProjectChkList(listCnt, pageCnt);	
			ttCnt = as.adminIndexPProjectChkListTtCnt();
			pageList = new PagingQ().pagingList(listCnt, pageCnt, ttCnt);
			String[] tmpPageInfo = pageList.split(" ");
			
			request.setAttribute("alist", alist);
			request.setAttribute("pageList", pageList);
			request.setAttribute("startPage", tmpPageInfo[0]);
			request.setAttribute("pageCnt", tmpPageInfo[1]);
			request.setAttribute("endPage", tmpPageInfo[2]);
		
			
//			ArrayList<ProjectVo> alist1 = (ArrayList<ProjectVo>) request.getAttribute("alist");
//			
//			for(ProjectVo vo : alist1){
//				System.out.println(vo.getpIdx());
//				System.out.println(vo.getpName());
//				System.out.println(vo.getInsDate());
//				System.out.println(vo.getStatus());			
//			}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminProjChkList.jsp", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
