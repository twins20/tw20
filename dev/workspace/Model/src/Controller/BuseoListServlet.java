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

/**
 * Servlet implementation class ListServlet
 */
public class BuseoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuseoListServlet() { // 생성자
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BuseoDao bd = new BuseoDao(); // 리스트에 있던 것을 가져옴
		ArrayList<BuseoVo>  blist = bd.getBuseoList(); // 값을 꺼냄
		
		request.setAttribute("blist", blist); // set = 담다 / attribute = 속성 값을 담음
//		RequestDispatcher rd = request.getRequestDispatcher("/model2/Buseo/List.jsp");
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
