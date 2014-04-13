package model.components;

import model.Placeable;

public class RationalisedGreenhouse extends AbstractGreenhouse implements Placeable{

	public RationalisedGreenhouse() {
		
		super("Rationalised Greenhouse",
			  "A robust, highly modular design using the latest materials formed into a minimal number of reusable parts," +
			  "easy to repair and maintain",
			  150);
		
		// TODO technical description
		// TODO growing methods
	}

	
	@Override
	protected void doTickActions(int steps) {
		super.doRepair(1);
	}
	


}
