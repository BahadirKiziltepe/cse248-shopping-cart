package model_test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import model.Address;
public class TestAddress {
	
	@Test
	public void testAddressCreation() {
		
		/*
		 * private String street;
	private String state;
	private String city;
	private String zipCode;
	private String country;
		 */
		
		Address add = new Address("street","state","city","zipcode","country");
		assertEquals("street",add.getStreet());
		assertEquals("state",add.getState());
		assertEquals("city",add.getCity());
		assertEquals("zipcode",add.getZipCode());
		assertEquals("country",add.getCountry());
		
		
	}
	
}
