package controller.member;

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
 * Servlet implementation class MemberLogInServlet_Action
 */
@WebServlet("/MemberLogInServlet_Action")
public class MemberLogInServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogInServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = null, pw = null;
				
		if(request.getParameter("id") != null){
			id = request.getParameter("id").trim();
		}
		if(request.getParameter("pw") != null){
			pw = request.getParameter("pw").trim();
		}
		
		
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPw(pw);

		Map<String, Object> data = new HashMap<String, Object>();
		
		MemberServiceImpl ms = new MemberServiceImpl();
		data = ms.memLogIn(vo);
		
		if(data.containsKey("rownum") == true){
			
			HttpSession session = request.getSession();
			
			session.setAttribute("idx", data.get("idx"));
			session.setAttribute("id", data.get("id"));
			session.setAttribute("nick", data.get("nick"));
			session.setAttribute("status", data.get("status"));
			session.setAttribute("type", data.get("type"));
			
			PageRedirect pr = new PageRedirect(true, "/index.do", request, response);
			
		}else{                                                  
			PageRedirect pr = new PageRedirect(true, "/MemberLogIn.do", request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
