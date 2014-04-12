package model.components;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractComponent implements Component {

	public List<Component> getChildComponents() {
		return childComponents;
	}


	public void setChildComponents(List<Component> childComponents) {
		this.childComponents = childComponents;
	}


	public int getCurrentHealth() {
		return currentHealth;
	}


	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}


	public int getMaxHealth() {
		return maxHealth;
	}


	private final int DEFAULT_MAX_HEALTH = 10;
	
	private List<Component> childComponents;
	
	private final String name;
	private final String description;
	private final int maxHealth;
	private int currentHealth;
	
	
	public AbstractComponent (String name, String description, int maxHealth) {
		
		childComponents = new ArrayList<Component>();
		
		this.name = name;
		this.description = description;
		this.maxHealth = maxHealth < DEFAULT_MAX_HEALTH ? DEFAULT_MAX_HEALTH : maxHealth;
		currentHealth = maxHealth;
		
	}
	
	
	@Override
	public String getName () {
		
		return new String (name);
		
	}

	@Override
	public int getHealth () {
	
		return currentHealth;
		
	}
	
	@Override
	public String getDescription () {
		
		return new String (description);
		
	}
	
	@Override
	public void doDamage (int damageAmount) {
		
		//TODO
		
	}
	
	@Override
	public void doRepair (int healthRepaired) {
		
		int newTotal = currentHealth + healthRepaired;
		
		if (newTotal <= maxHealth) {
			
			currentHealth = newTotal;
			
		}
		
	}


	@Override
	public List<Component> getChildren () {

		return childComponents;
		
	}



}
