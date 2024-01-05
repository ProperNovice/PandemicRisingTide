package gameStates;

public class DegradeRegionNoFlood extends DegradeRegion {

	@Override
	protected boolean floodOccurs() {
		return false;
	}

}
