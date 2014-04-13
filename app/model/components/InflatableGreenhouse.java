package model.components;

import resources.Resource;
import resources.ResourceType;
import model.Placeable;

public class InflatableGreenhouse extends AbstractGreenhouse implements Placeable {

	public InflatableGreenhouse() {
		super("Inflatable Greenhouse",
			  "",
			  50);
	}
	

	@Override
	protected void doTickActions(int steps) {
		
		// Leaks air
		super.loseResources(1, ResourceType.OXYGEN);
		super.loseResources(1, ResourceType.CARBON_DIOXIDE);
		
		
	}

}
