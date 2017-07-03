package controller.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.FundVo;
import service.MemberVo;
import service.ProjectServiceImpl;

/**
 * Servlet implementation class ProjectPayServlet
 */
@WebServlet("/ProjectPayServlet")
public class ProjectPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectPayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pIdx = 0, itIdx = 0, idx = 0, inFunds = 0;
		int row = 0;
		
		if(request.getParameter("pIdx") != null) pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		if(request.getParameter("itIdx") != null) itIdx = Integer.parseInt(request.getParameter("itIdx").trim(),10);
		if(request.getParameter("idx") != null) idx = Integer.parseInt(request.getParameter("idx").trim(),10);
		if(request.getParameter("inFunds") != null) inFunds = Integer.parseInt(request.getParameter("inFunds").trim(),10);
		
		FundVo vo = new FundVo();
		vo.setpIdx(pIdx);
		vo.setItIdx(itIdx);
		vo.setIdx(idx);
		vo.setInFunds(inFunds);

		MemberVo iMemInfo = new MemberVo();
				
		ProjectServiceImpl ps = new ProjectServiceImpl();
		iMemInfo = ps.projPayMyMoney(idx);
		
		request.setAttribute("fundInfo", vo);
		request.setAttribute("iMemInfo", iMemInfo);
		
//		vo = (FundVo) request.getAttribute("fundInfo");
//		iMemInfo = (MemberVo) request.getAttribute("iMemInfo");
//	
//		System.out.println(vo.getpIdx());
//		System.out.println(vo.getItIdx());
//		System.out.println(vo.getIdx());
//		System.out.println(vo.getInFunds());
//		System.out.println(iMemInfo.getMoney());
		
		PageRedirect pr = new PageRedirect(false, "/project/ProjectPay.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
