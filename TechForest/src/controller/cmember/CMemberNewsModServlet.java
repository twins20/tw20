package controller.cmember;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberNewsModServlet
 */
@WebServlet("/CMemberNewsModServlet")
public class CMemberNewsModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberNewsModServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int bIdx = 0;
		
		if(request.getParameter("bIdx") != null) bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
		
		Map<String, Object> data = new HashMap<String, Object>();
		BoardVo vo = new BoardVo();
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		data = cs.cMemNewsCon(bIdx);
		
		vo = (BoardVo) data.get("vo");
		
		request.setAttribute("vo", vo);
				
//		vo = (BoardVo) request.getAttribute("vo"); 
//	
//		System.out.println(vo.getbIdx());
//		System.out.println(vo.getIdx());
//		System.out.println(vo.getCate());
//		System.out.println(vo.getTitle());
//		System.out.println(vo.getHit());
//		System.out.println(vo.getGood());
//		System.out.println(vo.getBad());
//		System.out.println(vo.getObIdx());
//		System.out.println(vo.getInsDate());
//		System.out.println(vo.getExtColumn());

		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberNewsMod.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
