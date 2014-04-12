package model.components;

import model.Placeable;

public class SoilGrowingBay extends AbstractGrowingBay implements Placeable {

	public SoilGrowingBay() {
		
		super("Soil Growing Bay", 
			  "Plants growing in a bucket of soil - just like home!",
			  60);
	
	}

	@Override
	public void tick(int steps) {
		// TODO Auto-generated method stub
		
	}
	
	// TODO technical details
	// TODO growing rules
}
