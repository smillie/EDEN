package model.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class RationalisedGreenhouseTest {

	@Test
	public void existsTest() {
		
		Component component = new RationalisedGreenhouse();
		assertNotNull(component);
		assertTrue(component instanceof RationalisedGreenhouse);
		
	}
	
	@Test
	public void initialhealthTest() {
		
		AbstractGreenhouse component = new RationalisedGreenhouse();
		assertEquals(150, component.getHealth());
		
	}
	
	@Test
	public void lowerBoundHealthTest() {
		
		Component component = new RationalisedGreenhouse();
		component.doDamage(200);
		assertEquals(0, component.getHealth());
		
	}

}
