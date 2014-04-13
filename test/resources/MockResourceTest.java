package resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import model.resources.Resource;

import org.junit.Test;

public class MockResourceTest {

	@Test
	public void existenceTest () {
		
		Resource resource = new MockResource();
		assertNotNull(resource);
		assertTrue(resource instanceof Resource);
		
	}
	
	
	@Test
	public void initialisationTest () {
		
		Resource resource = new MockResource();
		assertEquals("mockResource", resource.getName());
		assertEquals("mockResourceDescription", resource.getDescription());
		assertEquals(0, resource.getAmount());
		
	}

}
