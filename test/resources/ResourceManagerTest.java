package resources;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResourceManagerTest {

	@Test
	public void existenceTest () {
		
		ResourceManager resource = BasicResourceManager.getInstance();
		assertNotNull(resource);
		assertTrue(resource instanceof ResourceManager);
		
	}
	
	@Test
	public void emptyInstanceTest () {
		
		ResourceManager resource = BasicResourceManager.getInstance();
		
		for (ResourceType r : ResourceType.values()) {
			
			assertEquals(0, resource.takeResources(0, r));
			
		}
	}
	
	@Test
	public void boundaryTest () {
		
		ResourceManager resources = BasicResourceManager.getInstance();
		assertEquals(0, resources.checkLevel(ResourceType.BIOMASS));
		resources.addResources(100, ResourceType.BIOMASS);
		assertEquals(100, resources.checkLevel(ResourceType.BIOMASS));
		resources.takeResources(101, ResourceType.BIOMASS);
		assertEquals(0, resources.checkLevel(ResourceType.BIOMASS));
		
	}	

}
