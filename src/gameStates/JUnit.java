package gameStates;

import business.Adjacency;
import business.Dike;
import business.DikeLocation;
import business.Pawn;
import business.Player;
import business.PopulationCube;
import business.Port;
import business.PumpingStation;
import business.Region;
import business.WaterCube;
import cards.CardDikeFailure;
import cards.CardPlayer;
import cards.CardPlayerEvent;
import cards.CardPlayerRegion;
import cards.CardPlayerStorm;
import cards.CardRole;
import controller.Credentials;
import enums.EColor;
import enums.EEvent;
import enums.ERegion;
import enums.ERole;
import functions.AddCardToPlayer;
import gameStatesDefault.GameState;
import javafx.scene.input.KeyCode;
import model.Adjacencies;
import model.Cards;
import model.DeckDikeFailure;
import model.DeckPlayer;
import model.DiscardPileDikeFailure;
import model.DiscardPilePlayer;
import model.Pawns;
import model.Players;
import utils.ArrayList;

public class JUnit extends GameState {

	@Override
	public void execute() {

//		jUnit();

		getFlow().addAllLast(StartGame.class);
		proceedToNextGameState();

	}

	public void jUnit() {

		DeckDikeFailure.INSTANCE.setUpDeck(Cards.INSTANCE.getCardsDikeFailureClone());

		handleM();

//		addWaterCubes(2, ERegion.NOORDZEE);
//		addWaterCubes(2, ERegion.ZUIDERZEE);
		addWaterCubes(3, ERegion.FRYSLAN);
		addWaterCubes(1, ERegion.IJSSELDELTA);
		addWaterCubes(1, ERegion.MARKERWAARD);
		addWaterCubes(1, ERegion.BETUWE);
		addWaterCubes(3, ERegion.NOORDOOSTPOLDER);
		addWaterCubes(3, ERegion.VOLLENHOVE);
		addWaterCubes(2, ERegion.RIJN_EN_IJSSEL);
		addWaterCubes(4, ERegion.ZUIDERZEE);
		addWaterCubes(2, ERegion.ROER_EN_OVERMAAS);
		addWaterCubes(1, ERegion.LAND_VAN_MAAS_EN_WAAL);
		addWaterCubes(3, ERegion.LAND_VAN_HEUSDEN);
		addWaterCubes(1, ERegion.HOEKSE_WAARD);

//		addPopulations(3, ERegion.FRYSLAN);

//		addPumpingStation(ERegion.FRYSLAN);
		addPumpingStation(ERegion.IJSSELDELTA);
		addPumpingStation(ERegion.FLEVOLAND);
		addPumpingStation(ERegion.WIERINGERMEER);
		addPumpingStation(ERegion.KENNEMERLAND);
		addPumpingStation(ERegion.ROER_EN_OVERMAAS);

		addPort(ERegion.FRYSLAN);
		addPort(ERegion.GELDERSE_VALLEI);
		addPort(ERegion.DELFLAND);
		addPort(ERegion.ROER_EN_OVERMAAS);

		addDike(ERegion.FRYSLAN, ERegion.NOORDERZIJLVEST);
//		addDike(ERegion.FRYSLAN, ERegion.NOORDERZIJLVEST);
//		addDike(ERegion.FRYSLAN, ERegion.NOORDERZIJLVEST);
		addDike(ERegion.FRYSLAN, ERegion.NOORDOOSTPOLDER);
//		addDike(ERegion.FRYSLAN, ERegion.NOORDZEE);
//		addDike(ERegion.FRYSLAN, ERegion.ZUIDERZEE);
//		addDike(ERegion.VOLLENHOVE, ERegion.IJSSELDELTA);
//		addDike(ERegion.NOORDOOSTPOLDER, ERegion.IJSSELDELTA);
		addDike(ERegion.NOORDOOSTPOLDER, ERegion.VOLLENHOVE);
		addDike(ERegion.RIJN_EN_IJSSEL, ERegion.VOLLENHOVE);
		addDike(ERegion.RIJN_EN_IJSSEL, ERegion.VOLLENHOVE);
		addDike(ERegion.RIJN_EN_IJSSEL, ERegion.BETUWE);

		playerRole(EPlayer.TOP, ERole.PUMP_OPERATOR, ERegion.FRYSLAN);
		playerCardRegion(EPlayer.TOP, ERegion.VOLLENHOVE);
		playerCardRegion(EPlayer.TOP, ERegion.BETUWE);
		playerCardRegion(EPlayer.TOP, ERegion.GELDERSE_VALLEI);
		playerCardRegion(EPlayer.TOP, ERegion.FRYSLAN);
		playerCardRegion(EPlayer.TOP, ERegion.NOORDERZIJLVEST);
		playerCardRegion(EPlayer.TOP, ERegion.NOORDOOSTPOLDER);
		playerCardRegion(EPlayer.TOP, ERegion.LAND_VAN_MAAS_EN_WAAL);
		playerCardRegion(EPlayer.TOP, ERegion.FLEVOLAND);
		playerCardRegion(EPlayer.TOP, ERegion.MARKERWAARD);
		playerCardRegion(EPlayer.TOP, ERegion.KENNEMERLAND);
		playerCardEvent(EEvent.NEW_PORT, EPlayer.TOP);
		playerCardRegion(EPlayer.TOP, ERegion.WIERINGERMEER);
		playerCardRegion(EPlayer.TOP, ERegion.WEST_BRABANT);
		playerCardRegion(EPlayer.TOP, ERegion.ROER_EN_OVERMAAS);

		playerRole(EPlayer.BOTTOM, ERole.WEREHOUSE_MANAGER, ERegion.DELFLAND);
		playerCardRegion(EPlayer.BOTTOM, ERegion.FRYSLAN);
		playerCardRegion(EPlayer.BOTTOM, ERegion.ROER_EN_OVERMAAS);
		playerCardRegion(EPlayer.BOTTOM, ERegion.ZEEUWS_VLAANDEREN);
		playerCardRegion(EPlayer.BOTTOM, ERegion.ROER_EN_OVERMAAS);
		playerCardRegion(EPlayer.BOTTOM, ERegion.VOLLENHOVE);
		playerCardRegion(EPlayer.BOTTOM, ERegion.ROER_EN_OVERMAAS);
		playerCardRegion(EPlayer.BOTTOM, ERegion.ZEEUWS_VLAANDEREN);
		playerCardRegion(EPlayer.BOTTOM, ERegion.ROER_EN_OVERMAAS);
		playerCardRegion(EPlayer.BOTTOM, ERegion.VOLLENHOVE);
//		playerCardRegion(EPlayer.BOTTOM, ERegion.WEST_BRABANT);
//		playerCardEvent(EEvent.THE_CALM_BEFORE_THE_STORM, EPlayer.BOTTOM);
		playerCardRegion(EPlayer.BOTTOM, ERegion.MARKERWAARD);

		addDikesFailureCardToDiscardPile(ERegion.NOORDOOSTPOLDER);
//		addDikesFailureCardToDiscardPile(ERegion.VOLLENHOVE);

		addCardRegionCardToDiscardPile(ERegion.FRYSLAN);

//		while (Dikes.INSTANCE.getList().getArrayList().size() > 0)
//			Dikes.INSTANCE.getList().getArrayList().removeRandom();

//		while (PumpingStations.INSTANCE.getList().getArrayList().size() > 0)
//			PumpingStations.INSTANCE.getList().getArrayList().removeRandom();

//		WaterFlows.INSTANCE.execute();

//		Actions.INSTANCE.showAction(EAction.DIKE_FAIL);
//		Actions.INSTANCE.showAction(EAction.WATER_FLOWS);

//		getFlow().addLast(ActionChoose.class);

//		Players.INSTANCE.changePlayerOrder();

//		Regions.INSTANCE.getRegion(ERegion.ROER_EN_OVERMAAS).getHydraulicStructure().getArrayList()
//				.addLast(new HydraulicStructure());
//		Regions.INSTANCE.getRegion(ERegion.ROER_EN_OVERMAAS).relocateComponents();
//		
//		Regions.INSTANCE.getRegion(ERegion.RIJN_EN_IJSSEL).getHydraulicStructure().getArrayList()
//		.addLast(new HydraulicStructure());
//		Regions.INSTANCE.getRegion(ERegion.RIJN_EN_IJSSEL).relocateComponents();
//		
//		Regions.INSTANCE.getRegion(ERegion.SCHOUWEN_DUIVELAND).getHydraulicStructure().getArrayList()
//		.addLast(new HydraulicStructure());
//		Regions.INSTANCE.getRegion(ERegion.SCHOUWEN_DUIVELAND).relocateComponents();
//		
//		Regions.INSTANCE.getRegion(ERegion.WIERINGERMEER).getHydraulicStructure().getArrayList()
//		.addLast(new HydraulicStructure());
//		Regions.INSTANCE.getRegion(ERegion.WIERINGERMEER).relocateComponents();

		Players.INSTANCE.getActivePlayer().resetActionsRemaining();

//		for (EColor eColor : EColor.values())
//			HydraulicStructures.INSTANCE.buildHydraulicStructureMap(eColor);

//		getFlow().addLast(ActionChoose.class);
//		getFlow().addLast(ActionBuildHydraulicStructure.class);
//		getFlow().addLast(ActionsRemainingReduce.class);
//		getFlow().addLast(ResolveHydraulicStructureOrange.class);
//		getFlow().addLast(ActionBuildDike.class);

		addStormFirstCardPlayersDeck();

//		getFlow().addLast(ResolveStorm.class);
//		getFlow().addLast(ActionDikesFail.class);
//		getFlow().addLast(ActionChoose.class);

	}

