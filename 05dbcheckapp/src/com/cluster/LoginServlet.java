package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		boolean b = false;
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String strNme = req.getParameter("nme");
		String strPwd = req.getParameter("pwd");
	/*	
		System.out.println("name is "+strNme);
		System.out.println("password is "+strPwd);
	*/	 
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "navyaoracle","navyaoracle");
			// System.out.println("************1" + connection);
			st = con.createStatement();
			rs = st.executeQuery("SELECT NAME,PASSWORD FROM CUSTOMER");

			while (rs.next()) {
				if ((strNme.equalsIgnoreCase(rs.getString("NAME")))	&& (strPwd.equalsIgnoreCase(rs.getString("PASSWORD")))) {
					b = true;
					break;
				}
			}
			
			if (b) {
				pw.println("<html>");
				pw.println("<body bgcolor='green'>");
				pw.println("Hello Mr/Ms. " + strNme + " you are Welcome");
				pw.println("</body>");
				pw.println("</html>");
			} else {
				pw.println("<html>");
				pw.println("<body bgcolor='red'>");
				pw.println("Hello Mr " + strNme + " you are invalid user");
				pw.println("</body>");
				pw.println("</html>");
			}

		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally{
			try {
				if(rs!=null)
				{
					rs.close();
				}
				
				if(st!=null)
				{
				st.close();
				}
				if(con!=null)
				{
				con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
