package controllers;

import java.util.List;

import model.ConcreteEnvironment;
import model.Placeable;
import model.components.Component;
import model.components.ComponentFactory;
import model.components.ComponentReviver;
import model.resources.ResourceManager;
import model.resources.ResourceManagerReviver;
import model.resources.ResourceType;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Application extends Controller {

	private final static int STEPS = 500;

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result getComponents() {
		response().setHeader("Access-Control-Allow-Origin", "*");
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Component.class, new ComponentReviver());

		Gson gson = gsonBuilder.setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
		List<Placeable> components = ComponentFactory.listAll();
		return ok(gson.toJson(components));
	}

	public static Result getEnvironments() {
		response().setHeader("Access-Control-Allow-Origin", "*");

		Gson gson = new GsonBuilder().create();
		List<String> components = ConcreteEnvironment.listAll();
		return ok(gson.toJson(components));
	}
	
	public static Result getResources() {
		response().setHeader("Access-Control-Allow-Origin", "*");

		Gson gson = new GsonBuilder().create();
		return ok(gson.toJson(ResourceType.values()));
	}

	public static Result simulate() {
		response().setHeader("Access-Control-Allow-Origin", "*");
		response().setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST");
		
		JsonNode json = request().body().asJson();
		if(json == null) {
			return badRequest();
		}

		Logger.debug("Input: " + json.toString());
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Component.class, new ComponentReviver());
		gsonBuilder.registerTypeAdapter(ResourceManager.class, new ResourceManagerReviver());
		
		Gson gson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().serializeNulls().create();
		
		Simulator state = gson.fromJson(json.toString(), Simulator.class);
		
		String result = gson.toJson(Simulator.tick(state, STEPS));
		Logger.debug("Result: " + result);
		
		return ok(result);

	}

	public static Result checkCors(String endpoint) {
		response().setHeader("Access-Control-Allow-Origin", "*");       // Need to add the correct domain in here!!
		response().setHeader("Access-Control-Allow-Methods", "POST");   // Only allow POST
		response().setHeader("Access-Control-Max-Age", "300");          // Cache response for 5 minutes
		response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");         // Ensure this header is also allowed!  
		return ok();
	}


}
