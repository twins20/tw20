package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.AdminServiceImpl;
import service.BoardVo;


@WebServlet("/AdminQnaWriteServlet_Action")
public class AdminQnaWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminQnaWriteServlet_Action() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}	
				
		int bIdx = 0, pIdx = 0;		
		String title = null, contents = null,  cate = null;	
				
		if(Integer.parseInt(request.getParameter("bIdx")) != 0){
			bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
		}
		if(Integer.parseInt(request.getParameter("pIdx")) != 0){
			pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title").trim();
		}
		if(request.getParameter("contents") != null){
			contents = request.getParameter("contents").trim();
		}
		if(request.getParameter("cate") != null){
			cate = request.getParameter("cate").trim();
		}
		
		BoardVo inputBV = new BoardVo();
		
		inputBV.setbIdx(bIdx);
		inputBV.setpIdx(pIdx);
		inputBV.setIdx(sess_idx);
		inputBV.setCate(cate);
		inputBV.setTitle(title);
		inputBV.setContents(contents);
				
		int row = 0;
		
		AdminServiceImpl as = new AdminServiceImpl();
		row = as.adminBoardQnaWrite(inputBV);		
//		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(true, "/AdminQnaList.do", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
