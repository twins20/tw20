package controller.cmember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberNewsWriteServlet_Action
 */
@WebServlet("/CMemberNewsWriteServlet_Action")
public class CMemberNewsWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberNewsWriteServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		int pIdx = 0;
		String title = null, contents = null;
				
		if(request.getParameter("title") != null) title = request.getParameter("title").trim();
		if(request.getParameter("contents") != null) contents = request.getParameter("contents").trim();
		if(request.getParameter("pidx") != null) pIdx = Integer.parseInt(request.getParameter("pidx").trim());

		BoardVo inputBV = new BoardVo();
		inputBV.setIdx(idx);
		inputBV.setTitle(title);
		inputBV.setContents(contents);
		inputBV.setpIdx(pIdx);
				
		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemNewsWrite(inputBV);
		
//		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(true, "/cmember/CMemberNewsList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
