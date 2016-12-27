package ch.bharanya.jrnl_manager.controller;

public class ErrorMessage extends Message {
	public ErrorMessage(final String message, final Object... args) {
		super(message, args);
		setType(EMessageType.ERROR);
	}
}
