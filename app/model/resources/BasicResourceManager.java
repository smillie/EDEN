package model.resources;

import java.util.Map;
import java.util.HashMap;
import com.google.gson.annotations.Expose;

public class BasicResourceManager implements ResourceManager{
	
	private static BasicResourceManager resourceManagerInstance;
	@Expose private Map<ResourceType, ResourceStorage> resourceMap;

	
	private BasicResourceManager () {
		
		resourceMap = new HashMap<ResourceType, ResourceStorage>();
		
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
	public int takeResources(int amount, ResourceType resource) {
		
		if(resourceMap.containsKey(resource)) {
			
			return resourceMap.get(resource).takeResource(amount);
			
		}
		
		return 0;
		
	}


	@Override
	public void addResources(int amount, ResourceType resource) {

		resourceMap.get(resource).addResource(amount);
		
	}


	@Override
	public int checkLevel(ResourceType resource) {

		return resourceMap.get(resource).getCount();
		
	}
	
}
