package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminSelect  extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
			
			String strNme = req.getParameter("nme");
			String strPwd = req.getParameter("pwd");
		
			Connection con = null;
			PreparedStatement pst = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("+++++++ Driver is loaded");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "navyaoracle", "navyaoracle");
				System.out.println("Got database connection " + con);
			
			// step 3: create the statement
			Statement st = con.createStatement();
			
			// step 4: execute the sql query
			ResultSet rs = st.executeQuery("SELECT * FROM ADMIN");
			
			// step 5: process the results
			if(strNme.equalsIgnoreCase("anisha") && strPwd.equalsIgnoreCase("anisha")){
				pw.println("<html>");
				pw.println("<body bgcolor='green'>");
				pw.println("All the students details"+"<br/>");
			while(rs.next())
			{
			String sname = rs.getString("sname").toUpperCase();
			String usn=rs.getString("usn").toUpperCase();
			int marks1 = rs .getInt("marks1");
			int marks2 = rs .getInt("marks2");
			int marks3 = rs .getInt("marks3");
			int marks4 = rs .getInt("marks4");
			int marks5 = rs .getInt("marks5");
			pw.println("name is:"+sname + "<br/>"+"USN is:" + usn +"<br/>" +"marks1 is:"+ marks1 +"<br/>"+"marks2 is:"+ marks2+"<br/>"+"marks3 is:"+marks3+"<br/>"+"marks4 is:"+marks4+"<br/>"+"marks5 is:"+marks5+"<br/>"+"<br/>"+"<br/>");
			}
			pw.println("</body>");
			pw.println("</html>");
			
			rs.close();
			}
			else{
				pw.println("<html>");
				pw.println("<body bgcolor='red'>");
				pw.println("did not fetch the record");
				pw.println("</body>");
				pw.println("</html>");
			}
			
		} 
			
	     catch (ClassNotFoundException e) {
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

