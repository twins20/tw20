package controller.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.ProjectServiceImpl;
import service.ProjectVo;

/**
 * Servlet implementation class ProjectListByPowerServlet
 */
@WebServlet("/ProjectListByPowerServlet")
public class ProjectListByPowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectListByPowerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>();
		ProjectServiceImpl ps = new ProjectServiceImpl(); 
		alist = ps.projListByPower(10,1);
		
		request.setAttribute("alist", alist);
		
		PageRedirect pr = new PageRedirect(false, "/project/ProjectListByPower.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
