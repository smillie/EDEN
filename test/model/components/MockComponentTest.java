package model.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class MockComponentTest {

	@Test
	public void existenceTest() {
		
		Component component = new MockComponent("mock!", "description!",0);
		assertNotNull(component);
		assertTrue(component instanceof MockComponent);
		
	}
	
	
	@Test
	public void initialisationZeroHealthTest() {
		
		Component component = new MockComponent("mock!", "description!",0);
		assertEquals("mock!", component.getName());
		assertEquals(10, component.getHealth());
		assertEquals("description!", component.getDescription());
		
	}
	
	@Test
	public void initialisationNegativeHealthTest() {
		
		Component component = new MockComponent("mock!", "description!",-10);
		assertEquals("mock!", component.getName());
		assertEquals(10, component.getHealth());
		assertEquals("description!", component.getDescription());
		
	}
	
	@Test
	public void initialisationHundredHealthTest() {
		
		Component component = new MockComponent("mock!", "description!",100);
		assertEquals("mock!", component.getName());
		assertEquals(100, component.getHealth());
		assertEquals("description!", component.getDescription());
		
	}
	
	@Test
	public void damageTest() {
		
		Component component = new MockComponent("mock!", "description!",100);
		assertEquals(100, component.getHealth());
		component.doDamage(10);
		assertEquals(90, component.getHealth());
		
	}
	
	@Test
	public void repairTest() {
		
		Component component = new MockComponent("mock!", "description!",100);
		assertEquals(100, component.getHealth());
		component.doDamage(10);
		assertEquals(90, component.getHealth());
		component.doRepair(5);
		assertEquals(95, component.getHealth());
		
	}
	
	@Test
	public void damageEdgeTest() {
		
		Component component = new MockComponent("mock!", "description!",100);
		assertEquals(100, component.getHealth());
		component.doDamage(101);
		assertEquals(0, component.getHealth());
		
	}
	
	@Test
	public void repairEdgeTest() {
		
		Component component = new MockComponent("mock!", "description!",100);
		assertEquals(100, component.getHealth());
		component.doDamage(10);
		assertEquals(90, component.getHealth());
		component.doRepair(11);
		assertEquals(100, component.getHealth());
		
	}
	
}
