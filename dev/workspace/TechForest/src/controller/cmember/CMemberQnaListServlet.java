package controller.cmember;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberQnaListServlet
 */
@WebServlet("/CMemberQnaListServlet")
public class CMemberQnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberQnaListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");
		}
				
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		alist = cs.cMemQnaList(sess_idx, 10, 1);
		
		request.setAttribute("alist", alist);
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberQnaList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
