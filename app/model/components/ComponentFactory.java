package model.components;

public class ComponentFactory {

	public static Component getInflatableGreenhouse () {
		
		return new InflatableGreenhouse();
		
	}
	
	public static Component getFlatPackedGreenHouse (){
	
		return new FlatPackedGreenhouse();
	
	}
	
	public static Component getRationalisedGreenHouse () {
		
		return new RationalisedGreenhouse();
		
	}
	
	public static Component getSoilGrowingBay() {
		
		return new SoilGrowingBay();
		
	}
	
	public static Component getHydroponicGrowingBay() {
	
		return new HydroponicGrowingBay();
		
	}
	
	public static Component getAeroponicsGrowingBay() {
		
		return new AeroponicsGrowingBay();
		
	}

}
