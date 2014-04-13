package model.components;

import model.Placeable;

public class SoilGrowingBay extends AbstractGrowingBay implements Placeable {

	public SoilGrowingBay() {
		
		super("Soil Growing Bay", 
			  "Plants growing in a bucket of soil - just like home!",
			  60);
		
		// TODO technical details
		// TODO growing rules
	
	}

	@Override
	protected void doTickActions(int steps) {
		// TODO Auto-generated method stub
		
	}

}
