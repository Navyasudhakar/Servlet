package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter pw=resp.getWriter();
	String strName=req.getParameter("nme");
	String strDobM=req.getParameter("DOBMonth");
	String strDobD=req.getParameter("DOBDay");
	String strDobY=req.getParameter("DOBYear");
	
	System.out.println("name: "+strName);
	System.out.println("DOB month is: "+strDobM);
	System.out.println("DOB day is: "+strDobD);
	System.out.println("DOB year is: "+strDobY);
	
	pw.println("<html>");
	pw.println("<body bgcolor='pink'>");
	pw.println("Hello Mr/Ms " + strName.toUpperCase() + " You are welcome</br>");
	pw.println("Your name is: " +strName.toUpperCase()+"</br>");
	pw.println("Your DOB month is: " +strDobM+"</br>");
	pw.println("Your DOB day is: " +strDobD+"</br>");
	int x=Integer.parseInt(strDobY);
	int res=x-2017;
	pw.println("Your DOB year is: " +strDobY+"</br>");
	pw.println("your age is:"+res);
	pw.println("</body>");
	pw.println("</html>");


 }
	
}
