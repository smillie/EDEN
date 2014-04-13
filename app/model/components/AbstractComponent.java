package model.components;

import java.util.ArrayList;
import java.util.List;

import model.ConcreteEnvironment;
import model.Environment;
import model.resources.BasicResourceManager;
import model.resources.ResourceManager;

import com.google.gson.annotations.Expose;

public abstract class AbstractComponent implements Component {

	private final int DEFAULT_MAX_HEALTH = 10;
	private ResourceManager resources;
	private Environment environment;
	
	@Expose private List<Component> childComponents;
	@Expose private final String name;
	@Expose private final String description;
	@Expose private final int maxHealth;
	@Expose private int currentHealth;
	
	
	public AbstractComponent (String name, String description, int maxHealth) {
		
		childComponents = new ArrayList<Component>();
		resources = BasicResourceManager.getInstance();
		environment = ConcreteEnvironment.getInstance();
		
		this.name = name;
		this.description = description;
		this.maxHealth = (maxHealth < DEFAULT_MAX_HEALTH) ? DEFAULT_MAX_HEALTH : maxHealth;
		currentHealth = this.maxHealth;
		
	}
	
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
		
		// TODO - is this safety allowing wrong behaviour?
		int newHealth = currentHealth-Math.abs(damageAmount);
		
		if (newHealth >= 0) {
			
			currentHealth = newHealth;
			
		} else {
			
			currentHealth = 0;
			
		}
		
	}
	
	@Override
	public void doRepair (int healthRepaired) {
		
		// TODO - is this safety allowing wrong behaviour?
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


	@Override
	public boolean addComponent(Component component, String parent) {
		
		boolean reply = false;
		
		if (parent.equalsIgnoreCase(name)) {
			
			reply =  childComponents.add(component);
			
		} else {
			
			// Pass it down the tree
			for (Component c : childComponents) {
				
				boolean childReply = c.addComponent(component, parent);
			
				if (childReply) {
					reply = true;
					break;
				}
			}
			
		}
		
		return reply;
		
	}
	
	
	@Override
	public void removeComponent (Component component) {
		
		if (childComponents.contains(component)) {
			
			childComponents.remove(component);
		
		} else {
			
			for (Component c : childComponents) {
				
				c.removeComponent(component);
				
			}
			
		}
		
	}
	
	@Override
	public ResourceManager getResourceManager () {
	
		return resources;
		
	}
	
	@Override
	public Environment getEnvironment () {
		
		return environment;
		
	}
	
	
	@Override
	public final void tick (int steps) {
		
		doTickActions(steps);
		
		for (Component c : childComponents) {
			
			c.tick(steps);
		
		}
		
	}
	
	protected abstract void doTickActions (int steps);


}
