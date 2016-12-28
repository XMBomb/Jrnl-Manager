package ch.bharanya.jrnl_manager.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Created by XMBomb on 28.12.2016.
 */
public class JsonUtil {
    public static String toJson(Object object) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime()).create();
        return gson.toJson(object);
    }
}
