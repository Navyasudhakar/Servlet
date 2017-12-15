package com.kogent;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.kogent.*;

public class PizzaInventoryProducer extends HttpServlet 
{

  	// Get (and keep!) a reference to the shared PizzaInventory instance
 	// PizzaInventory inventory = PizzaInventory.getInstance();
	PizzaInventory  inventory = PizzaInventory.getInstance();

  	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException 
	{
	    	res.setContentType("text/html");
    		PrintWriter prnwriter = res.getWriter();

    		prnwriter.println("<HTML>");
   	 	prnwriter.println("<HEAD><TITLE>Pizza Inventory Producer</TITLE></HEAD>");

    		// Produce random amounts of each item
    		Random random = new Random();

    		int cheese = Math.abs(random.nextInt() % 10);
    		int wheatflour = Math.abs(random.nextInt() % 10);
    		int beans = Math.abs(random.nextInt() % 10);
    		int capsicum = Math.abs(random.nextInt() % 10);

    		// Add the items to the inventory
    		inventory.addCheese(cheese);
    		inventory.addWheatflour(wheatflour);
    		inventory.addBeans(beans);
    		inventory.addCapsicum(capsicum);

    		// Print the production results
    		prnwriter.println("<BODY>");
    		prnwriter.println("<H1>Added ingredients:</H1>");
    		prnwriter.println("<PRE>");
    		prnwriter.println("cheese: " + cheese);
    		prnwriter.println("wheatflour: " + wheatflour);
		prnwriter.println("beans: " + beans);
    		prnwriter.println("capsicum: " + capsicum);
    		prnwriter.println("</PRE>");
    		prnwriter.println("</BODY></HTML>");
  	}
}
