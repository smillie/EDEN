package model.components;

import model.Placeable;

public class SoilGrowingBay extends AbstractGrowingBay implements Placeable {
	
	public SoilGrowingBay() {
		
		super("Soil Growing Bay", 
			  "Plants growing in a big pot of soil - just like home!",
			  60);
		
		// TODO technical details
		// TODO growing rules
	
	}

	@Override
	protected void doTickActions(int steps) {
		
		// Check max production
		int performance = super.getPerformancePercentage();
		
		
		// Check resources
		
		
		// TODO Optional waste conversion
		
		// Do consume
		
		// Do produce
		
	}

}
