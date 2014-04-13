package model.components;

import model.Placeable;
import model.resources.BasicConverter;
import model.resources.ResourceConverter;
import static model.resources.Material.*;

public class HydroponicGrowingBay extends AbstractGrowingBay implements Placeable {
	
	private ResourceConverter converter;
	
	public HydroponicGrowingBay() {
		
		super("Hydroponic Growing Bay",
			  "Plants growing in a mineral or water based gel, with carefully balanced nutrients.  Without soil, plants have better protection agains under or over watering.  Water can also be reused more easily and monitored for pests and contaminants.",
			   40);		
		
		converter = new BasicConverter(AQUA_BED_IN, AQUA_BED_OUT);

	}


	@Override
	protected void doTickActions(int steps) {
		
		// Check max production
		int performance = super.getPerformancePercentage();
		converter.convert(performance);
		
	}

}
