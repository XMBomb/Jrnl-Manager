package ch.bharanya.jrnl_manager.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

/**
 * Created by XMBomb on 28.12.2016.
 */
public class JsonUtil {
    public static String toJson(Object object) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer()).create();
        return gson.toJson(object);
    }
}
