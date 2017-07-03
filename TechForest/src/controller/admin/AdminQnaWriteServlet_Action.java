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
		
		int idx = 0;
		int bidx = 0;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("idx") != null){
			idx = (Integer) session.getAttribute("idx");
		}
		
		String title = null, contents = null,  cate = null;	
				
		if(Integer.parseInt(request.getParameter("bidx")) != 0) bidx = Integer.parseInt(request.getParameter("bidx"));
		if(request.getParameter("title") != null) title = request.getParameter("title").trim();
		if(request.getParameter("contents") != null) contents = request.getParameter("contents").trim();
		if(request.getParameter("cate") != null) cate = request.getParameter("cate").trim();

		
		BoardVo inputBV = new BoardVo();
		
		inputBV.setbIdx(bidx);
		inputBV.setIdx(idx);
		inputBV.setCate(cate);
		inputBV.setTitle(title);
		inputBV.setContents(contents);
				
		int row = 0;
		
		AdminServiceImpl as = new AdminServiceImpl();
		row = as.adminBoardQnaWrite(inputBV);
		
		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(true, "/AdminQnaListServlet", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
