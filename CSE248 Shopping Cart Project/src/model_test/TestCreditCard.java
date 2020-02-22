package model_test;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.*;


public class TestCreditCard {
	
	@Test
	public void testCreditCard() {
		CreditCard cc = new CreditCard("1234 1234 1234", 123, 1212);
		assertEquals("1234 1234 1234", cc.getCardNumber());
		assertEquals(123,cc.getSecurityCode());
		assertEquals(1212,cc.getExpirationDate());
	}

}
