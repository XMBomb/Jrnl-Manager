package ch.bharanya.jrnl_manager.controller;

import ch.bharanya.jrnl_manager.App;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import spark.Spark;

public abstract class AControllerTest {
	@BeforeClass
	public static void beforeClass() {
		final App app = new App(true);
		app.init();
	}

	@AfterClass
	public static void afterClass() {
		Spark.stop();
	}
}