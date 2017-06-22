package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BuseoDao;
import Model.BuseoVo;

/**
 * Servlet implementation class ContentServlet
 */
public class BuseoContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuseoContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int bidx = Integer.parseInt(request.getParameter("bidx"));
		BuseoDao bd = new BuseoDao(); // data access object
		BuseoVo bv = bd.getMember(bidx); // value object
		
		request.setAttribute("bv", bv); // set = 담다 / attribute = 속성 값을 담음
		
		
//		RequestDispatcher rd = request.getRequestDispatcher("/model2/Buseo/Content.jsp");
//		// requestdispatcher 공유, 받고 
//		//RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+"/model2/List.jsp");
//		rd.forward(request, response); // 포워드 방식으로 requestdispatcher이 list로 값을 넘겨줌
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}