	@Override
	protected void handleKeyPressed(KeyCode keyCode) {

	}

	public void addPopulations(int amount, ERegion eRegion) {

		Region region = eRegion.getRegion();

		for (int counter = 1; counter <= amount; counter++) {

			PopulationCube population = new PopulationCube();
			population.getImageView().setHeight(Credentials.INSTANCE.hWaterPopulationCubeMap);
			region.getPopulations().getArrayList().addLast(population);

		}

		region.relocateComponents();

	}

	public void addWaterCubes(int amount, ERegion eRegion) {

		Region region = eRegion.getRegion();

		for (int counter = 1; counter <= amount; counter++) {

			WaterCube waterCube = new WaterCube();
			waterCube.getImageView().setHeight(Credentials.INSTANCE.hWaterPopulationCubeMap);
			region.getWaterCubes().getArrayList().addLast(waterCube);

		}

		region.relocateComponents();

	}

	public void addPumpingStation(ERegion eRegion) {

		Region region = eRegion.getRegion();

		region.getPumpingStation().getArrayList().addLast(new PumpingStation());
		region.getPumpingStation().getArrayList().getLast().getImageView()
				.setHeight(Credentials.INSTANCE.hPortWaterPumpMap);

		region.relocateComponents();

	}

	public void addPort(ERegion eRegion) {

		Region region = eRegion.getRegion();

		region.getPort().getArrayList().addLast(new Port());
		region.getPort().getArrayList().getLast().getImageView()
				.setHeight(Credentials.INSTANCE.hPortWaterPumpMap);

		region.relocateComponents();

	}

