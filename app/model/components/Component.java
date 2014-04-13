package model.components;

import java.util.List;

import model.Environment;
import model.resources.ResourceManager;

public interface Component {

	public String getName ();
	
	public String getDescription ();
	
	public int getHealth ();
	
	public void doDamage (int damageAmount);
	
	public void doRepair (int repairAmount);
	
	public List<Component> getChildren();

	public boolean addComponent (Component component, String parent);
	
	public void removeComponent (Component component);

	public void tick (int steps);

	public ResourceManager getResourceManager();

	public Environment getEnvironment();
}
