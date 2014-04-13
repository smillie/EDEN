package model;

public class ConcreteEnvironment implements Environment {
	
	private static Environment environmentInstance;
	
	private EnvironmentType environmentType;

	private ConcreteEnvironment () {
		
	}
	
	public static Environment getInstance () {
		
		if (environmentInstance == null) {
			environmentInstance = new ConcreteEnvironment();
		}
		return environmentInstance;
		
	}
	
	public void setEnvironment(String name) {
		
		for (EnvironmentType e: EnvironmentType.values()) {
			if (e.getName().equals(name)) {
				environmentType = e;
			}
		}
		
	}

	@Override
	public String getName() {
		return environmentType.getName();
	}

	@Override
	public String getWeatherType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		return environmentType.getDescription();
	}
	
}
