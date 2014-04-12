package resources;


public class BasicResourceManager implements ResourceManager{
	
	private static BasicResourceManager resourceManagerInstance;

	private BasicResourceManager () {
		
	}
	
	public static ResourceManager getInstance () {
		
		if (resourceManagerInstance == null) {
			
			resourceManagerInstance = new BasicResourceManager();
			
		}
		
		return resourceManagerInstance;
		
	}

	@Override
	public int getResource(int amount, ResourceType resource) {

		return 0;
	}
	
}
