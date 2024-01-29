package model;

public enum CheckForObjectivesAreCompleted {

	INSTANCE;

	private boolean value = false;

	public void set(boolean value) {
		this.value = value;
	}

	public boolean get() {
		return this.value;
	}

}
