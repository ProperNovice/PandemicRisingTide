package gameStates;

public class DegradeRegionNoFlood extends DegradeRegion {

	@Override
	protected boolean floodCanTrigger() {
		return false;
	}

}
