package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String strNme = req.getParameter("nme");
		String strPwd = req.getParameter("pwd");
		String strEmail = req.getParameter("email");
		String strPhone = req.getParameter("phone");
		
		System.out.println("******** Name is " + strNme);
		System.out.println("******** Password is " + strPwd);
		System.out.println("******** Email is " + strEmail);
		System.out.println("******** Phone is " + strPhone);
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("+++++++ Driver is loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "navyaoracle", "navyaoracle");
			System.out.println("Got database connection " + con);
			pst = con.prepareStatement("INSERT INTO CUSTOMER(NAME, PASSWORD, EMAIL, PHONE) VALUES (?,?,?,?)");
			
			pst.setString(1, strNme);
			pst.setString(2, strPwd);
			pst.setString(3, strEmail);
			pst.setString(4, strPhone);
			
			int i = pst.executeUpdate();
			
			if (i == 1)
			{
				pw.println("<html>");
				pw.println("<body bgcolor='green'>");
				pw.println("Hello Mr/Ms."  + strNme + " Thank You for becoming a member");
				pw.println("</body>");
				pw.println("</html>");
			}
			else
			{
				pw.println("<html>");
				pw.println("<body bgcolor='red'>");
				pw.println("Hello Mr."  + strNme + " Better luck next time");
				pw.println("</body>");
				pw.println("</html>");
			}
			
				} catch (ClassNotFoundException e) {
			System.out.println("Exception caught " +e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Exception caught " +e);
			e.printStackTrace();
		}
		
		finally{
			try {
				if(pst!=null)
				{
					pst.close();
				}
				if(con!=null)
				{
					con.close();
				}
				
			} catch (SQLException e) {
				System.out.println("Exception Caught in finally block " + e);
			}
		}
	}
}
