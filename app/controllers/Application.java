package controllers;

import play.*;
import play.api.libs.json.Json;
import play.mvc.*;
import views.html.*;
import model.components.AeroponicsGrowingBay;
import model.components.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result getComponents() {
    	Gson gson = new Gson();
    	Component c = new AeroponicsGrowingBay();
    	c.setName("test");
    	List<Component> components = new ArrayList<Component>();
    	components.add(c);
//    	gson.toJson(components);
    	return ok(gson.toJson(components));
    }

}
