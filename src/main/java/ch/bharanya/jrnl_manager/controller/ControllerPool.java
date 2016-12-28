package ch.bharanya.jrnl_manager.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ch.bharanya.jrnl_manager.controller.util.Http;
import spark.Spark;

public class ControllerPool {
	List<IController> controllers = new ArrayList<>();

	public ControllerPool(final IController... controllers) {
		this.controllers.addAll(Arrays.asList(controllers));
	}

	public void setupControllers() {
		controllers.stream().forEach(IController::setup);

		Spark.after((request, response) -> {
			response.type(Http.CONTENT_TYPE);
		});
	}

}
