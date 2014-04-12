package model.components;

public class ComponentFactory {

	public static Component getInflatableGreenhouse () {
		
		return new InflatableGreeHouse();
		
	}
	
	public static Component getFlatPackedGreenHouse (){
	
		return new FlatPackedGreenHouse();
	
	}
	
	public static Component getRationalisedGreenHouse () {
		
		return new RationalisedGreenHouse();
		
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
