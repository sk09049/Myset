package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	   String n=request.getParameter("user");
	   String p=request.getParameter("pass");
	   PrintWriter pw=response.getWriter();
	  

	 if(n.equals("cassey")){
		   if(p.equals("password")){
			   request.setAttribute("name", n);
			   request.getRequestDispatcher("welcome.jsp").forward(request, response);
			   
		   }else {
			   pw.println("password is incorerct");
			   RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			   rd.include(request, response);
		   }
		   }else {
			   pw.println("uername is incorrect");
			   RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			   rd.include(request, response);
		   }
	  
	}
}


