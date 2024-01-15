package resolveEvents;

import enums.EEvent;
import functions.SaveEventPressed;
import gameStatesDefault.GameState;

public class ResolveEvent extends GameState {

	@Override
	public void execute() {

		Class<? extends GameState> classEvent = null;
		EEvent eEvent = SaveEventPressed.INSTANCE.get();

		switch (eEvent) {

		case DELTA_PLAN:
			classEvent = ResolveEventDeltaPlan.class;
			break;

		case EMERGENCY_MEETING:
			break;

		case EMERGENCY_SANDBAGS:
			break;

		case ENGINEERING_CORPS:
			break;

		case HOOGHEEMRAADSCHAPPEN:
			break;

		case MAIL_EXCHANGE:
			break;

		case NEW_PORT:
			break;

		case STOOMGEMAAL_VIER_NOORDER_KOGGEN:
			classEvent = ResolveEventStoomgemaalVierNoorderKoggen.class;
			break;

		case STORMVLOEDSEINDIENST:
			break;

		case THE_CALM_BEFORE_THE_STORM:
			break;

		case THE_LITTLE_DUTCH_BOY:
			break;

		case TWEE_GEBROEDERS_PLUGS_BREACH:
			classEvent = ResolveEventTweeGebroedersPlugsBreach.class;
			break;

		case WATER_MANAGEMENT:
			break;

		case ZUIDERZEEVEREENIGING:
			break;

		}

		getFlow().addFirst(classEvent);
		proceedToNextGameState();

	}

}
