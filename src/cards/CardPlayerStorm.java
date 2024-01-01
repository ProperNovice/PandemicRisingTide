package cards;

public class CardPlayerStorm extends CardPlayer {

	public CardPlayerStorm() {

		String fileName = getFolder();
		fileName += "STORM.png";

		super.createCard(fileName);

	}

	@Override
	protected String getFolder() {
		return super.getFolder() + "storm/";
	}

}
