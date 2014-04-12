package model.components;

public interface ComponentFactory {

	public Component getInflatableGreenhouse ();
	
	public Component getFlatPackedGreenHouse ();
	
	public Component getRationalisedGreenHouse ();
	
	public Component getSoilGrowingBay();
	
	public Component getHydroponicGrowingBay();
	
	public Component getAeroponicsGrowingBay();

}
