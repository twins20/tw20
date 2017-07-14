package controller.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			idx = (Integer) session.getAttribute("idx");
		}
		
		int pIdx = 0;
		String comments = null;
		int row = 0;
		
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		}
		if(request.getParameter("comments") != null){
			comments = request.getParameter("comments").trim();
		}
			
		ProjectCommVo inputPV = new ProjectCommVo();
		inputPV.setpIdx(pIdx);
		inputPV.setIdx(idx);
		inputPV.setComments(comments);
			
		ProjectServiceImpl ps = new ProjectServiceImpl();
		
		row = ps.projConCommWrite(inputPV);

		PageRedirect pr = new PageRedirect(true, "/ProjCon.do?pIdx="+pIdx+"", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
