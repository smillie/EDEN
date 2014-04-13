package resources;


public interface ResourceManager {
	
	void addResources(int amount, ResourceType resource);
	
	int takeResources(int amount, ResourceType resource);

	int checkLevel(ResourceType biomass);
	
}
