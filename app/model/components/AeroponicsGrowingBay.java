package model.components;

import model.Placeable;

public class AeroponicsGrowingBay extends AbstractGrowingBay implements Placeable {

	public AeroponicsGrowingBay() {
		super("Aeroponics Growing Bay",
			  "Plants grow in air",
			   30);
		
		//TODO - technical description
		//TODO - growing methods
	}

	@Override
	protected void doTickActions(int steps) {
		// TODO Auto-generated method stub
		
	}
	


}
