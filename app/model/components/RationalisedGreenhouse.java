package model.components;

import model.Placeable;

public class RationalisedGreenhouse extends AbstractGreenhouse implements Placeable{

	public RationalisedGreenhouse() {
		
		super("Rationalised Greenhouse",
			  "A robust, highly modular design using the latest materials specifically for use as a greenhouse.  This module is formed from a minimal number of interchangable parts, and is so easy to maintain it practically repairs itself!",
			  150);
		
	}

	
	@Override
	protected void doTickActions(int steps) {
		super.doRepair(1);
	}
	
}
