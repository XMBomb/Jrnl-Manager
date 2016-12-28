package ch.bharanya.jrnl_manager.controller;

import java.util.Optional;

import ch.bharanya.jrnl_manager.service.JrnlService;
import ch.bharanya.jrnl_manager.controller.message.ErrorMessage;
import ch.bharanya.jrnl_manager.controller.util.Http;
import ch.bharanya.jrnl_manager.controller.util.JsonTransformer;
import ch.bharanya.jrnl_manager.parser.Tag;
import spark.Spark;

public class TagController implements IController {
	private final JrnlService jrnlService = JrnlService.getInstance();

	@Override
	public void setup() {
		Spark.get("/tags", (request, response) -> {
			return jrnlService.getTags();
		}, new JsonTransformer());
		
		Spark.get("/tag/:tagName", (request, response) -> {
			final String tagName = request.params(":tagName");
			
			final Optional<Tag> foundTag = jrnlService.findTagByName(tagName);
			
			if (foundTag.isPresent()){
				return foundTag.get();
			}
			
			response.status(Http.NOT_FOUND);
			return new ErrorMessage("Could not find a tag with name %s", tagName);
		}, new JsonTransformer());
	}

}
