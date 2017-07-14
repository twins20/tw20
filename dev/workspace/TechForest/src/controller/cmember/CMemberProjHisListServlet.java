package controller.cmember;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberProjHisListServlet
 */
@WebServlet("/CMemberProjHisListServlet")
public class CMemberProjHisListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberProjHisListServlet() {
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
		if(session.getAttribute("idx") != null){
			idx = (Integer) session.getAttribute("idx");
		}
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>();

		CMemberServiceImpl cs = new CMemberServiceImpl();
		alist = cs.cMemProjHisList(idx, 10, 1);
		
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
//			System.out.println(vo.getStatus());
//		}
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberProjHisList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
