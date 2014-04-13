package model.components;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ComponentReviver implements JsonDeserializer<Component>, JsonSerializer<Component> {

	private static final String CLASSNAME = "__class";


	@Override
	public JsonElement serialize(Component src, Type typeOfSrc,
			JsonSerializationContext context) {

		JsonObject retValue = new JsonObject();
		retValue = (JsonObject) context.serialize(src);
		return retValue;
	}

	@Override
	public Component deserialize(JsonElement json, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject jsonObject =  json.getAsJsonObject();
		JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
		String className = prim.getAsString();

		Class<?> clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new JsonParseException(e.getMessage());
		}

		return arg2.deserialize(jsonObject, clazz);

	}



}
