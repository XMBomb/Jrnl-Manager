package ch.bharanya.jrnl_manager.controller;
import static spark.Spark.get;

import ch.bharanya.jrnl_manager.IController;
import ch.bharanya.jrnl_manager.JrnlService;

public class EntryController implements IController{
	
	@Override
	public void setup(){
		get("/entries", (request, response) -> {
			response.type("application/json");
			return JrnlService.getInstance().getJrnlEntries();
		}, new JsonTransformer());
		
//		get("/entry/:datetime", (request, response) -> {
//			return JrnlManager.getInstance().findJrnlEntryWithDate(request.params(":datetime"));
//		});
	}
}
