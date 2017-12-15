<HTML>
	<HEAD>
	<TITLE> Intermediate </TITLE>
	</HEAD>

	<BODY>
	<%
		if("Yes".equals(request.getParameter("other")))
		{
			pageContext.forward("other");
		}
	%>
	</BODY>
</HTML>
