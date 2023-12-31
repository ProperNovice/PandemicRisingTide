package cards;

public abstract class CardPlayer extends Card {

	public CardPlayer() {

	}

	@Override
	protected String getFolder() {
		return super.getFolder() + "player/";
	}

	@Override
	protected final String getStringBack() {
		return "cards/player/back.png";
	}

}
