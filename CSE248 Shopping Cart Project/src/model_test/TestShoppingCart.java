package model_test;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.*;

public class TestShoppingCart {
	
	@Test
	public void testShoppingCartEditing() {

		Item item = new Item("Apple", 0, 60.0, "Food", true, 2);
		Item item2 = new Item("Grape", 1, 60.0, "Food", true, 5);
		
		ShoppingCart sc = new ShoppingCart();
		sc.addItemToCart(item);
		sc.addItemToCart(item2);
		System.out.println(sc.getItemsInCart());
		sc.emptyCart();
		System.out.println(sc.getItemsInCart());
		System.out.println(item.getPrice());
		
		
		
		sc.addItemToCart(item);
		sc.addItemToCart(item2);
		sc.removeItemFromCart(item);
		System.out.println(sc.getItemsInCart());
		
	}
	
	@Test
	public void totalCartCalculationTest() {
		Item item = new Item("Apple", 0, 60.0, "Food", true, 2);
		Item item2 = new Item("Grape", 1, 60.0, "Food", true, 5);
		
		ShoppingCart sc = new ShoppingCart();
		sc.addItemToCart(item);
		sc.addItemToCart(item2);
		System.out.println("total price: " + sc.totalPriceCalculation());
		assertEquals(130.50,sc.totalPriceCalculation(),0.001);
		
	}
	
	
	


}