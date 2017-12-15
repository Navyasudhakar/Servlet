package com.kogent;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Link extends HttpServlet 
{
  	static private Hashtable links = new Hashtable();

  	String stamp;
  	public Link() 
	{
    		stamp = new Date().toString();
  	}

  	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{

    		String lnk = request.getParameter("link");
    		if (lnk != null && !lnk.equals("")) 
		{
	      		synchronized (links)
			{
        			Integer count = (Integer) links.get(lnk);
        			if (count == null) 
				{
          				links.put(lnk, new Integer(1));
        			}
        			else 
				{
          				links.put(lnk, new Integer(1+count.intValue()));
        			}
      			}
      			response.sendRedirect(lnk);
   		}
	    	else 
		{
     			response.setContentType("text/html");
      			PrintWriter out = response.getWriter();
      			request.getSession();
      			out.println("<html>");
      			out.println("<head>");
      			out.println("<title>Links Tracker Servlet</title>");
      			out.println("</head>");
      			out.println("<body>");
      			out.println("<p>Links Tracked Since");
      			out.println(stamp+":</p>");
      			if (links.size() != 0) 
			{
        			Enumeration enm = links.keys();
        			while (enm.hasMoreElements()) 
				{
          				String key = (String)enm.nextElement();
          				int count = ((Integer)links.get(key)).intValue();
          				out.println(key+" : "+count+" visits<br>");
        			}
      			}
      			else 
			{
        			out.println("No links have been tracked!<br>");
      			}
      			out.println("</body>");
      			out.println("</html>");
    		}
  	}
  	public void doPost(HttpServletRequest request, HttpServletResponse 				response) throws IOException, ServletException 
	{
    		doGet(request, response);
  	}
}