	public void addDike(ERegion eRegionA, ERegion eRegionB) {

		ArrayList<Adjacency> list = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegionA);
		Adjacency adjacency = null;

		for (Adjacency adjacencyTemp : list) {

			if (!adjacencyTemp.getERegionsClone().contains(eRegionB))
				continue;

			adjacency = adjacencyTemp;
			break;

		}

		DikeLocation dikeLocation = adjacency.getDikeLocation();
		dikeLocation.addDikeRelocate(new Dike());

	}

	private enum EPlayer {
		TOP, BOTTOM
	}

	public void playerCardRegion(EPlayer ePlayer, ERegion eRegion) {

		Player player = null;

		switch (ePlayer) {

		case TOP:
			player = Players.INSTANCE.getList().getFirst();
			break;

		case BOTTOM:
			player = Players.INSTANCE.getList().getLast();
			break;

		}

		CardPlayerRegion cardPlayerRegion = null;
		EColor eColor = null;

		for (CardPlayer cardPlayer : Cards.INSTANCE.getCardsPlayerRegionClone()) {

			CardPlayerRegion cardPlayerRegionTemp = (CardPlayerRegion) cardPlayer;

			if (eRegion.equals(cardPlayerRegionTemp.getERegion()))
				eColor = cardPlayerRegionTemp.getEColor();

		}

		cardPlayerRegion = new CardPlayerRegion(eRegion, eColor);
		cardPlayerRegion.getImageView().setVisible(true);

		player.getCardsPlayer().relocateImageViews();

		// TODO

		if (ePlayer == EPlayer.TOP)
			AddCardToPlayer.INSTANCE.executeActivePlayer(cardPlayerRegion);
		else
			AddCardToPlayer.INSTANCE.executePassivePlayer(cardPlayerRegion);

	}

	public void playerRole(EPlayer ePlayer, ERole eRole, ERegion eRegion) {

		Player player = null;

		switch (ePlayer) {

		case TOP:
			player = Players.INSTANCE.getList().getFirst();
			break;

		case BOTTOM:
			player = Players.INSTANCE.getList().getLast();
			break;

		}

		CardRole cardRole = new CardRole(eRole);
		cardRole.getImageView().setVisible(true);

		player.getCardRole().getArrayList().addLast(cardRole);
		player.getCardRole().relocateImageViews();

		Pawn pawn = Pawns.INSTANCE.getPawn(eRole);
		pawn.getImageView().setVisible(true);

		Region region = eRegion.getRegion();
		region.getPawns().getArrayList().addLast(pawn);
		region.relocateComponents();

	}

	public void addDikesFailureCardToDiscardPile(ERegion eRegion) {

		CardDikeFailure cardDikeFailure = new CardDikeFailure(eRegion);
		cardDikeFailure.getImageView().setVisible(true);

		DiscardPileDikeFailure.INSTANCE.addFirstRelocate(cardDikeFailure);

	}

	public void addCardRegionCardToDiscardPile(ERegion eRegion) {

		EColor eColor = null;

		for (CardPlayer cardPlayer : Cards.INSTANCE.getCardsPlayerRegionClone()) {

			CardPlayerRegion cardPlayerRegionTemp = (CardPlayerRegion) cardPlayer;

			if (eRegion.equals(cardPlayerRegionTemp.getERegion()))
				eColor = cardPlayerRegionTemp.getEColor();

		}

		CardPlayerRegion cardPlayerRegion = new CardPlayerRegion(eRegion, eColor);
		cardPlayerRegion.getImageView().setVisible(true);

		DiscardPilePlayer.INSTANCE.addFirstRelocate(cardPlayerRegion);

	}

	public void addStormFirstCardPlayersDeck() {

		ArrayList<CardPlayer> list = new ArrayList<>();
		list.addLast(new CardPlayerStorm());

		DeckPlayer.INSTANCE.addDeckFirst(list);

	}

	public void playerCardEvent(EEvent eEvent, EPlayer ePlayer) {

		CardPlayerEvent cardPlayerEvent = new CardPlayerEvent(eEvent);
		cardPlayerEvent.getImageView().setVisible(true);

		if (ePlayer == EPlayer.TOP)
			AddCardToPlayer.INSTANCE.executeActivePlayer(cardPlayerEvent);
		else
			AddCardToPlayer.INSTANCE.executePassivePlayer(cardPlayerEvent);

	}

}
