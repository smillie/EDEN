package model.components;

import resources.ResourceType;

public abstract class AbstractGreenhouse extends AbstractComponent {	
	
	private static final int DEFAULT_MAX_GREENHOUSE_HEALTH = 100;
	
	public AbstractGreenhouse (String name, String description, int maxHealth) {
		
		super (name, description, safeHealth(maxHealth));
		
	}
	
	
	private static int safeHealth (int health) {
		
		return (health > 0) ? health : DEFAULT_MAX_GREENHOUSE_HEALTH;
		
	}
	
	
	public int loseResources (int count, ResourceType resource) {
		
		return super.getResourceManager().takeResources(count, resource);
		
	}
	
	public void gainResources (int count, ResourceType resource) {
		
		super.getResourceManager().addResources(count, resource);
		
	}


}
