package model.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Placeable;

import org.reflections.Reflections;

import play.Logger;

public class ComponentFactory {
	
	public static Component get(String name) {
		Component component = null;
		
		try {
			component = (Component) Class.forName("model.components."+name).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			Logger.error("Cannot create component "+name);
		}
		
		return component;
	}
	
	public static List<Placeable> listAll() {
		Reflections reflections = new Reflections("model.components");
		Set<Class<? extends Placeable>> subTypes = reflections.getSubTypesOf(Placeable.class);
		
		List<Placeable> components = new ArrayList<Placeable>();
		for (Class<? extends Placeable> s: subTypes) {
			try {
				components.add(s.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			} 
		}
		

		return components;
	}

}
