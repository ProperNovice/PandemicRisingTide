package gameStates;

public class DikesFailNoFlood extends DikesFail {

	@Override
	protected boolean floodCanTrigger() {
		return false;
	}

}
