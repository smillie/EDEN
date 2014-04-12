package controllers;

import java.util.List;

import model.Colony;
import model.Placeable;
import model.components.ComponentFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result getComponents() {
		response().setHeader("Access-Control-Allow-Origin", "*");
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		List<Placeable> components = ComponentFactory.listAll();
		return ok(gson.toJson(components));
	}
	
	public static Result simulate() {
		response().setHeader("Access-Control-Allow-Origin", "*");
		JsonNode json = request().body().asJson();
		  if(json == null) {
			  return badRequest();
		  }
		return ok(json);
		
//		Simulator state = new Simulator(new Colony("Bob"), null, null);
//
//		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//		return ok(gson.toJson(state));
		
	}

}
