package model.components;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import model.components.Component;
import model.components.ComponentFactory;

import org.junit.Test;

public class ComponentFactoryTest {

	
	@Test
	public void existenceTest() {
		
		Component component = ComponentFactory.get("SoilGrowingBay");
		assertNotNull(component);
		assertTrue(component instanceof Component);
		
	}
	
}
