package resources;

public class ResourceStorage {
	
	private ResourceType resource;
	private int count;
	
	
	public ResourceStorage(ResourceType resourceType) {
		
		this.resource = resourceType;
		this.count = 0;
		
	}
	
	
	public ResourceStorage (ResourceType resourceType, int count) {
		
		this.resource = resourceType;
		this.count = count;
		
	}
	
	
	public boolean storesResource (ResourceType resourceType) {
		
		return (this.resource == resourceType);
		
	}

	
	public int getCount () {
		
		return count;
		
	}
	
	
	public void addResource (int count) {
		
		if (count > 0) {
			
			this.count += count;
		
		}
	
	}
	
	
	public int takeResource (int amount) {
		
		if (amount <= count) {
			
			count -= amount;
			return amount;
			
		} else {
			
			count = 0;
			return amount;
			
		}
		
	}
	
}
