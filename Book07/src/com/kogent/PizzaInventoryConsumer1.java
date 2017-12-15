package com.kogent ;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.kogent.* ;

public class PizzaInventoryConsumer1 extends HttpServlet 
{

  	// Get (and keep!) a reference to the shared PizzaInventory instance
  	private PizzaInventory inventory = PizzaInventory.getInstance();

  	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException 
	{
    		res.setContentType("text/html");
    		PrintWriter prnwriter = res.getWriter();

    		prnwriter.println("<HTML>");
    		prnwriter.println("<HEAD><TITLE>Pizza Inventory Consumer</TITLE></HEAD>");

    		prnwriter.println("<BODY><BIG>");

    		if (inventory.makePizza()) 
		{
      			prnwriter.println("Your pizza will be ready in a few minutes.");
		}
	    	else 
		{
      			prnwriter.println("We're low on ingredients.<BR>");
      			prnwriter.println("Looks like you're gonna starve.");
    		}

    		prnwriter.println("</BIG></BODY></HTML>");
  	}
}
