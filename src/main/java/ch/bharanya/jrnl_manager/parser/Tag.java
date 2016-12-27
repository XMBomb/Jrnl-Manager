package ch.bharanya.jrnl_manager.parser;

public class Tag {
	private String name;
	private int numUses;

	public Tag(final String name, final Integer numUses) {
		this.name = name;
		this.numUses = numUses;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getNumUses() {
		return numUses;
	}

	public void setNumUses(final int numUses) {
		this.numUses = numUses;
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof Tag)) {
			return false;
		}
		
		final Tag otherTag = (Tag) obj;
		
		if(otherTag.getName().equals(getName()) && otherTag.getNumUses() == getNumUses()){
			return true;
		}
		return false;
	}
}
