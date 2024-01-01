package cards;

import enums.EEvent;

public class CardPlayerEvent extends CardPlayer {

	private EEvent eEvent = null;

	public CardPlayerEvent(EEvent eEvent) {

		this.eEvent = eEvent;

		String fileName = getFolder();
		fileName += this.eEvent.toString();
		fileName += ".png";

		super.createCard(fileName);

	}

	public EEvent getEEvent() {
		return this.eEvent;
	}

	@Override
	protected String getFolder() {
		return super.getFolder() + "events/";
	}

}
