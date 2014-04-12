package model.components;

import model.Placeable;

public class HydroponicGrowingBay extends AbstractGrowingBay implements Placeable {

	public HydroponicGrowingBay() {
		
		super("Hydroponic Growing Bay",
			  "Plants growing in a regulated nutrient gel",
			   40);
		
	}

	@Override
	public void tick(int steps) {
		// TODO Auto-generated method stub
		
	}
	
	// TODO technical details
	// TODO growing rules
	
}
