package functions;

import cards.CardPlayer;
import cards.CardPlayerEvent;
import enums.EEvent;

public enum SaveEventPressed {

	INSTANCE;

	private EEvent eEvent = null;

	public void set(CardPlayer cardPlayer) {

		CardPlayerEvent cardPlayerEvent = (CardPlayerEvent) cardPlayer;
		this.eEvent = cardPlayerEvent.getEEvent();

	}

	public void set(EEvent eEvent) {
		this.eEvent = eEvent;
	}

	public EEvent get() {
		return this.eEvent;
	}

}
