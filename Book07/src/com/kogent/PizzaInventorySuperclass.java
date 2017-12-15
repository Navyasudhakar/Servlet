package com.kogent;

import javax.servlet.http.*;

public class PizzaInventorySuperclass extends HttpServlet 
{
  	protected static PizzaInventory inventory = PizzaInventory.getInstance();
}
