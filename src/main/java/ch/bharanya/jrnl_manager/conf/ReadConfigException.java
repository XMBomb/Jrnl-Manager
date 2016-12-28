package ch.bharanya.jrnl_manager.conf;

/**
 * Simple Wrapper for {@link RuntimeException} to show that the has been an Exception reading the Configuration
 */
class ReadConfigException extends RuntimeException {
	/**
	 * Generated
	 */
	private static final long serialVersionUID = 2079202266624176481L;

	public ReadConfigException(final Exception e) {
		super(e);
	}

	public ReadConfigException(final Exception e, final String message) {
		super(message, e);
	}
}
