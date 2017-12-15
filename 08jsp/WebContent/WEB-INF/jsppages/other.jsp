<html>
<body>
	<%!int count;
		public void jspInit() 
		{
			ServletConfig sc=getServletConfig();
			count = Integer.parseInt(sc.getInitParameter("count"));
			System.out.println("In jspInit");
	       
		}
	%>

	<%
		out.println("<H1>Using page, session, out, config, and application Implicit Objects</H1>");
	%>

	Count value without using config implicit object: <b> <%=count%></b> <br/>
	<%
		this.log("log message");
		((HttpServlet)page).log("anothermessage");
		ServletContext ct = config.getServletContext();
		out.println("Value of sessionVar is:"+
			"&nbsp;&nbsp;<b>"+session.getAttribute("sessionVar")+
			"</b><br/>");
		out.println("Server name and version using config implicit object:"+
			"&nbsp;&nbsp;<b>"+ct.getServerInfo()+"</b><br/>");
		out.println("Value of context parameter param1 obtained using applicatio implicit object:"+"&nbsp;&nbsp;<b>"+
			application.getInitParameter("param1")+"</b><br/>");
		out.println("Count value retrieved using config implicit object:"+
			"&nbsp;&nbsp;<b>"+config.getInitParameter("count")+"</b>");
	%>
</body> 
</html>
