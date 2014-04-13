package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

import model.components.Component;

public class Colony {
	
	@Expose private List<Component> children;
	@Expose private String name;
	
	public Colony (String name) {
		
		children = new ArrayList<Component>();
		this.name = (name == null) ? "colony" : name;
		
	}
	
	
	public String getName () {
		
		return new String (name);
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean addComponent(Component component) {
		
		return addComponent(component, name);
		
	}
	
	
	public boolean addComponent(Component component, String parent) {
		
		boolean reply = false;
		
		if (parent.equals(name)) {
			
			reply =  children.add(component);
			
		} else {
			
			// Pass it down the tree
			for (Component c : children) {
				
				boolean childReply = c.addComponent(component, parent);
			
				if (childReply) {
					reply = true;
					break;
				}
			}
			
		}
		
		return reply;
		
	}
	
	
	public void removeComponent(Component component) {
		
		if(children.contains(component)) {
			
			children.remove(component);
		
		} else {
			
			for (Component c : children) {
			
				c.removeComponent(component);
			
			}
		
		}
		
	}


	public void tick(int steps) {
		
		doTickActions(steps);
		
		for (Component c : children) {
			
			c.tick(steps);
		
		}
		
	}
	
	
	private void doTickActions (int steps) {
		
	}
	
}
