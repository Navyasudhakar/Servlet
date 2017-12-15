package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Cluster Software Solutions.
 *  (Mob:98451-31637/39
 *  www.clusterindia.com)
 */
public class RequestValueServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		String strFirstName = request.getParameter("firstname");
		System.out.println("******** First Name is" + strFirstName);
		
		String strLastName = request.getParameter("lastname");
		System.out.println("******** Last Name is" + strLastName);
		
		String strCharacterEncoding = request.getCharacterEncoding();
		System.out.println("Value of character encoding is " + strCharacterEncoding);
		System.out.println("Value of getContentLength() is "+ request.getContentLength());
		System.out.println("Value of get getContentType()  " + request.getContentType());
		System.out.println("Value of getContextPath()  "+request.getContextPath());
		System.out.println("Value of getLocalAddr() "+request.getLocalAddr());
		System.out.println("Value of getLocale() "+request.getLocale());
		System.out.println("Value of  getLocalName() "+request.getLocalName());
		System.out.println("Value of  getLocalPort() "+request.getLocalPort());
		System.out.println("Value of getMethod()  "+request.getMethod());
		System.out.println("Value of  getPathInfo() "+request.getPathInfo());
		System.out.println("Value of getPathTranslated()  "+request.getPathTranslated());
		System.out.println("Value of request.getProtocol()  "+request.getProtocol());
		System.out.println("Value of getQueryString()  "+request.getQueryString());
		System.out.println("Value of getRemoteAddr()  "+request.getRemoteAddr());
		System.out.println("Value of getRemoteHost()  "+request.getRemoteHost());
		System.out.println("Value of getRemotePort() "+request.getRemotePort());
		System.out.println("Value of getRemoteUser()  "+request.getRemoteUser());
		System.out.println("Value of getRequestURI() "+request.getRequestURI());
		System.out.println("Value of getRequestURL()  "+request.getRequestURL());
		System.out.println("Value of getServerName() "+request.getServerName());
		System.out.println("Value of getScheme()  "+request.getScheme());
		System.out.println("Value of getServerPort() "+request.getServerPort());
		System.out.println("Value of getServletPath() "+request.getServletPath());
	
		
		writer.println("<html>");
		writer.println("<body bgcolor='green'>");
		writer.println("<h1>Welcome<h1>");
		writer.println("</body>");
		writer.println("</html>");
		
	}
}
