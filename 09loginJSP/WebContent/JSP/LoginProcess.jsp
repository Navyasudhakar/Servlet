<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logging in</title>
</head>
<body>
<%
Connection con = null;
Statement st = null;
boolean b = false;
String user=request.getParameter("uname");
String password=request.getParameter("pass");
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("+++++++ Driver is loaded");
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "navyaoracle", "navyaoracle");
	System.out.println("Got database connection " + con);
	st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from userdetails" );
	while(!rs.next())
	{
		if ((user.equalsIgnoreCase(rs.getString("UNAME")))	&& (password.equalsIgnoreCase(rs.getString("PASS")))) {
			b = true;
			break;
		}
	}
	
	if (b) {%>
		<h1>valid user</h1>
		<h6>Welcome user </h6><%= user %>
		
	<% }
	else{
%>
user details given for user name :<%=request.getParameter("uname") %> and 
password : <%=request.getParameter("pass") %> are not valid<br/>
Try again<%@include file="../html/login.html" %>
</body>
</html>
<% 
}//try
}
finally
{
 try
 {
 con.close();
 }
 catch(Exception e){}
 }//finally
 %>
 <h1>This is a Home Page<br/>
 Welcome,<%= user%></h1>