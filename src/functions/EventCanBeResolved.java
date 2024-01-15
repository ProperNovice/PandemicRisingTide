package functions;

import cards.CardPlayer;
import cards.CardPlayerEvent;
import enums.EEvent;
import model.Dikes;
import model.PumpingStations;

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

		case STOOMGEMAAL_VIER_NOORDER_KOGGEN:
			return !PumpingStations.INSTANCE.getList().getArrayList().isEmpty()
					|| !Dikes.INSTANCE.getList().getArrayList().isEmpty();

		default:
			return true;

		}

	}

}
