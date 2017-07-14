package controller.imember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.IMemberServiceImpl;
import service.MemberVo;

/**
 * Servlet implementation class IMemberInfoModServlet
 */
@WebServlet("/IMemberInfoModServlet")
public class IMemberInfoModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMemberInfoModServlet() {
    	super();
    	// TODO Auto-generated constructor stub		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			idx = (Integer) session.getAttribute("idx");
		}
		
		String pw = null;
		
		if(request.getParameter("pw") != null){
			pw = request.getParameter("pw").trim();
		}

		MemberVo InputMV = new MemberVo();
		InputMV.setIdx(idx);
		InputMV.setPw(pw);
		
		MemberVo vo = new MemberVo();
		int row = 0;
		
		IMemberServiceImpl si = new IMemberServiceImpl();
		row = si.IMemberInfoModChk(InputMV);
		
		if(row == 0){
		
			PageRedirect pr = new PageRedirect(true, "/IMemberInfoCon.do", request, response);
		
		}else{
			
			vo = si.IMemberInfoCon(idx);
			
			request.setAttribute("vo", vo);
			request.setAttribute("idx", idx);
			
			PageRedirect pr = new PageRedirect(false, "/imember/IMemberInfoMod.jsp", request, response);
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
