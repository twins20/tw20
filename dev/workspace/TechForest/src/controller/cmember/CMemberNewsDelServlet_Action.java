package controller.cmember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardVo;
import service.CMemberServiceImpl;

/**
 * Servlet implementation class CMemberNewsDelServlet_Action
 */
@WebServlet("/CMemberNewsDelServlet_Action")
public class CMemberNewsDelServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberNewsDelServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int bIdx = 0;
					
		if(request.getParameter("bIdx") != null) bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
		
		int row = 0;

		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemNewsDel(bIdx);
		
//		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(true, "/CMemberNewsList.do", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
