package model;

import static org.junit.Assert.*;

import model.components.Component;
import model.components.MockComponent;

import org.junit.Test;

public class ColonyTest {

	@Test
	public void existenceTest() {
		
		Colony colony = new Colony("testColony");
		assertNotNull(colony);
		assertTrue(colony instanceof Colony);
		
	}
	
	@Test
	public void nameTest() {
		
		Colony colony = new Colony("testColony");
		assertEquals("testColony", colony.getName());
		
	}
	
	@Test
	public void addComponentTest() {
		
		Colony colony = new Colony("testColony");
		MockComponent mock = new MockComponent();
		assertTrue(colony.addComponent(mock));
		
	}

}
