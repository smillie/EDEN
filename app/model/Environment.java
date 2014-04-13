package model;

public interface Environment {
	
	public String getName();
	
	public String getWeatherType();
	
	public String getDescription();

	public void setEnvironment(String environmentName);

}
