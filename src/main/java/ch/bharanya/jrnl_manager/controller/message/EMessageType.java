package ch.bharanya.jrnl_manager.controller.message;

public enum EMessageType {
	ERROR("error"),
	SUCCESS("success");

	private final String name;

	EMessageType(final String s) {
		name = s;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
