package ch.bharanya.jrnl_manager.controller.util;

import ch.bharanya.jrnl_manager.util.JsonUtil;
import com.google.gson.Gson;

import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    @Override
    public String render(final Object model) {
        return JsonUtil.toJson(model);
    }

}
