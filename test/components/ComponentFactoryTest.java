package components;

import static org.junit.Assert.*;
import model.Colony;
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
