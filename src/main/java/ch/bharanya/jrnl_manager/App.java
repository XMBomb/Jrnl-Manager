package ch.bharanya.jrnl_manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.bharanya.jrnl_manager.controller.ControllerPool;
import ch.bharanya.jrnl_manager.controller.EntryController;

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

	public static void main(final String[] args) {
		final App app = new App();
		app.init();
	}

	private void init() {
		final ControllerPool controllerPool = new ControllerPool(
				new EntryController()
		);
		controllerPool.setupControllers();
	
	}
}
