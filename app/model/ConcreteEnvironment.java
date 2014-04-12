package model;

public class ConcreteEnvironment implements Environment {
	
	private static Environment environmentInstance;

	private ConcreteEnvironment () {
		
	}
	
	public static Environment getInstance () {
		
		if (environmentInstance == null) {
			
			environmentInstance = new ConcreteEnvironment();
			
		}
		
		return environmentInstance;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWeatherType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
