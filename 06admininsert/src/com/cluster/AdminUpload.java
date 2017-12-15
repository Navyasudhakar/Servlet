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

public class AdminUpload extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String strNme = req.getParameter("nme");
		String strPwd = req.getParameter("pwd");
		String studName =req.getParameter("sname");
		String studUsn =req.getParameter("usn");
		String marks1 = req.getParameter("marks1");
		String marks2 = req.getParameter("marks2");
		String marks3 = req.getParameter("marks3");
		String marks4 = req.getParameter("marks4");
		String marks5 = req.getParameter("marks5");
		//String insert=req.getParameter("insert");
		//boolean r=Boolean.parseBoolean(insert);
		
		System.out.println("******** Name is " + strNme);
		System.out.println("******** Password is " + strPwd);
		System.out.println("******** stud name is " + studName);
		System.out.println("******** stud USN is " + studUsn);
		System.out.println("******** student marks1 is " + marks1);
		System.out.println("******** student marks2 is " + marks2);
		System.out.println("******** student marks3 is " + marks3);
		System.out.println("******** student marks4 is " + marks4);
		System.out.println("******** student marks5 is " + marks5);
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("+++++++ Driver is loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "navyaoracle", "navyaoracle");
			System.out.println(con);
			System.out.println("Got database connection " + con);
			//if(r)
			//{
			pst = con.prepareStatement("INSERT INTO ADMIN(SNAME,USN,MARKS1,MARKS2,MARKS3,MARKS4,MARKS5) VALUES (?,?,?,?,?,?,?)");
			
	
			pst.setString(1, studName);
			pst.setString(2, studUsn);
			pst.setString(3, marks1);
			pst.setString(4, marks2);
			pst.setString(5, marks3);
			pst.setString(6, marks4);
			pst.setString(7, marks5);
			int i = pst.executeUpdate();
			
			if(strNme.equalsIgnoreCase("anisha") && strPwd.equalsIgnoreCase("anisha")){
			if (i == 1)
			{
				pw.println("<html>");
				pw.println("<body bgcolor='green'>");
				pw.println("Admin you have successfully updated"+"\t"+studName+"records........");
				pw.println("</body>");
				pw.println("</html>");
			}
			//}
			else
			{
				pw.println("<html>");
				pw.println("<body bgcolor='red'>");
				pw.println("Admin you have failed to update "+studName+"records........");
				pw.println("</body>");
				pw.println("</html>");
			}
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

