package model.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlatPackedGreenhouseTest {

	@Test
	public void existsTest() {
		
		Component component = new FlatPackedGreenhouse();
		assertNotNull(component);
		assertTrue(component instanceof FlatPackedGreenhouse);
		
	}
	
	@Test
	public void initialhealthTest() {
		
		AbstractGreenhouse component = new FlatPackedGreenhouse();
		assertEquals(100, component.getHealth());
		
	}
	
	@Test
	public void lowerBoundHealthTest() {
		
		Component component = new FlatPackedGreenhouse();
		component.doDamage(150);
		assertEquals(0, component.getHealth());
		
	}

}
