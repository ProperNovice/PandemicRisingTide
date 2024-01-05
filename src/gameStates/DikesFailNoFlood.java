package gameStates;

public class DikesFailNoFlood extends DikesFail {

	@Override
	protected boolean floodOccurs() {
		return false;
	}

}
