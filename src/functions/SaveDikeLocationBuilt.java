package functions;

import business.DikeLocation;

public enum SaveDikeLocationBuilt {

	INSTANCE;

	private DikeLocation dikeLocation = null;

	public void set(DikeLocation dikeLocation) {
		this.dikeLocation = dikeLocation;
	}

	public DikeLocation get() {
		return this.dikeLocation;
	}

}
