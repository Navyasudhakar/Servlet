package com.rvce;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cluster")
public class colours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public colours() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String c=request.getParameter("bc");
   try
        {
            
           
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet bgcolor</title>");            
            out.println("</head>");
            
            if(c.equals("red"))
            out.println("<body bgcolor='red'>");
            if(c.equals("blue"))
            out.println("<body bgcolor='blue'>");
            if(c.equals("green"))
            out.println("<body bgcolor='green'>");
            if(c.equals("yellow"))
            out.println("<body bgcolor='yellow'>");
            if(c.equals("pink"))
                out.println("<body bgcolor='pink'>");
            if(c.equals("violet"))
                out.println("<body bgcolor='violet'>");
            if(c.equals("orange"))
                out.println("<body bgcolor='orange'>");
            out.println("<font size='100'>");
            out.println("<center> servlet color selected is:" +c);
            out.println("<a href=http://localhost:8089/08color/html/NewFile.html><br/>Back</a>");
            out.println("</font></center></body>");
            out.println("</html>");
        }
   finally{
       out.close();
   }
   }
	}

	

