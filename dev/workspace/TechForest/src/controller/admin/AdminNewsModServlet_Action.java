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
import service.AdminServiceImpl;
import service.BoardVo;


@WebServlet("/AdminNewsModServlet_Action")
public class AdminNewsModServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminNewsModServlet_Action() {
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
		
		if(request.getParameter("bIdx") != null){
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		if(request.getParameter("cate") != null){
			cate = request.getParameter("cate");
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
		row = as.adminBoardNewsMod(InputBV);
		
		if(row == 0){
			PageRedirect pr = new PageRedirect(false, "/admin/AdminNewsMod.jsp", request, response);		
		}else{
			PageRedirect pr = new PageRedirect(true, "/AdminNewsCon.do?bIdx="+bIdx, request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
