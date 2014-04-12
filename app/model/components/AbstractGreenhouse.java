package model.components;

public class AbstractGreenhouse extends AbstractComponent {	
	
	private static final int DEFAULT_MAX_GREENHOUSE_HEALTH = 100;
	
	public AbstractGreenhouse (String name, String description, int maxHealth) {
		
		super (name, description, safeHealth(maxHealth));
		
	}
	
	
	private static int safeHealth (int health) {
		
		return health > 0 ? health : DEFAULT_MAX_GREENHOUSE_HEALTH;
		
	}

}
