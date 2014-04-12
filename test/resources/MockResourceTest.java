package resources;

import static org.junit.Assert.*;

import model.Colony;

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
		assertNotNull(resource);
		assertTrue(resource instanceof Resource);
		
	}

}
