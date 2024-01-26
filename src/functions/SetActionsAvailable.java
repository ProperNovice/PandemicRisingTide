package functions;

import business.Region;
import cards.CardObjective;
import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.EAction;
import enums.EColor;
import enums.EObjective;
import enums.ERegion;
import enums.ERole;
import model.Dikes;
import model.DiscardPilePlayer;
import model.HydraulicStructures;
import model.Objectives;
import model.Players;

public enum SetActionsAvailable {

	INSTANCE;

	public void execute() {

		move();
		pumpWater();
		buildDike();
		buildPumpingStation();
		buildPort();
		addPopulation();
		shareResources();
		hydraulicStructure();
		sanitationEngineer();
		event();

	}

	private void event() {

		if (GetEventsPlayable.INSTANCE.executeActivePlayer().isEmpty()
				&& GetEventsPlayable.INSTANCE.executePassivePlayer().isEmpty())
			return;

		EAction.RESOLVE_EVENT.showAndSelect();

	}

	private void sanitationEngineer() {

		if (!Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().getFirst().getERole()
				.equals(ERole.SANITATION_ENGINEER))
			return;

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		if (DiscardPilePlayer.INSTANCE.containsERegionCard(eRegion))
			EAction.TAKE_CURRENT_REGION_CARD_FROM_THE_DISCARD_PILE.showAndSelect();

	}

	private void hydraulicStructure() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		if (!eRegion.getRegion().canBuildHydraulicStructure())
			return;

		EColor eColor = eRegion.getRegion().getEColor();

		if (HydraulicStructures.INSTANCE.isBuilt(eColor))
			return;

		int amount = 0;

		for (CardPlayer cardPlayer : Players.INSTANCE.getActivePlayer().getCardsPlayer()) {

			if (!(cardPlayer instanceof CardPlayerRegion))
				continue;

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;

			if (!cardPlayerRegion.getEColor().equals(eColor))
				continue;

			amount++;

		}

		if (amount < 5)
			return;

		EAction.BUILD_HYDRAULIC_STRUCTURE.showAndSelect();

	}

	private void shareResources() {

		ShareResources.INSTANCE.execute();

		if (ShareResources.INSTANCE.canShareResources())
			EAction.SHARE_RESOURCES.showAndSelect();

	}

	private void addPopulation() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();
		Region region = eRegion.getRegion();

		if (region.getWaterCubes().getArrayList().size()
				+ region.getPopulations().getArrayList().size() == 3)
			return;

		EColor eColor = region.getEColor();

		if (GetCardsPlayerHasWithEColor.INSTANCE.execute(eColor).isEmpty())
			return;

		for (CardObjective cardObjective : Objectives.INSTANCE.getObjectivesCurrent()) {

			if (!cardObjective.getEObjective().equals(EObjective.POPULATION))
				continue;

			EColor cardObjectiveEColor = cardObjective.getEColor();

			if (!Objectives.INSTANCE.getPopulationERegions(cardObjectiveEColor).contains(eRegion))
				return;

			EAction.EXPAND_POPULATION.showAndSelect();

			return;

		}

	}

	private void buildPort() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		Region region = eRegion.getRegion();

		if (!region.getPort().getArrayList().isEmpty())
			return;

		ERole eRole = Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().getFirst()
				.getERole();

		if (eRole.equals(ERole.PORT_MASTER)) {

			EAction.BUILD_PORT.showAndSelect();
			return;

		}

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

		if (!region.getPumpingStation().getArrayList().isEmpty())
			return;

		ERole eRole = Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().getFirst()
				.getERole();

		if (eRole.equals(ERole.CARPENTER)) {

			EAction.BUILD_PUMPING_STATION.showAndSelect();
			return;

		}

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

		if (Dikes.INSTANCE.getList().getArrayList().isEmpty())
			return;

		ERole eRole = Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().getFirst()
				.getERole();

		if (eRole.equals(ERole.CARPENTER)) {

			EAction.BUILD_DIKE.showAndSelect();
			return;

		}

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		Region region = eRegion.getRegion();

		if (!region.getWaterCubes().getArrayList().isEmpty())
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
