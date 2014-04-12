package model.components;

public class AbstractGreenHouse extends AbstractComponent {

	private final int DEFAULT_MAX_HEALTH = 100;
	
	private final int maxHealth;
	private int currentHealth;
	
	
	public AbstractGreenHouse (int maxHealth) {
		
		this.maxHealth = maxHealth > 0 ? maxHealth : DEFAULT_MAX_HEALTH;
		
	}
	
	
	public void repair (int healthRepaired) {
		
		int newTotal = currentHealth + healthRepaired;
		
		if (newTotal <= maxHealth) {
			
			currentHealth = newTotal;
			
		}
		
	}
	
	
	@Override
	public int getHealth() {
	
		return currentHealth;
		
	}

}
