package model.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class MockComponentTest {

	@Test
	public void existenceTest() {
		
		Component component = new MockComponent("mock!", "description!");
		assertNotNull(component);
		assertTrue(component instanceof MockComponent);
		
	}
	
	
	@Test
	public void initialisationTest() {
		
		Component component = new MockComponent("mock!", "description!");
		assertTrue(component);
		
		
	}
	
}
