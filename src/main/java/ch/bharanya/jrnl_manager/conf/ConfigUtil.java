package ch.bharanya.jrnl_manager.conf;

import java.nio.file.Paths;

/**
 * Class to configure the system on startup.
 */
public class ConfigUtil {

	/**
	 * Place in the filesystem where the configuration file for Logback is.
	 */
	public static final String LOGBACK_CONFIG = "conf/logback.xml";

	/**
	 * The absolute path to the document base (WEB-INF) where the configuration files exists.
	 */
	private static String docBase = Paths.get(".").toAbsolutePath().normalize().toString();

	/**
	 * @return the absolute path to the document base (WEB-INF) where the configuration files exists.
	 */
	public static String getDocBase() {
		return docBase;
	}

	/**
	 * Sets the doc base.
	 * @param docBase the absolute path to the document base (WEB-INF) where the configuration files exists.
	 */
	public static void setDocBase(final String docBase) {
		ConfigUtil.docBase = docBase;
	}
}
