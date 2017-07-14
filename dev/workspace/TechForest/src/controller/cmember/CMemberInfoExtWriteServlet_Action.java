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
 * Servlet implementation class CMemberInfoExtWriteServlet_Action
 */
@WebServlet("/CMemberInfoExtWriteServlet_Action")
public class CMemberInfoExtWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberInfoExtWriteServlet_Action() {
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
		
		String company = null, cNumber = null, cAddr = null;
				
		if(request.getParameter("company") != null){
			company = request.getParameter("company").trim();
		}
		if(request.getParameter("cNumber") != null){
			cNumber = request.getParameter("cNumber").trim();
		}
		if(request.getParameter("cAddr") != null){
			cAddr = request.getParameter("cAddr").trim();
		}
		
		MemberVo vo = new MemberVo();
		vo.setIdx(idx);
		vo.setCompany(company);
		vo.setcNumber(cNumber);
		vo.setcAddr(cAddr);
				
		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemInfoExtWriteChk(idx);
		
//		System.out.println(row);
		
		if(row == 0){
			row += cs.cMemInfoExtWrite(vo);
			
//			System.out.println(row);
			
			PageRedirect pr = new PageRedirect(true, "/CMemberInfoCon.do", request, response);
		}else{
			PageRedirect pr = new PageRedirect(true, "/CMemberInfoCon.do", request, response);
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
