package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.AdminServiceImpl;
import service.BoardVo;


@WebServlet("/AdminFaqModServlet_Action")
public class AdminFaqModServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminFaqModServlet_Action() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bIdx = 0;
		String cate = null, title = null, contents = null;
		
		if(request.getParameter("bIdx") != null) bIdx = Integer.parseInt(request.getParameter("bIdx"));
		if(request.getParameter("cate") != null) cate = request.getParameter("cate");
		if(request.getParameter("title") != null) title = request.getParameter("title");
		if(request.getParameter("contents") != null) contents = request.getParameter("contents");
		
		AdminServiceImpl as = new AdminServiceImpl();
		
		BoardVo InputBV = new BoardVo();		
		InputBV.setCate(cate);
		InputBV.setTitle(title);
		InputBV.setContents(contents);
		InputBV.setbIdx(bIdx);
		
		int row = 0;			
		row = as.adminBoardFaqMod(InputBV);
		
		System.out.println(row);
		
		if(row == 0){
			
			PageRedirect pr = new PageRedirect(false, "/admin/AdminFaqMod.jsp", request, response);
		
		}else{
			
			ArrayList<BoardVo> vo = new ArrayList<BoardVo>();
			vo = as.adminBoardFaqCon(bIdx);			
			request.setAttribute("vo", vo);
			
			vo = (ArrayList<BoardVo>) request.getAttribute("vo");
			
			PageRedirect pr = new PageRedirect(true, "/AdminFaqCon.do", request, response);

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
