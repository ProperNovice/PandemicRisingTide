package functions;

import enums.ERegion;

public enum SetERegionProtectedFromWaterFlows {

	INSTANCE;

	private ERegion eRegion = null;

	public void execute(ERegion eRegion) {
		this.eRegion = eRegion;
	}

	public void reset() {
		this.eRegion = null;
	}

	public ERegion getERegion() {
		return this.eRegion;
	}

}
