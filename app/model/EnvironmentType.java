package model;

public enum EnvironmentType {

	EARTH ("Earth", "Home!  A watery planet with a protective antmosphere.", 1.0f, 0.3f, 0.0f, 0.1f),
	MARS ("Mars", "An arid, cold planet with a thin atmosphere.", 1.2f, 0.5f, 0.3f, 0.2f),
	MOON ("Moon","A barren satellite of Earth.", 0.8f, 0f, 0.8f, 0.89f);
	
	private String name;
	private String description;
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public float getLightLvel() {
		return lightLevel;
	}

	public float getWeatherChance() {
		return weatherChance;
	}

	public float getCritterChance() {
		return critterChance;
	}

	public float getQuakeChance() {
		return quakeChance;
	}

	private float lightLevel;
	private float weatherChance;
	private float critterChance;
	private float quakeChance;
	
	private EnvironmentType (String name, String description, float lightLevel, float weatherChance, float critterChance, float quakeChance) {
		this.name = name;
		this.description = description;
		this.lightLevel = lightLevel;
		this.weatherChance = weatherChance;
		this.critterChance = critterChance;
		this.quakeChance = quakeChance;
		
		
	}
	
}
