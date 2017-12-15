<html>
<body bgcolor="yellow">
<%
	String strName = request.getParameter("nme");
	String strPassword = request.getParameter("pwd");
	if ((strName.equalsIgnoreCase("navyashree")) && (strPassword.equalsIgnoreCase("navya123#"))) {
%>
<p> <font size="3" color="green">Hello Mr/Ms <%=strName%> you are welcome</font></p> 
<%}else{%>
<p><font size="3" color="red">Hello Mr/Ms <%=strName%> Mr You are not a valid User</font></p>
<%}%>
<a href="click here to view name"></a>
<form name=form1 action="hello.html" method="post"></form>
</body>
</html>