package model.resources;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

public class ResourceManagerReviver implements JsonDeserializer<ResourceManager> {

	@Override
	public ResourceManager deserialize(JsonElement json, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject jsonObject =  json.getAsJsonObject();
		JsonPrimitive prim = (JsonPrimitive) jsonObject.get(BasicResourceManager.class.getCanonicalName());
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
