package controllers;

import java.util.List;

import model.Placeable;
import model.components.ComponentFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result getComponents() {
		response().setHeader("Access-Control-Allow-Origin", "*");

		Gson gson = new Gson();
		gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		List<Placeable> components = ComponentFactory.listAll();
		return ok(gson.toJson(components));
	}

}
