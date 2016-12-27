package ch.bharanya.jrnl_manager.controller;

public enum EMessageType {
	ERROR("error"),
	SUCCESS("success");

	private final String name;

	private EMessageType(final String s) {
		name = s;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
