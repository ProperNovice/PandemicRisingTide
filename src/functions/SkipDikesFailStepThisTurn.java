package functions;

public enum SkipDikesFailStepThisTurn {

	INSTANCE;

	private boolean isSkip = false;

	public void execute() {
		this.isSkip = true;
	}

	public boolean isSkip() {
		return this.isSkip;
	}

	public void reset() {
		this.isSkip = false;
	}

}
