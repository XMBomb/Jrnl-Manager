package ch.bharanya.jrnl_manager.controller.message;

public class Message {
	private EMessageType type;
	private final String message;

	public Message(final String message, final Object... args) {
		this.message = String.format(message, args);
	}

	public String getMessage() {
		return message;
	}

	public EMessageType getType() {
		return type;
	}

	public void setType(final EMessageType type) {
		this.type = type;
	}

}
