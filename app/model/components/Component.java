package model.components;

import java.util.List;

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
}
