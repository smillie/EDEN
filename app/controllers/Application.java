package controllers;

import play.*;
import play.api.libs.json.Json;
import play.mvc.*;
import views.html.*;
import model.Placeable;
import model.components.AeroponicsGrowingBay;
import model.components.Component;
import model.components.ComponentFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result getComponents() {
    	 Gson gson = new Gson();
    	 gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    	 List<Placeable> components = ComponentFactory.listAll();
    	 return ok(gson.toJson(components));
    }

}
