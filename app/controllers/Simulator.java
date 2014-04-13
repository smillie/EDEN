package controllers;

import model.Colony;
import model.ConcreteEnvironment;
import model.Environment;
import model.Reporter;
import model.resources.BasicResourceManager;
import model.resources.ResourceManager;
import model.resources.ResourceType;
import play.Logger;

import com.google.gson.annotations.Expose;

public class Simulator {

	@Expose private Colony colony;
	@Expose private ResourceManager resources;
	@Expose private String environmentName;
	@Expose private Reporter reporter = Reporter.getInstance();
	private Environment environment;

	
	public Colony getColony() {
		return colony;
	}
	public void setColony(Colony colony) {
		this.colony = colony;
	}

	public String getEnvironment() {
		return environmentName;
	}
	public void setEnvironment(String environment) {
		this.environmentName = environment;
	}
	public ResourceManager getResourceManager() {
		return resources;
	}
	public void setLifeSupport(ResourceManager resourceManager) {
		this.resources = resourceManager;
	}
	public void setReporter() {
		this.reporter = Reporter.getInstance();
	}
	

	public Simulator(Colony colony, String environment, ResourceManager lifeSupport) {
		
		this.colony = colony;
		this.environmentName = environment;
		this.environment = ConcreteEnvironment.getInstance();
		this.environment.setEnvironment(this.environmentName);
		
	}
	
	public static Simulator tick(Simulator simulator, int steps) {		
		//Setting some things...
		simulator.setReporter();
		Reporter.getInstance().flush();
		simulator.environment = ConcreteEnvironment.getInstance();
		simulator.environment.setEnvironment(simulator.environmentName);
				
		//This where the real fun begins
		Logger.debug("Ticking simulation for " + steps + " steps.");
		simulator.colony.tick(steps);
				
		
		return simulator;
	}
	
}
