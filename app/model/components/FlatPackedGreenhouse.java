package model.components;

import static model.resources.ResourceType.WASTE;
import static model.resources.ResourceType.WATER;
import model.Placeable;

public class FlatPackedGreenhouse extends AbstractGreenhouse implements Placeable {

	public FlatPackedGreenhouse() {
		super("Flat Packed Greenhouse",
			  "A sturdy greenhouse made of rigid panels.  This generally useful space is not designed for easy transport and assembly and is a bit stronger than an inflatable greenhouse.  Inefficiencies cause a bit more waste.",
			  100);
	}

	@Override
	protected void doTickActions(int steps) {
		super.loseResources(1, WATER);
		super.gainResources(1, WASTE);
		
	}

}
