package model.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class InflatableGreenhouseTest {

	@Test
	public void existsTest() {
		
		Component component = new InflatableGreenhouse();
		assertNotNull(component);
		assertTrue(component instanceof InflatableGreenhouse);
		
	}
	
	@Test
	public void initialhealthTest() {
		
		AbstractGreenhouse component = new InflatableGreenhouse();
		assertEquals(50, component.getHealth());
		
	}
	
	@Test
	public void lowerBoundHealthTest() {
		
		Component component = new InflatableGreenhouse();
		component.doDamage(100);
		assertEquals(0, component.getHealth());
		
	}

}
