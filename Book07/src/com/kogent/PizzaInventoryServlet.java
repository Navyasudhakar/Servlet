package com.kogent;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class PizzaInventoryServlet extends HttpServlet 
{

  	// How many "servings" of each item do we have?
  	private int cheese = 0;
  	private int wheatflour = 0;
  	private int beans = 0;
  	private int capsicum = 0;

  	// Add to the inventory as more servings are prepared.
  	public void addCheese(int added) { cheese += added; }
  	public void addWheatflour(int added) { wheatflour += added; }
  	public void addBeans(int added) { beans += added; }
  	public void addCapsicum(int added) { capsicum += added; }

  	// Called when it is time to make a pizza.
  	// Returns true if there are enough ingredients to make the pizza,
  	// false if not. Decrements the ingredient count when there are enough.
  	synchronized public boolean makePizza() 
	{
    		// Pizza requires one serving of each item
    		if (cheese > 0 && wheatflour > 0 && beans > 0 && capsicum > 0) 
		{
      			cheese--; wheatflour--; beans--; capsicum--;
      			return true;  // can make the pizza
    		}
    		else 
		{
      			// Could order more ingredients
      			return false;  // cannot make the pizza
    		}
  	}

  	// Display the current inventory count.
  	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException 
	{
    		res.setContentType("text/html");
    		PrintWriter prnwriter = res.getWriter();

    		prnwriter.println("<HTML><HEAD><TITLE>Current Ingredients</TITLE></HEAD>");
    		prnwriter.println("<BODY>");
    		prnwriter.println("<TABLE BORDER=1>");
    		prnwriter.println("<TR><TH COLSPAN=2>Current ingredients:</TH></TR>");
    		prnwriter.println("<TR><TD>Cheese:</TD><TD>" + cheese + "</TD></TR>");
    		prnwriter.println("<TR><TD>Wheatflour:</TD><TD>" + wheatflour + "</TD></TR>");
    		prnwriter.println("<TR><TD>Beans:</TD><TD>" + beans + "</TD></TR>");
    		prnwriter.println("<TR><TD>Capsicum:</TD><TD>" + capsicum + "</TD></TR>");
    		prnwriter.println("</TABLE>");
    		prnwriter.println("</BODY></HTML>");
  	}

  	// Load the stored inventory count
  	public void init(ServletConfig config) throws ServletException 
	{
    		super.init(config);
    		loadState();
  	}

  	public void loadState() 
	{
    		// Try to load the counts
    		FileInputStream file = null;
    		try 
		{
      			file = new FileInputStream("PizzaInventoryServlet.state");
      			DataInputStream in = new DataInputStream(file);
      			cheese = in.readInt();
      			wheatflour = in.readInt();
    	  		beans = in.readInt();
      			capsicum = in.readInt();
      			file.close();
      			return;
    		}
    		catch (IOException ignored) 
		{
      			// Problem during read
    		}
    		finally 
		{
      			try 
			{ 
				if (file != null) file.close(); 
			} 
 	     		catch (IOException ignored) { }
    		}
  	}

  	public void destroy() 
	{
    		saveState();
  	}

  	public void saveState() 
	{
    		// Try to save the counts
    		FileOutputStream file = null;
    		try 
		{
      			file = new FileOutputStream("PizzaInventoryServlet.state");
	      		DataOutputStream prnwriter = new DataOutputStream(file);
	      		prnwriter.writeInt(cheese);
      			prnwriter.writeInt(wheatflour);
      			prnwriter.writeInt(beans);
	      		prnwriter.writeInt(capsicum);
	      		return;
    		}
    		catch (IOException ignored) 
		{
      			// Problem during write
    		}
    		finally 
		{
      			try 
			{ 
				if (file != null) file.close(); 
			} 
      			catch (IOException ignored) { }
    		}
  	}
}