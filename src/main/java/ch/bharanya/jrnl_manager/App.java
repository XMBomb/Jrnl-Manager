package ch.bharanya.jrnl_manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.bharanya.jrnl_manager.conf.Config;
import ch.bharanya.jrnl_manager.controller.ControllerPool;
import ch.bharanya.jrnl_manager.controller.EntryController;
import ch.bharanya.jrnl_manager.controller.TagController;

/**
 * Hello world!
 *
 */
public class App {

	/**
	 * <p>
	 * The {@link Logger} for this class.
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public App(final boolean testMode) {
		Config.testMode = testMode;
	}

	public static void main(final String[] args) {
		final App app = new App(false);
		app.init();
	}

	public void init() {
		final ControllerPool controllerPool = new ControllerPool(
				new EntryController(),
				new TagController()
		);
		controllerPool.setupControllers();
	
	}
}
