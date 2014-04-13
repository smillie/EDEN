package model.resources;

	// TODO - if extending this system - construct the resource list using reflection

public enum ResourceType {
	
	BIOMASS ("Food", "Stored rations, Manufactured chemical suppliments and grown produce"),
	CARBON_DIOXIDE ("Carbon Dioxide", "Exhaled by humans, required by plants"),
	MINERALS ("Minerals", "Rocks and metals avaialble for manufacturing"),
	OXYGEN ("Oxygen", "Required for breathing"),
	POWER ("Energy", "Electrical power available to do work"),
	WATER ("Water", "Mostly wet, most of the time"),
	WASTE ("Waste", "Material that might be recyclable");
	
	private String name;
	private String description;
	
	private ResourceType (String name, String description) {
		this.name = name;
		this.description = description;
		
	}
	
}
