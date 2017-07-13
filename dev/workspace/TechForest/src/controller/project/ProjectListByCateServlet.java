package controller.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.*;
import service.*;


/**
 * Servlet implementation class ProjectListByCateServlet
 */
@WebServlet("/ProjectListByCateServlet")
public class ProjectListByCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectListByCateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		String pCate = null;
		if(request.getParameter("pCate") != null) pCate = request.getParameter("pCate").trim();
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>();
		ProjectServiceImpl ps = new ProjectServiceImpl(); 
		alist = ps.projListByCate(pCate, 10, 1);
		
		request.setAttribute("alist", alist);
		
//		alist = (ArrayList<ProjectVo>) request.getAttribute("alist"); 
//		
//		for(ProjectVo vo : alist){
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getpName());
//			System.out.println(vo.getpCate());
//			System.out.println(vo.getPtFunds());
//			System.out.println(vo.getPnFunds());
//			System.out.println(vo.getpGrade());
//		}
		
		PageRedirect pr = new PageRedirect(false, "/project/ProjectListByCate.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}