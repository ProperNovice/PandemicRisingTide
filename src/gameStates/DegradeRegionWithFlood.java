package gameStates;

public class DegradeRegionWithFlood extends DegradeRegion {

	@Override
	protected boolean floodCanTrigger() {
		return true;
	}

}
