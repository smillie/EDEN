package model.components;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

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
	
	@Expose private List<Component> childComponents;
	
	@Expose private final String name;
	@Expose private final String description;
	@Expose private final int maxHealth;
	@Expose private int currentHealth;
	
	
	public AbstractComponent (String name, String description, int maxHealth) {
		
		childComponents = new ArrayList<Component>();
		
		this.name = name;
		this.description = description;
		this.maxHealth = (maxHealth < DEFAULT_MAX_HEALTH) ? DEFAULT_MAX_HEALTH : maxHealth;
		currentHealth = this.maxHealth;
		
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
		
		int newHealth = currentHealth-Math.abs(damageAmount);
		
		if (newHealth >= 0) {
			
			currentHealth = newHealth;
			
		} else {
			
			currentHealth = 0;
			
		}
		
	}
	
	@Override
	public void doRepair (int healthRepaired) {
		
		int newTotal = currentHealth + Math.abs(healthRepaired);
		
		if (newTotal <= maxHealth) {
			
			currentHealth = newTotal;
			
		} else {
			
			currentHealth = maxHealth;
			
		}
		
	}


	@Override
	public List<Component> getChildren () {

		return childComponents;
		
	}



}
