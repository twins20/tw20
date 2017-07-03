package common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageRedirect {
	public PageRedirect(boolean reDirectChk, String reDirectAddr, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	
		String contextPath = request.getContextPath();
		
		if(reDirectChk){
			response.sendRedirect(contextPath + reDirectAddr);
		}else{
			RequestDispatcher rs = request.getRequestDispatcher(reDirectAddr);
			rs.forward(request, response);
		}
	}
}
