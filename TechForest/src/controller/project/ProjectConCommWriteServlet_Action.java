package controller.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.*;

/**
 * Servlet implementation class ProjectConCommWriteServlet_Action
 */
@WebServlet("/ProjectConCommWriteServlet_Action")
public class ProjectConCommWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectConCommWriteServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pIdx = 0, idx = 0;
		String comments = null;
		int row = 0;
		
		if(request.getParameter("pIdx") != null) pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		if(request.getParameter("idx") != null) idx = Integer.parseInt(request.getParameter("idx").trim(),10);
		if(request.getParameter("comments") != null) comments = request.getParameter("comments").trim();
			
		ProjectCommVo inputPV = new ProjectCommVo();
		inputPV.setpIdx(pIdx);
		inputPV.setIdx(idx);
		inputPV.setComments(comments);
			
		ProjectServiceImpl ps = new ProjectServiceImpl();
		
		row = ps.projConCommWrite(inputPV);
		
//		System.out.println(row);

		PageRedirect pr = new PageRedirect(true, "/index.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
