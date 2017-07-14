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
import service.AdminServiceImpl;
import service.BoardVo;


@WebServlet("/AdminNoticeModServlet_Action")
public class AdminNoticeModServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminNoticeModServlet_Action() {
        super();      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}	
		
		int bIdx = 0;
		String cate = null, title = null, contents = null;
		
		if(request.getParameter("cate") != null){
			cate = request.getParameter("cate");
		}
		if(request.getParameter("bIdx") != null){
			bIdx = Integer.parseInt(request.getParameter("bIdx").trim());
		}		
		if(request.getParameter("title") != null){
			title = request.getParameter("title");
		}
		if(request.getParameter("contents") != null){
			contents = request.getParameter("contents");
		}
		
		BoardVo InputBV = new BoardVo();
			
		InputBV.setCate(cate);
		InputBV.setTitle(title);
		InputBV.setContents(contents);
		InputBV.setbIdx(bIdx);
		
		int row = 0;		
		
		AdminServiceImpl as = new AdminServiceImpl();
		row = as.adminBoardNoticeMod(InputBV);
		
		if(row == 0){	
			PageRedirect pr = new PageRedirect(false, "/admin/AdminNoticeMod.jsp", request, response);		
		}else{				
			PageRedirect pr = new PageRedirect(true, "/AdminNoticeCon.do?bIdx="+bIdx, request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
