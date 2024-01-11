package functions;

import business.Region;
import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.EAction;
import enums.ERegion;
import model.Dikes;
import model.Players;

public enum SetActionsAvailable {

	INSTANCE;

	public void execute() {

		move();
		pumpWater();
		buildDike();
		buildPumpingStation();
		buildPort();
		shareResources();

	}

	private void shareResources() {

		ERegion eRegionActive = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		ERegion eRegionPassive = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnPassive();

		if (!eRegionActive.equals(eRegionPassive))
			return;

		if (PlayerHasCardWithERegion.INSTANCE.playerActiveHasCardWithERegion(eRegionActive)
				|| PlayerHasCardWithERegion.INSTANCE.playerPassiveHasCardWithERegion(eRegionActive))
			EAction.SHARE_RESOURCES.showAndSelect();

	}

	private void buildPort() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		Region region = eRegion.getRegion();

		if (!region.getPorts().getArrayList().isEmpty())
			return;

		for (CardPlayer cardPlayer : Players.INSTANCE.getActivePlayer().getCardsPlayer()) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;

			if (!eRegion.equals(cardPlayerRegion.getERegion()))
				continue;

			EAction.BUILD_PORT.showAndSelect();

			return;

		}

	}

	private void buildPumpingStation() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		Region region = eRegion.getRegion();

		if (!region.getPumpingStations().getArrayList().isEmpty())
			return;

		for (CardPlayer cardPlayer : Players.INSTANCE.getActivePlayer().getCardsPlayer()) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;

			if (!eRegion.equals(cardPlayerRegion.getERegion()))
				continue;

			EAction.BUILD_PUMPING_STATION.showAndSelect();

			return;

		}

	}

	private void buildDike() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		Region region = eRegion.getRegion();

		if (!region.getWaterCubes().getArrayList().isEmpty())
			return;

		if (Dikes.INSTANCE.getList().getArrayList().isEmpty())
			return;

		EAction.BUILD_DIKE.showAndSelect();

	}

	private void pumpWater() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		Region region = eRegion.getRegion();

		if (region.getWaterCubes().getArrayList().isEmpty())
			return;

		EAction.PUMP_WATER.showAndSelect();

	}

	private void move() {
		EAction.MOVE.showAndSelect();
	}

}
