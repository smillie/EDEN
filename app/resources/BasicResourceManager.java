package resources;

import java.util.Map;

public class BasicResourceManager implements ResourceManager{
	
	private static BasicResourceManager resourceManagerInstance;
	private Map<ResourceType, ResourceStorage> resourceMap;

	
	private BasicResourceManager () {
		
		for (ResourceType type : ResourceType.values()) {
			
			resourceMap.put(type, new ResourceStorage(type));
		
		}
		
	}
	
	
	public static ResourceManager getInstance () {
		
		if (resourceManagerInstance == null) {
			
			resourceManagerInstance = new BasicResourceManager();
			
		}
		
		return resourceManagerInstance;
		
	}

	
	@Override
	public int getResource(int amount, ResourceType resource) {
		
		if(resourceMap.containsKey(resource)) {
			
			return resourceMap.get(resource).getCount();
			
		}
		
		return 0;
	}
	
}
