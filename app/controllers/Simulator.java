package controllers;

import resources.ResourceManager;

import com.google.gson.annotations.Expose;

import model.Colony;
import model.Environment;

public class Simulator {

	@Expose private Colony colony;
	@Expose private Environment environment;
	@Expose private ResourceManager lifeSupport;

	
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
	public ResourceManager getLifeSupport() {
		return lifeSupport;
	}
	public void setLifeSupport(ResourceManager lifeSupport) {
		this.lifeSupport = lifeSupport;
	}
	
	public Simulator(Colony colony, Environment environment, ResourceManager lifeSupport){
		
		this.colony = colony;
		this.environment = environment;
		this.lifeSupport = lifeSupport;
		
	}
	
	public static Simulator tick(Simulator simulator, int steps) {
		
		simulator.colony.tick(steps);
		
		return simulator;
	}
	
}
