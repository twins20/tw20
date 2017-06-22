package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isRedirect = false;
	private String view;

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contextPath = request.getContextPath();
		String url = request.getRequestURI();
		String command = url.substring(contextPath.length());
		
		// 멤버 //	
		if(command.equals("/Controller/ListServlet.do")){ //boolean = true
	
			ListServlet ls = new ListServlet(); //ListServlet에 있는 doGet을 가져오기 위해서 객체 생성
			ls.doGet(request, response);        //생성구문
			
			this.view = "/model2/Member/List.jsp";
			this.isRedirect = false;
		
		}else if (command.equals("/Controller/WriteServlet.do")){
			
			WriteServlet ws = new WriteServlet();
			ws.doGet(request, response);
			
			this.view = "/model2/Member/Write.jsp";
			this.isRedirect = false;
			
		}else if (command.equals("/Controller/ContentServlet.do")){
			
			ContentServlet cs = new ContentServlet();
			cs.doGet(request, response);
			
			this.view = "/model2/Member/Content.jsp";
			this.isRedirect = false;
			
		}else if (command.equals("/Controller/ModifyServlet.do")){
			
			ModifyServlet ms = new ModifyServlet(); 
			ms.doGet(request, response);
			
			this.view = "/model2/Member/Modify.jsp";
			this.isRedirect = false;
		
		}else if(command.equals("/Controller/ModifyActionServlet.do")){
			
			ModifyActionServlet ms = new ModifyActionServlet(); 
			ms.doPost(request, response);
			
			this.view = "/Controller/ListServlet.do";
			this.isRedirect = true;
				
		}else if (command.equals("/Controller/DeleteActionServlet.do")){
				
			DeleteActionServlet ds = new DeleteActionServlet();
			ds.doPost(request, response);
			
			this.view = "/Controller/ListServlet.do";
			this.isRedirect = true;
			
		}else if (command.equals("/Controller/WriteActionServlet.do")){
				
			WriteActionServlet wa = new WriteActionServlet();
			wa.doPost(request, response);
			
			this.view = "/Controller/ListServlet.do";
			this.isRedirect = true;
			
		
		// 부서 //
		}else if (command.equals("/Controller/BuseoListServlet.do")){
			
			BuseoListServlet bs = new BuseoListServlet();
			bs.doGet(request, response);
			
			this.view = "/model2/Buseo/List.jsp";
			this.isRedirect = false;
			
		}else if (command.equals("/Controller/BuseoWriteServlet.do")){
					
			BuseoWriteServlet bs = new BuseoWriteServlet();
			bs.doGet(request, response);
			
			this.view = "/model2/Buseo/Write.jsp";
			this.isRedirect = false;
			
		}else if (command.equals("/Controller/BuseoContentServlet.do")){
			
			BuseoContentServlet bc = new BuseoContentServlet();
			bc.doGet(request, response);
			
			this.view = "/model2/Buseo/Content.jsp";
			this.isRedirect = false;
			
		}else if (command.equals("/Controller/BuseoModifyServlet.do")){
			
			BuseoModifyServlet bm = new BuseoModifyServlet();
			bm.doGet(request, response);
			
			this.view = "/model2/Buseo/Modify.jsp";
			this.isRedirect = false;
			
		}else if (command.equals("/Controller/BuseoModifyActionServlet.do")){
			
			BuseoModifyActionServlet bma = new BuseoModifyActionServlet();
			bma.doPost(request, response);
			
			this.view = "/Controller/BuseoListServlet.do";
			this.isRedirect = true;
			
		}else if (command.equals("/Controller/BuseoDeleteActionServlet.do")){
			
			BuseoDeleteActionServlet bda = new BuseoDeleteActionServlet();
			bda.doPost(request, response);
			
			this.view = "/Controller/BuseoListServlet.do";
			this.isRedirect = true;
			
		}else if (command.equals("/Controller/BuseoWriteActionServlet.do")){
			
			BuseoWriteActionServlet bwa = new BuseoWriteActionServlet();
			bwa.doPost(request, response);
			
			this.view = "/Controller/BuseoListServlet.do";
			this.isRedirect = true;
			
		
		// 샐러리 //
		}else if (command.equals("/Controller/SalaryListServlet.do")){
			
			SalaryListServlet ss = new SalaryListServlet();
			ss.doGet(request, response);
			
			this.view = "/model2/Salary/List.jsp";
			this.isRedirect = false;
			
		}else if (command.equals("/Controller/SalaryWriteServlet.do")){
					
			SalaryWriteServlet sw = new SalaryWriteServlet();
			sw.doGet(request, response);
			
			this.view = "/model2/Salary/Write.jsp";
			this.isRedirect = false;
			
		}else if (command.equals("/Controller/SalaryContentServlet.do")){
			
			SalaryContentServlet sc = new SalaryContentServlet();
			sc.doGet(request, response);
			
			this.view = "/model2/Salary/Content.jsp";
			this.isRedirect = false; 
			
		}else if (command.equals("/Controller/SalaryModifyServlet.do")){
			
			SalaryModifyServlet sm = new SalaryModifyServlet();
			sm.doGet(request, response);
			
			this.view = "/model2/Salary/Modify.jsp";
			this.isRedirect = false;
			
		}else if (command.equals("/Controller/SalaryModifyActionServlet.do")){
			
			SalaryModifyActionServlet sma = new SalaryModifyActionServlet();
			sma.doPost(request, response);
			
			this.view = "/Controller/SalaryListServlet.do";
			this.isRedirect = true;
			
		}else if (command.equals("/Controller/SalaryDeleteActionServlet.do")){
			
			SalaryDeleteActionServlet sda = new SalaryDeleteActionServlet();
			sda.doGet(request, response);
			
			this.view = "/Controller/SalaryListServlet.do";
			this.isRedirect = true;
			
		}else if (command.equals("/Controller/SalaryWriteActionServlet.do")){
			
			SalaryWriteActionServlet swa = new SalaryWriteActionServlet();
			swa.doPost(request, response);
			
			this.view = "/Controller/SalaryListServlet.do";
			this.isRedirect = true;
			
		}
		
		if(this.isRedirect){
			response.sendRedirect(contextPath+view);
		}else{
			RequestDispatcher rs = request.getRequestDispatcher(view);
			rs.forward(request, response);
		}	

	}
		
			
			//실행구문
//			this.view = "/model2/List.jsp";
//			this.isRedirect = true;
//		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
}
