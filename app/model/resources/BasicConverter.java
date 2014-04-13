package model.resources;

import static model.resources.ResourceType.*;

public class BasicConverter implements ResourceConverter {

	private final int ITERATIVE_STEP_DOWN = 25;
	private final ResourceManager resources = BasicResourceManager.getInstance();
	
	private Material inputProfile;
	private Material outputProfile;
	
	public BasicConverter (Material input, Material output) {
		
		this.inputProfile = input;
		this.outputProfile = output;
		
	}
	
	@Override
	public void convert(int percentOfMaximum) {
		
		boolean available = checkResourcesAvailbility(percentOfMaximum);
		
		if (available) {
			
			doConversions(percentOfMaximum);
		
		}

	}
	
	
	private boolean checkResourcesAvailbility(int percentage) {
		
		boolean reply = true;
		double percent = percentage * 0.01;
		
		if (checkResourceAvailable(BIOMASS, inputProfile.biomass, percent)) {reply = false;};
		if (checkResourceAvailable(CARBON_DIOXIDE, inputProfile.co2, percent)) {reply = false;};
		if (checkResourceAvailable(MINERALS, inputProfile.minerals, percent)) {reply = false;};
		if (checkResourceAvailable(OXYGEN, inputProfile.o2, percent)) {reply = false;};
		if (checkResourceAvailable(POWER, inputProfile.power, percent)) {reply = false;};
		if (checkResourceAvailable(WATER, inputProfile.h2o, percent)) {reply = false;};
		if (checkResourceAvailable(WASTE, inputProfile.waste, percent)) {reply = false;};
		
		return reply;
		
	}

	
	private boolean checkResourceAvailable(ResourceType type, int required, double percent) {
		
		int amountRequired = (int) Math.floor(required*percent);
		
		return (resources.checkLevel(type) >= amountRequired);
		
	}

	private void doConversions (int percentage) {
		
		double percent = percentage * 0.01;
		
		resources.takeResources(((int)Math.floor(inputProfile.biomass*percent)),BIOMASS);
		resources.addResources(((int)Math.ceil(outputProfile.biomass*percent)), BIOMASS);
		
		resources.takeResources(((int)Math.floor(inputProfile.co2*percent)), CARBON_DIOXIDE);
		resources.addResources(((int)Math.ceil(outputProfile.co2*percent)), CARBON_DIOXIDE);
		
		resources.takeResources(((int)Math.floor(inputProfile.minerals*percent)),MINERALS);
		resources.addResources(((int)Math.ceil(outputProfile.minerals*percent)), MINERALS);
		
		resources.takeResources(((int)Math.floor(inputProfile.o2*percent)),OXYGEN);
		resources.addResources(((int)Math.ceil(outputProfile.o2*percent)), OXYGEN);
		
		resources.takeResources(((int)Math.floor(inputProfile.power*percent)),POWER);
		resources.addResources(((int)Math.ceil(outputProfile.power*percent)), POWER);
		
		resources.takeResources(((int)Math.floor(inputProfile.h2o*percent)),WATER);
		resources.addResources(((int)Math.ceil(outputProfile.h2o*percent)), WATER);
		
		resources.takeResources(((int)Math.floor(inputProfile.waste*percent)),WASTE);
		resources.addResources(((int)Math.ceil(outputProfile.waste*percent)), WASTE);
		
	}
	
}
