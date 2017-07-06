package controller.project;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.ProjectCommVo;
import service.ProjectServiceImpl;
import service.ProjectVo;

/**
 * Servlet implementation class ProjectConSubCommWriteServlet_Action
 */
@WebServlet("/ProjectConSubCommWriteServlet_Action")
public class ProjectConSubCommWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectConSubCommWriteServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pIdx = 0, idx = 0, opCommIdx = 0;
		String comments = null;
		int row = 0;
		
		if(request.getParameter("opCommIdx") != null) opCommIdx = Integer.parseInt(request.getParameter("opCommIdx").trim(),10);
		
		ProjectCommVo inputPV = new ProjectCommVo();
		inputPV.setpIdx(pIdx);
		inputPV.setIdx(idx);
		inputPV.setComments(comments);
		inputPV.setOpCommIdx(opCommIdx);
					
		ProjectServiceImpl ps = new ProjectServiceImpl();
		
		//트랜잭션 사용
		row = ps.projConSubCommWriteTransaction(inputPV);
		
		//트랜잭션 미사용				
//		row = ps.projConSubCommWriteUpdate(inputPV);
//		if(row != 0) row += ps.projConSubCommWriteInsert(inputPV);
		
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
