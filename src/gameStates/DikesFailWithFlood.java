package gameStates;

public class DikesFailWithFlood extends DikesFail {

	@Override
	protected boolean floodOccurs() {
		return true;
	}

}
