package functions;

import cards.CardPlayer;
import cards.CardPlayerEvent;
import enums.EEvent;
import model.Dikes;
import model.Players;
import model.Ports;
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

		case ENGINEERING_CORPS:
			return true;

		case EMERGENCY_MEETING:
			return !GetERegionContainingPlayerPawn.INSTANCE.getERegionContainingPlayerPawnActive()
					.equals(GetERegionContainingPlayerPawn.INSTANCE
							.getERegionContainingPlayerPawnPassive());

		case EMERGENCY_SANDBAGS:
			return true;

		case HOOGHEEMRAADSCHAPPEN:
			return !GetRegionsContainingAtLeastOneWaterCube.INSTANCE.execute().isEmpty();

		case MAIL_EXCHANGE:
			return !Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().isEmpty()
					&& !Players.INSTANCE.getPassivePlayer().getCardsPlayer().getArrayList()
							.isEmpty();

		case THE_LITTLE_DUTCH_BOY:
			return true;

		case NEW_PORT:
			return !Ports.INSTANCE.getList().getArrayList().isEmpty()
					|| !Dikes.INSTANCE.getList().getArrayList().isEmpty();

		case WATER_MANAGEMENT:
			return true;

		default:
			return true;

		}

	}

}
