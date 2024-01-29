package functions;

import business.Adjacency;
import business.DikeLocation;
import business.Pawn;
import business.PopulationCube;
import business.Port;
import business.PumpingStation;
import business.Region;
import cards.CardDikeFailure;
import cards.CardObjective;
import cards.CardPlayer;
import cards.CardRole;
import enums.ERegion;
import model.Actions;
import model.Adjacencies;
import model.Cards;
import model.DeckDikeFailure;
import model.DeckPlayer;
import model.DiscardPileDikeFailure;
import model.DiscardPilePlayer;
import model.Objectives;
import model.Players;
import model.PopulationLoss;
import model.Populations;
import model.Ports;
import model.PumpingStations;

public enum ComponentsWrapUp {

	INSTANCE;

	public void execute() {

		waterCubes();
		dikes();
		pumpingStations();
		ports();
		populationCubes();
		drawnCircles();
		actions();
		cards();
		pawns();

	}

	private void pawns() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			for (Pawn pawn : region.getPawns().getArrayList().clear())
				pawn.getImageView().setVisible(false);

		}

	}

	private void cards() {

		// players card role

		Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().clear();
		Players.INSTANCE.getPassivePlayer().getCardRole().getArrayList().clear();

		// player card hand

		Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().clear();
		Players.INSTANCE.getPassivePlayer().getCardsPlayer().getArrayList().clear();

		// decks & discard piles

		DeckPlayer.INSTANCE.clear();
		DiscardPilePlayer.INSTANCE.clear();
		DeckDikeFailure.INSTANCE.clear();
		DiscardPileDikeFailure.INSTANCE.clear();

		// objectives

		for (CardObjective cardObjective : Objectives.INSTANCE.getObjectivesCurrent().getArrayList()
				.clear())
			cardObjective.getImageView().setVisible(false);

		// set visible false

		for (CardPlayer cardPlayer : Cards.INSTANCE.getCardsPlayerEventClone())
			cardPlayer.getImageView().setVisible(false);

		for (CardPlayer cardPlayer : Cards.INSTANCE.getCardsPlayerRegionClone())
			cardPlayer.getImageView().setVisible(false);

		for (CardPlayer cardPlayer : Cards.INSTANCE.getCardsPlayerStormClone())
			cardPlayer.getImageView().setVisible(false);

		for (CardDikeFailure cardDikeFailure : Cards.INSTANCE.getCardsDikeFailureClone())
			cardDikeFailure.getImageView().setVisible(false);

		for (CardRole cardRole : Cards.INSTANCE.getCardsRoleClone())
			cardRole.getImageView().setVisible(false);

	}

	private void actions() {
		Actions.INSTANCE.concealActions();
	}

	private void drawnCircles() {
		UpdateDikeFailureCardsDrawnCircle.INSTANCE.reset();
	}

	private void populationCubes() {

		// regions

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			while (!region.getPopulations().getArrayList().isEmpty()) {

				PopulationCube populationCube = region.getPopulations().getArrayList()
						.removeRandom();
				Populations.INSTANCE.getList().getArrayList().addLast(populationCube);

			}

		}

		// population loss

		Populations.INSTANCE.getList().getArrayList()
				.addAllLast(PopulationLoss.INSTANCE.getList().getArrayList().clear());

		Populations.INSTANCE.getList().relocateImageViews();

	}

	private void ports() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			while (!region.getPort().getArrayList().isEmpty()) {

				Port pumpingStation = region.getPort().getArrayList().removeFirst();
				Ports.INSTANCE.getList().getArrayList().addLast(pumpingStation);

			}

		}

		Ports.INSTANCE.getList().relocateImageViews();

	}

	private void pumpingStations() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			while (!region.getPumpingStation().getArrayList().isEmpty()) {

				PumpingStation pumpingStation = region.getPumpingStation().getArrayList()
						.removeFirst();
				PumpingStations.INSTANCE.getList().getArrayList().addLast(pumpingStation);

			}

		}

		PumpingStations.INSTANCE.getList().relocateImageViews();

	}

	private void dikes() {

		for (ERegion eRegion : ERegion.values()) {

			for (Adjacency adjacency : Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion)) {

				DikeLocation dikeLocation = adjacency.getDikeLocation();

				if (dikeLocation == null)
					continue;

				while (!dikeLocation.isEmpty())
					RemoveDike.INSTANCE.execute(dikeLocation);

			}

		}

	}

	private void waterCubes() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			while (!region.getWaterCubes().getArrayList().isEmpty())
				RemoveWaterFromRegion.INSTANCE.execute(region);

		}

	}

}
