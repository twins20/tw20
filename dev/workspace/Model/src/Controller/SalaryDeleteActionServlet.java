package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.SalaryDao;


/**
 * Servlet implementation class SalaryDeleteActionServlet
 */
@WebServlet("/SalaryDeleteActionServlet")
public class SalaryDeleteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryDeleteActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		int sidx = Integer.parseInt(request.getParameter("sidx"));
	    // parameter을 통해 idx 값을 받아옴.
		SalaryDao sd = new SalaryDao(); // 객체 선언
	    // delete는 데이터만 접근하면 되기 때문에 MemberVo가 필요 없음.
	    int dt = sd.Delete(sidx);
//	    if (dt ==0) { // 실패 시 write로 다시 감  html이 아니어서 연결문자로 실행 값을 연결(주소가 +idx 였기 때문에)
//	    	response.sendRedirect(request.getContextPath()+"/Controller/SalaryWriteServlet.do");	
//	    	}
//	    	else{ // 성공 시 리스트 화면으로 오고 데이터가 지워짐
//	    	response.sendRedirect(request.getContextPath()+"/Controller/SalaryListServlet.do");
//	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
