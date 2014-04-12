package model.components;

import java.util.List;

public interface Component {

	public String getName();
	
	public String getDescription();
	
	public void setName(String newName);
	
	public int getHealth();
	
	public List<Component> getChildComponents();
}
