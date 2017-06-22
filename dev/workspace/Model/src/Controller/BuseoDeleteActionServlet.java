package Controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BuseoDao;

/**
 * Servlet implementation class DeleteActionServlet
 */
public class BuseoDeleteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuseoDeleteActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		int bidx = Integer.parseInt(request.getParameter("bidx"));
	    // parameter을 통해 idx 값을 받아옴.
	    BuseoDao bd = new BuseoDao(); // 객체 선언
	    // delete는 데이터만 접근하면 되기 때문에 MemberVo가 필요 없음.
	    int dt = bd.Delete(bidx);
//	    if (dt ==0) { // 실패 시 write로 다시 감  html이 아니어서 연결문자로 실행 값을 연결(주소가 +idx 였기 때문에)
//	    	response.sendRedirect(request.getContextPath()+"/model2/Buseo/Write.jsp");	
//	    	}
//	    	else{ // 성공 시 리스트 화면으로 오고 데이터가 지워짐
//	    	response.sendRedirect(request.getContextPath()+"/Controller/BuseoListServlet.do");
//	    }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}