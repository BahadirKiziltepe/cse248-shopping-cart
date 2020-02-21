package model_test;
import model.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {
	
	@Test
	public void testCreateItem() {
		StoreDataBase storage = new StoreDataBase();
		Item item = new Item("Basic Item", 59.99, "food", true, 3);
		//assertEquals("Basic Item","Basic Item");
	}
}
