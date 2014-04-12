package model.components;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractComponent implements Component {

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

}
