package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

import model.components.Component;
import model.resources.BasicConverter;
import model.resources.BasicResourceManager;
import model.resources.ResourceConverter;
import model.resources.ResourceManager;

import static model.resources.Material.*;
import static model.resources.ResourceType.*;

public class Colony {
	
	@Expose private List<Component> components;
	@Expose private String name;
	@Expose private int population;
	ResourceConverter personConverter = new BasicConverter(PERSON_IN, PERSON_OUT);
	
	public Colony (String name) {
		
		components = new ArrayList<Component>();
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
			
			reply =  components.add(component);
			
		} else {
			
			// Pass it down the tree
			for (Component c : components) {
				
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
		
		if(components.contains(component)) {
			
			components.remove(component);
		
		} else {
			
			for (Component c : components) {
			
				c.removeComponent(component);
			
			}
		
		}
		
	}


	public void tick(int steps) {
		
		doTickActions(steps);
		
		for (Component c : components) {
			
			c.tick(steps);
		
		}
		
	}
	
	
	private void doTickActions (int steps) {
		
		for (int i = 0; i < steps; i++) {
		
			int supported = doPopulationConsumption (population);
			
			if (population > supported) {
				
				population = supported + ((population-supported)/2);
				
			}
	
		}
		
		if (doPopulationGrowth()) {
			population++;
		}
		
	}
	
	
	private boolean doPopulationGrowth() {
		
		ResourceManager resources = BasicResourceManager.getInstance();
		
		return (resources.checkLevel(BIOMASS) > PERSON_IN.biomass*10) &&
				(resources.checkLevel(WATER) > PERSON_IN.h2o*10) &&
				 (resources.checkLevel(OXYGEN) > PERSON_IN.o2*10);
				
		
	}


	private int doPopulationConsumption (int pop) {
		
		int persisted = 0;
		
		for (int i = 0; i < pop; i++) {
			
			if (personConverter.convert(100)) {
				persisted++;
			}
			
		}
		
		return persisted;
		
	}
	
}
