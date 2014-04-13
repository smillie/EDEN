package model.resources;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ResourceManagerReviver implements JsonDeserializer<ResourceManager>, JsonSerializer<ResourceManager> {

	@Override
	public ResourceManager deserialize(JsonElement json, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		JsonObject jsonObject =  json.getAsJsonObject();


		Class<?> clazz = null;
		try {
			clazz = Class.forName(BasicResourceManager.class.getCanonicalName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new JsonParseException(e.getMessage());
		}

		return arg2.deserialize(jsonObject, clazz);
	}

	@Override
	public JsonElement serialize(ResourceManager src, Type arg1,
			JsonSerializationContext context) {
		JsonObject retValue = new JsonObject();
		retValue = (JsonObject) context.serialize(src);
		return retValue;
	}

}
