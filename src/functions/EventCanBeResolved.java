package functions;

import cards.CardPlayer;
import cards.CardPlayerEvent;
import enums.EEvent;
import model.Dikes;

public enum EventCanBeResolved {

	INSTANCE;

	public boolean execute(CardPlayer cardPlayer) {

		CardPlayerEvent cardPlayerEvent = (CardPlayerEvent) cardPlayer;
		EEvent eEvent = cardPlayerEvent.getEEvent();
		return execute(eEvent);

	}

	public boolean execute(EEvent eEvent) {

		switch (eEvent) {

		case DELTA_PLAN:
			return !Dikes.INSTANCE.getList().getArrayList().isEmpty();

		case TWEE_GEBROEDERS_PLUGS_BREACH:
			return !Dikes.INSTANCE.getList().getArrayList().isEmpty();

		default:
			return true;

		}

	}

}
