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
 * Servlet implementation class CMemberNewsModServlet_Action
 */
@WebServlet("/CMemberNewsModServlet_Action")
public class CMemberNewsModServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberNewsModServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int bIdx = 0, pIdx = 0;
		String title = null, contents = null;
				
		if(request.getParameter("bIdx") != null) bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
		if(request.getParameter("title") != null) title = request.getParameter("title").trim();
		if(request.getParameter("contents") != null) contents = request.getParameter("contents").trim();
		if(request.getParameter("pidx") != null) pIdx = Integer.parseInt(request.getParameter("pidx").trim());

		BoardVo inputBV = new BoardVo();
		inputBV.setbIdx(bIdx);
		inputBV.setTitle(title);
		inputBV.setContents(contents);
		inputBV.setpIdx(pIdx);
				
		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemNewsMod(inputBV);
		
//		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(true, "/cmember/CMemberNewsCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
