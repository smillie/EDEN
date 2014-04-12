package model.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Placeable;

import org.reflections.Reflections;

public class ComponentFactory {

	public static Component getInflatableGreenhouse () {
		
		return new InflatableGreenhouse();
		
	}
	
	public static Component getFlatPackedGreenHouse (){
	
		return new FlatPackedGreenhouse();
	
	}
	
	public static Component getRationalisedGreenHouse () {
		
		return new RationalisedGreenhouse();
		
	}
	
	public static Component getSoilGrowingBay() {
		
		return new SoilGrowingBay();
		
	}
	
	public static Component getHydroponicGrowingBay() {
	
		return new HydroponicGrowingBay();
		
	}
	
	public static Component getAeroponicsGrowingBay() {
		
		return new AeroponicsGrowingBay();
		
	}
	
	public static List<Placeable> listAll() {
		Reflections reflections = new Reflections("model.components");
		Set<Class<? extends Placeable>> subTypes = reflections.getSubTypesOf(Placeable.class);
		
		List<Placeable> components = new ArrayList<Placeable>();
		for (Class<? extends Placeable> s: subTypes) {
			try {
				components.add(s.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		

		return components;
	}

}
