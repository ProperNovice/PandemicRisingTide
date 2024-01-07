package gameStates;

public class DikesFailWithFlood extends DikesFail {

	@Override
	protected boolean floodCanTrigger() {
		return true;
	}

}
