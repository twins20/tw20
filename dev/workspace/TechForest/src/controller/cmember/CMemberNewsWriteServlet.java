package controller.cmember;

import java.io.IOException;
import java.util.HashMap;
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
 * Servlet implementation class CMemberNewsWriteServlet
 */
@WebServlet("/CMemberNewsWriteServlet")
public class CMemberNewsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberNewsWriteServlet() {
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
		
		ProjectVo vo = new ProjectVo();
	
		CMemberServiceImpl cs = new CMemberServiceImpl();
		vo = cs.cMemNewsWriteProjNow(sess_idx);
		
		request.setAttribute("vo", vo);
				
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberNewsWrite.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
