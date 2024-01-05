package gameStates;

public class DegradeRegionWithFlood extends DegradeRegion {

	@Override
	protected boolean floodOccurs() {
		return true;
	}

}
