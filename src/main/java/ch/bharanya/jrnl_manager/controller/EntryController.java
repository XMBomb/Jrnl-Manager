package ch.bharanya.jrnl_manager.controller;

import ch.bharanya.jrnl_manager.service.JrnlService;
import ch.bharanya.jrnl_manager.controller.util.JsonTransformer;
import spark.Spark;

public class EntryController implements IController{
	
	@Override
	public void setup(){
		Spark.get("/entries", (request, response) -> {
			return JrnlService.getInstance().getJrnlEntries();
		}, new JsonTransformer());
		
		Spark.get("/entry/date/:datetime", (request, response) -> {
			return JrnlService.getInstance().findJrnlEntryWithDate(request.params(":datetime"));
		}, new JsonTransformer());

		Spark.get("/entries/tag/:tagName", (request, response) -> {
			return JrnlService.getInstance().findJrnlEntriesByTagName(request.params(":tagName"));
		}, new JsonTransformer());
	}
}