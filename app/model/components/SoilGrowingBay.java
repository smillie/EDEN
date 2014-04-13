package model.components;

import model.Placeable;
import model.resources.BasicConverter;
import model.resources.ResourceConverter;
import static model.resources.Material.*;

public class SoilGrowingBay extends AbstractGrowingBay implements Placeable {
	
	private ResourceConverter converter;
	
	public SoilGrowingBay() {
		
		super("Soil Growing Bay", 
			  "Plants growing in a big pot of soil - just like home!",
			  60);
		
		// TODO technical details
		// TODO growing rules
		
		converter = new BasicConverter(SOIL_BED_IN, SOIL_BED_OUT);
	
	}

	@Override
	protected void doTickActions(int steps) {
		
		// Check max production
		int performance = super.getPerformancePercentage();
		converter.convert(performance);
		
	}

}
