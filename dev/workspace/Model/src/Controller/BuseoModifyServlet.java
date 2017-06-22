package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BuseoDao;
import Model.BuseoVo;
import Model.MemberDao;
import Model.MemberVo;

/**
 * Servlet implementation class ModifyServlet
 */
public class BuseoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuseoModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		MemberDao md = new MemberDao(); // 리스트에 있던 것을 가져옴
		ArrayList<MemberVo>  list = md.getMemberList(); // 값을 꺼냄
		
		request.setAttribute("list", list); 
		
		int bidx = Integer.parseInt(request.getParameter("bidx"));
		BuseoDao bd = new BuseoDao();
		BuseoVo bv = bd.Modify(bidx);
		
		request.setAttribute("bv", bv); // set = 담다 / attribute = 속성 값을 담음
		request.setAttribute("bidx", bidx);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/model2/Buseo/Modify.jsp");
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
