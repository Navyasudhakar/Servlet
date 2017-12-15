package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		String strNme = req.getParameter("nme");
		String strPwd = req.getParameter("pwd");
		System.out.println("Value of nme is " + strNme);
		System.out.println("Value of pwd is " + strPwd);

		if (strNme.equalsIgnoreCase("navya") && strPwd.equalsIgnoreCase("sudhakar")) {
			pw.println("<html>");
			pw.println("<body bgcolor='green'>");
			pw.println("Hello Mr/Ms " + strNme + "You are welcome");
			pw.println("</body>");
			pw.println("</html>");
		}

		else {
			pw.println("<html>");
			pw.println("<body bgcolor='red'>");
			pw.println("Hello Ms/Ms " + strNme + " You are invalid user");
			pw.println("</body>");
			pw.println("</html>");
		}
	}
}
