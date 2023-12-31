package gameStates;

import business.Adjacency;
import business.Dike;
import business.DikeLocation;
import business.Pawn;
import business.Player;
import business.PopulationCube;
import business.Port;
import business.Region;
import business.WaterCube;
import business.WaterPump;
import cards.CardDikeFailure;
import cards.CardPlayerRegion;
import cards.CardRole;
import controller.Credentials;
import enums.EColor;
import enums.ERegion;
import enums.ERole;
import gameStatesDefault.GameState;
import javafx.scene.input.KeyCode;
import model.Adjacencies;
import model.Cards;
import model.DiscardPileDikeFailure;
import model.Players;
import model.Regions;
import utils.ArrayList;

public class JUnit extends GameState {

	@Override
	public void execute() {

		handleM();

//		addWaterCubes(2, ERegion.NOORDZEE);
//		addWaterCubes(2, ERegion.ZUIDERZEE);
		addWaterCubes(1, ERegion.FRYSLAN);
		addWaterCubes(1, ERegion.IJSSELDELTA);
		addWaterCubes(1, ERegion.MARKERWAARD);
		addWaterCubes(1, ERegion.BETUWE);
		addWaterCubes(3, ERegion.NOORDOOSTPOLDER);
		addWaterCubes(3, ERegion.VOLLENHOVE);
		addWaterCubes(2, ERegion.RIJN_EN_IJSSEL);
		addWaterCubes(3, ERegion.ZUIDERZEE);

		addPopulations(3, ERegion.FRYSLAN);

		addWaterPump(ERegion.FRYSLAN);
		addWaterPump(ERegion.IJSSELDELTA);
		addWaterPump(ERegion.FLEVOLAND);

		addPort(ERegion.FRYSLAN);

		addPawn(ERole.CARPENTER, ERegion.FRYSLAN);
		addPawn(ERole.SANITATION_ENGINEER, ERegion.FRYSLAN);
		addPawn(ERole.WEREHOUSE_MANAGER, ERegion.FRYSLAN);

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

		playerRole(EPlayer.TOP, ERole.CARPENTER);
		playerCardRegion(EPlayer.TOP, ERegion.BETUWE);
		playerCardRegion(EPlayer.TOP, ERegion.BETUWE);
		playerCardRegion(EPlayer.TOP, ERegion.BETUWE);
		playerCardRegion(EPlayer.TOP, ERegion.BETUWE);
		playerCardRegion(EPlayer.TOP, ERegion.BETUWE);
		playerCardRegion(EPlayer.TOP, ERegion.BETUWE);
		playerCardRegion(EPlayer.TOP, ERegion.BETUWE);
		playerCardRegion(EPlayer.TOP, ERegion.ROER_EN_OVERMAAS);

		playerRole(EPlayer.BOTTOM, ERole.DIRECTOR);
		playerCardRegion(EPlayer.BOTTOM, ERegion.FRYSLAN);
//		playerCardRegion(EPlayer.BOTTOM, ERegion.FRYSLAN);
//		playerCardRegion(EPlayer.BOTTOM, ERegion.FRYSLAN);
//		playerCardRegion(EPlayer.BOTTOM, ERegion.FRYSLAN);
//		playerCardRegion(EPlayer.BOTTOM, ERegion.FRYSLAN);
//		playerCardRegion(EPlayer.BOTTOM, ERegion.FRYSLAN);
//		playerCardRegion(EPlayer.BOTTOM, ERegion.MARKERWAARD);

		addDikesFailureCardToDiscardPile(ERegion.FRYSLAN);
//		addDikesFailureCardToDiscardPile(ERegion.VOLLENHOVE);

//		WaterFlows.INSTANCE.execute();

//		Actions.INSTANCE.showAction(EAction.DIKE_FAIL);
//		Actions.INSTANCE.showAction(EAction.WATER_FLOWS);

		getFlow().addLast(WaterFlows.class);
		getFlow().addLast(ActionOperatePumps.class);
		getFlow().addLast(WaterFlows.class);
//		getFlow().addLast(SelectWaterPumpAvailableToOperate.class);
//		getFlow().addLast(SelectWaterRegionsWithWaterPump.class);
//		getFlow().addLast(DegradeRegionWithFlood.class, 50);
//		getFlow().addLast(WaterFlows.class);
		proceedToNextGameState();

	}

	@Override
	protected void handleKeyPressed(KeyCode keyCode) {

	}

	public void addPopulations(int amount, ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		for (int counter = 1; counter <= amount; counter++) {

			PopulationCube population = new PopulationCube();
			population.getImageView().setHeight(Credentials.INSTANCE.hWaterPopulationCubeMap);
			region.getPopulations().getArrayList().addLast(population);

		}

		region.relocateComponents();

	}

	public void addWaterCubes(int amount, ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		for (int counter = 1; counter <= amount; counter++) {

			WaterCube waterCube = new WaterCube();
			waterCube.getImageView().setHeight(Credentials.INSTANCE.hWaterPopulationCubeMap);
			region.getWaterCubes().getArrayList().addLast(waterCube);

		}

		region.relocateComponents();

	}

	public void addWaterPump(ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		region.getWaterPumps().getArrayList().addLast(new WaterPump());
		region.getWaterPumps().getArrayList().getLast().getImageView()
				.setHeight(Credentials.INSTANCE.hPortWaterPumpMap);

		region.relocateComponents();

	}

	public void addPort(ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		region.getPorts().getArrayList().addLast(new Port());
		region.getPorts().getArrayList().getLast().getImageView()
				.setHeight(Credentials.INSTANCE.hPortWaterPumpMap);

		region.relocateComponents();

	}

	public void addPawn(ERole eRole, ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		region.getPawns().getArrayList().addLast(new Pawn(eRole));
		region.getPawns().getArrayList().getLast().getImageView().setVisible(true);

		region.relocateComponents();

	}

	public void addDike(ERegion eRegionA, ERegion eRegionB) {

		ArrayList<Adjacency> list = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegionA);
		Adjacency adjacency = null;

		for (Adjacency adjacencyTemp : list) {

			if (!adjacencyTemp.getERegions().contains(eRegionB))
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

		for (CardPlayerRegion cardPlayerRegionTemp : Cards.INSTANCE.getCardsPlayerRegionClone())
			if (eRegion.equals(cardPlayerRegionTemp.getERegion()))
				eColor = cardPlayerRegionTemp.getEColor();

		cardPlayerRegion = new CardPlayerRegion(eRegion, eColor);
		cardPlayerRegion.getImageView().setVisible(true);

		player.getCardsPlayer().getArrayList().addLast(cardPlayerRegion);
		player.getCardsPlayer().relocateImageViews();

	}

	public void playerRole(EPlayer ePlayer, ERole eRole) {

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

	}

	public void addDikesFailureCardToDiscardPile(ERegion eRegion) {

		CardDikeFailure cardDikeFailure = new CardDikeFailure(eRegion);
		cardDikeFailure.getImageView().setVisible(true);

		DiscardPileDikeFailure.INSTANCE.addFirstRelocate(cardDikeFailure);

	}

}
