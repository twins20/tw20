package controller.cmember;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardVo;
import service.CMemberServiceImpl;
import service.ProjectVo;

/**
 * Servlet implementation class CMemberQnaConServlet
 */
@WebServlet("/CMemberQnaConServlet")
public class CMemberQnaConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberQnaConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int bIdx = 0;
		
		if(request.getParameter("bIdx") != null){
			bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		BoardVo bvo = new BoardVo();
		ProjectVo pvo = new ProjectVo();
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		data = cs.cMemQnaCon(bIdx);
		
		bvo = (BoardVo) data.get("bvo");
		pvo = (ProjectVo) data.get("pvo");
		
		request.setAttribute("bvo", bvo);
		request.setAttribute("pvo", pvo);
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberQnaCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
