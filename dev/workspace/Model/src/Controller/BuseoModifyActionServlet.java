package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BuseoDao;
import Model.BuseoVo;

/**
 * Servlet implementation class ModifyActionServlet
 */

public class BuseoModifyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuseoModifyActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩
		int bidx = Integer.parseInt(request.getParameter("bidx")); // idx 값
		String bname = request.getParameter("bname"); // 네임 값
		int idx = Integer.parseInt(request.getParameter("idx")); // 나이
		
		BuseoDao bd = new BuseoDao(); // 객체 생성
		BuseoVo bv = new BuseoVo(); // private 값 가져옴
		
		bv.setBname(bname);
		bv.setIdx(idx);

		int ra = bd.Update(bv, bidx); 
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		if (ra ==0) { // 실패 시 write로 다시 감
//		response.sendRedirect(request.getContextPath()+"/Controller/BuseoWriteServlet.do");	
//		}
//		else{ // 성공 시 리스트 화면으로 오고 데이터가 바뀜
//		response.sendRedirect(request.getContextPath()+"/Controller/BuseoListServlet.do");
//		}
	}

}