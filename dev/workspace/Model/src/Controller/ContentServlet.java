package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDao;
import Model.MemberVo;

/**
 * Servlet implementation class ContentServlet
 */
@WebServlet("/ContentServlet")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		MemberDao md = new MemberDao(); // data access object
		MemberVo mv = md.getMember(idx); // value object
		
		request.setAttribute("mv", mv); // set = 담다 / attribute = 속성 값을 담음
		request.setAttribute("idx", idx);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/model2/Member/Content.jsp");
//		// requestdispatcher 공유, 받고 
//		//RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+"/model2/List.jsp");
//		rd.forward(request, response); // 포워드 방식으로 requestdispatcher이 list로 값을 넘겨줌
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
