package model;

import java.util.List;

import model.components.Component;

public class Colony {
	
	List<Component> components;
	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;
	
	
	
	public void addComponent(Component component, String parent) {
		//TODO
	};
	
	public void removeComponent(Component component, String parent) {
		//TODO
	};
}
