package model_test;
import org.junit.jupiter.api.Test;

import model.*;

public class TestShoppingCart {
	
	@Test
	public void testShoppingCartEditing() {

		Item item = new Item("Apple", 0, 0.50, "Food", false, 2);
		Item item2 = new Item("Grape", 1, 0.50, "Food", false, 5);
		
		ShoppingCart sc = new ShoppingCart();
		sc.addItemToCart(item);
		sc.addItemToCart(item2);
		System.out.println(sc.getItemsInCart());
		sc.emptyCart();
		System.out.println(sc.getItemsInCart());
		
		sc.addItemToCart(item);
		sc.addItemToCart(item2);
		sc.removeItemFromCart(item);
		System.out.println(sc.getItemsInCart());
		
	}
	
	
	


}
