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
					
    	//투자자 회원정보 아이디,비밀번호 체크 페이지 
//		HttpSession session = request.getSession();
//		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		String password = null;

		int idx = Integer.parseInt(request.getParameter("idx"));
		if(request.getParameter("password") != null) password = request.getParameter("password").trim();

		IMemberServiceImpl si = new IMemberServiceImpl();
		MemberVo InputMV = new MemberVo();
		InputMV.setIdx(idx);
		InputMV.setPw(password);
		
		int row = 0;
			
		row = si.IMemberInfoIdPwChk(InputMV);
		
		System.out.println(row);
		
		if(row == 0){
		
			PageRedirect pr = new PageRedirect(false, "/imember/IMemberInfoCon.jsp", request, response);
		
		}else{
			
			MemberVo vo = new MemberVo();
			vo = si.IMemberInfoCon(idx, 10, 1);
			
			request.setAttribute("vo", vo);
			
			vo = (MemberVo) request.getAttribute("vo");
			
			System.out.println(vo.getIdx());
			System.out.println(vo.getId());
			System.out.println(vo.getName());
			System.out.println(vo.getNick());
			System.out.println(vo.getPhone());
			System.out.println(vo.getAddr());
			System.out.println(vo.getStatus());
			System.out.println(vo.getType());
			
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
