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
			classEvent = ResolveEventEmergencyMeeting.class;
			break;

		case EMERGENCY_SANDBAGS:
			classEvent = ResolveEventEmergencySandbags.class;
			break;

		case ENGINEERING_CORPS:
			classEvent = ResolveEventEngineeringCorps.class;
			break;

		case HOOGHEEMRAADSCHAPPEN:
			classEvent = ResolveEventHoogheemraadschappen.class;
			break;

		case MAIL_EXCHANGE:
			classEvent = ResolveEventMailExchange.class;
			break;

		case NEW_PORT:
			classEvent = ResolveEventNewPort.class;
			break;

		case STOOMGEMAAL_VIER_NOORDER_KOGGEN:
			classEvent = ResolveEventStoomgemaalVierNoorderKoggen.class;
			break;

		case STORMVLOEDSEINDIENST:
			break;

		case THE_CALM_BEFORE_THE_STORM:
			break;

		case THE_LITTLE_DUTCH_BOY:
			classEvent = ResolveEventTheLittleDutchBoy.class;
			break;

		case TWEE_GEBROEDERS_PLUGS_BREACH:
			classEvent = ResolveEventTweeGebroedersPlugsBreach.class;
			break;

		case WATER_MANAGEMENT:
			classEvent = ResolveEventWaterManagement.class;
			break;

		case ZUIDERZEEVEREENIGING:
			break;

		}

		getFlow().addFirst(classEvent);
		proceedToNextGameState();

	}

}
