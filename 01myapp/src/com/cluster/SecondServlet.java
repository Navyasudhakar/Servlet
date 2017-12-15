package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SecondServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<body bgcolor='red'>");
		pw.println("<h1>");
		pw.println("I am great I got my first output of Servlet");
		pw.println("</h1>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
