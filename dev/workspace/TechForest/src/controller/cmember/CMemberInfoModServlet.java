package controller.cmember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.CMemberServiceImpl;
import service.MemberVo;

/**
 * Servlet implementation class CMemberInfoModServlet
 */
@WebServlet("/CMemberInfoModServlet")
public class CMemberInfoModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberInfoModServlet() {
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

		String pw = null;
		if(request.getParameter("pw") != null){
			pw = request.getParameter("pw").trim();
		}
		
		MemberVo inputMV = new MemberVo();
		inputMV.setIdx(idx);
		inputMV.setPw(pw);
				
		MemberVo vo = new MemberVo();
		int row = 0;		
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemInfoModChk(inputMV);
		
		if(row == 0){ 
			
			PageRedirect pr = new PageRedirect(true, "/CMemberInfoCon.do", request, response);	
			
		}else{
			
			vo = cs.cMemInfoCon(idx);
	
			request.setAttribute("vo", vo);
			
			PageRedirect pr = new PageRedirect(false, "/cmember/CMemberInfoMod.jsp", request, response);
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
