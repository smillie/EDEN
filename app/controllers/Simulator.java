package controllers;

import play.Logger;
import resources.ResourceManager;

import com.google.gson.annotations.Expose;

import model.Colony;
import model.Environment;

public class Simulator {

	@Expose private Colony colony;
	@Expose private Environment environment;
	@Expose private ResourceManager resources;

	
	public Colony getColony() {
		return colony;
	}
	public void setColony(Colony colony) {
		this.colony = colony;
	}

	public Environment getEnvironment() {
		return environment;
	}
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	public ResourceManager getResourceManager() {
		return resources;
	}
	public void setLifeSupport(ResourceManager resourceManager) {
		this.resources = resourceManager;
	}
	
	public Simulator(Colony colony, Environment environment, ResourceManager resources){
		
		this.colony = colony;
		this.environment = environment;
		this.resources = resources;
		
	}
	
	public static Simulator tick(Simulator simulator, int steps) {
		Logger.debug("Ticking simulation for " + steps + " steps.");
		simulator.colony.tick(steps);
		
		return simulator;
	}
	
}
