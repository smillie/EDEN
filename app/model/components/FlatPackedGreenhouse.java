package model.components;

import resources.ResourceType;
import static resources.ResourceType.*;
import model.Placeable;

public class FlatPackedGreenhouse extends AbstractGreenhouse implements Placeable {

	public FlatPackedGreenhouse() {
		super("Flat Packed Greenhouse",
			  "A sturdy greenhouse made of rigid panels",
			  100);
	}

	@Override
	protected void doTickActions(int steps) {
		super.loseResources(1, WATER);
		super.gainResources(1, WASTE);
		
	}
	
	//TODO technical background
	//TODO growing rules

}
