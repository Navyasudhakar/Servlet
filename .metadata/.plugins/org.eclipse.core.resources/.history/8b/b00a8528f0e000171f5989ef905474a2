package com.kogent;

public class PizzaInventory 
{

  	// Protect the constructor, so no other class can call it
  	private PizzaInventory() { }

  	// Create the only instance, save it to a private static variable
  	private static PizzaInventory instance = new PizzaInventory();

  	// Make the static instance publicly available
  	public static PizzaInventory getInstance() { return instance; }

  	// How many "servings" of each item do we have?
  	private int cheese = 0;
  	private int wheatflour = 0;
  	private int beans = 0;
  	private int capsicum = 0;

  	// Add to the inventory
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
}
