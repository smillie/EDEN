package model.resources;

public enum Material {
	
	// Name,     BIO, CO2, O2, ROK, PWR, H2O, WASTE
	PERSON_IN    (1,  0,   50, 0,   0,   2,   0),
	PERSON_OUT   (0,  50,  0,  0,   0,   0,   3),
	SOIL_BED_IN  (1,  40,  0,  1,   0,   80,  0),
	SOIL_BED_OUT (40, 0,   40, 0,   0,   40,  0),
	AQUA_BED_IN  (2,  50,  0,  0,   1,   100, 3),
	AQUA_BED_OUT (51, 0,   50, 0,   0,   52,  0),
	AERO_BED_IN  (1,  60,  0,  1,   1,   120, 0),
	AERO_BED_OUT (60, 0,   60, 0,   0,   60,  0);
	
	int biomass;
	int co2;
	int o2;
	int minerals;
	int power;
	int h2o;
	int waste;
	
	private Material (int bio, int co2, int o2, int rok, int pwr, int h2o, int waste) {
		
		this.biomass = bio;
		this.co2 = co2;
		this.o2 = o2;
		this.minerals = rok;
		this.power = pwr;
		this.h2o = h2o;
		this.waste = waste;
		
	}

}
