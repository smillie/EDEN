package model.components;

import model.Placeable;
import model.resources.BasicConverter;
import model.resources.ResourceConverter;
import static model.resources.Material.*;

public class AeroponicsGrowingBay extends AbstractGrowingBay implements Placeable {

	private ResourceConverter converter;
	
	public AeroponicsGrowingBay() {
		super("Aeroponics Growing Bay",
			  "Plants grow in air or mist without soil or other medium. This form of growing allows the plant to grow unrestricted by soil space or competition.  Exposed roots allow better access to air which promotes increased uptake of carbon dioxide.",
			   30);
		
		converter = new BasicConverter(AERO_BED_IN, AERO_BED_OUT);
		
	}

	
	@Override
	protected void doTickActions(int steps) {

		// Check max production
		int performance = super.getPerformancePercentage();
		converter.convert(performance);
		
	}
	
}
