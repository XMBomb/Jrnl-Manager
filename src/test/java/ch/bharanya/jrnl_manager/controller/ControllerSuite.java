package ch.bharanya.jrnl_manager.controller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ch.bharanya.jrnl_manager.App;
import spark.Spark;

@RunWith(Suite.class)
@SuiteClasses({ EntryControllerTest.class, TagControllerTest.class })
public class ControllerSuite {
	
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
