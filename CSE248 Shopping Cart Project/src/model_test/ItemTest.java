package model_test;
import model.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {
	
	@Test
	public void testCreateItem() {
		StoreDataBase storage = new StoreDataBase();
		Item apple = new Item("Apple",0, 9.99, "food", false, 3);
		System.out.println(apple.calculateTax());
		System.out.println(apple.calculateTax() + apple.getPrice());
		assertEquals(0.85,apple.calculateTax(),0.05);
		
		
		/*
		 * 	this.productName = productName;
		this.price = price;
		this.taxable = taxable;
		this.stock = stock;
		this.category = category;
		this.itemID = 0;
		 */
		
		assertEquals("Apple", apple.getProductName());
		assertEquals(9.99,apple.getPrice(), 0.01);
		assertEquals(false,apple.isTaxable());
		assertEquals(3,apple.getStock());
		assertEquals("food",apple.getCategory());
		assertEquals(0,apple.getItemID());
	}
	
	
	
	@Test 
	public void testAddToStock() {
		Item apple = new Item("Apple",0, 1.0, "food", false, 3);
		assertEquals(3,apple.getStock());
		apple.addToStock(1);
		assertEquals(4,apple.getStock());
	}
	
	
	
	
	
}
