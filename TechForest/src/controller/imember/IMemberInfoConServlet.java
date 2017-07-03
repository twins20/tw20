package controller.imember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.MemberVo;
import service.IMemberServiceImpl;

/**
 * Servlet implementation class IMemberInfoConServlet
 */
@WebServlet("/IMemberInfoConServlet")
public class IMemberInfoConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMemberInfoConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//투자자 회원정보 페이지 
		int idx = 1;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		IMemberServiceImpl si = new IMemberServiceImpl(); 
		MemberVo vo = si.IMemberInfoCon(idx, 10, 1); 
		
		request.setAttribute("vo", vo); 
		request.setAttribute("idx", idx);
		
		vo = (MemberVo)request.getAttribute("vo");
		idx = (Integer)request.getAttribute("idx");
		
		System.out.println(vo.getId());
		System.out.println(vo.getName()); 
		System.out.println(vo.getNick()); 
		System.out.println(vo.getPhone());
		System.out.println(vo.getAddr());
		
		PageRedirect pr = new PageRedirect(false, "/imember/IMemberInfoCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
