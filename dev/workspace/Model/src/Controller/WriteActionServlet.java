package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDao;
import Model.MemberVo;

/**
 * Servlet implementation class WriteActionServlet
 */
@WebServlet("/WriteActionServlet")
public class WriteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    int age = Integer.parseInt(request.getParameter("age"));   
	    String sex = request.getParameter("sex");
	    String area = request.getParameter("area");
	    
	    MemberDao md = new MemberDao();
	    
	    MemberVo mv = new MemberVo();
	    mv.setName(name);
	    mv.setAge(age);
	    mv.setSex(sex);
	    mv.setArea(area);
	    
	    int max = md.getMax();
	    int row = md.insertWrite(mv, max); 
	    
	    //row 0이면 입력안됨
//	    if (row ==0) {
//	    response.sendRedirect(request.getContextPath()+"/Controller/WriteSerlvet.do");	
//	    }
//	    else{
//	    response.sendRedirect(request.getContextPath()+"/Controller/ListServlet.do");
//	    }
	}

}
