package model_test;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.*;


public class TestName {
	
	@Test
	public void testName() {
		Name name = new Name("first","last","middle");
		assertEquals("first",name.getFirstName());
		assertEquals("last",name.getLastName());
		assertEquals("middle",name.getMiddleName());
	}
}
