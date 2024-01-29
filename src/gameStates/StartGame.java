package gameStates;

import business.DikeLocation;
import business.Pawn;
import business.Player;
import cards.CardObjective;
import cards.CardPlayer;
import cards.CardRole;
import enums.EAction;
import enums.EColor;
import enums.EObjective;
import enums.ERegion;
import enums.EText;
import functions.AddCardToPlayer;
import functions.AddWaterToRegion;
import functions.BuildDike;
import functions.UpdateDikeFailureCardsDrawnCircle;
import gameStatesDefault.GameState;
import model.Adjacencies;
import model.Cards;
import model.CheckForObjectivesAreCompleted;
import model.DeckDikeFailure;
import model.DeckPlayer;
import model.HydraulicStructures;
import model.Objectives;
import model.Pawns;
import model.Players;
import model.PopulationLoss;
import model.SeaLevel;
import utils.ArrayList;

public class StartGame extends GameState {

	private ArrayList<CardPlayer> deck = new ArrayList<>();

	@Override
	public void execute() {

		EText.START_GAME.show();
		HydraulicStructures.INSTANCE.reset();
		UpdateDikeFailureCardsDrawnCircle.INSTANCE.reset();
		ERegion.ZUIDERZEE.getRegion().setIsSea(true);
		SeaLevel.INSTANCE.reset();
		CheckForObjectivesAreCompleted.INSTANCE.set(true);

		EAction.START_GAME.showAndSelect();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		setUpDikes();
		setUpWaterCubes();
		createDikeFailureDeck();
		createDegradeRegions();
		createPlayerRoles();
		addPlayerPawns();
		createPlayerHands();
		createPlayerDeck();
		setUpObjectives();

		Players.INSTANCE.changePlayerOrder();

		getFlow().addLast(StartNewTurn.class);

		proceedToNextGameState();

	}

	private void setUpObjectives() {

		Objectives.INSTANCE.setUpObjectives(4);

		for (CardObjective cardObjective : Objectives.INSTANCE.getObjectivesCurrent()) {

			if (!cardObjective.getEColor().equals(EColor.RED))
				continue;

			if (!cardObjective.getEObjective().equals(EObjective.SPECIAL))
				continue;

			getFlow().addLast(ResolveRedSpecialObjectiveStartGame.class);

		}

		PopulationLoss.INSTANCE.setVisible(false);

		for (CardObjective cardObjective : Objectives.INSTANCE.getObjectivesCurrent()) {

			if (!cardObjective.getEObjective().equals(EObjective.POPULATION))
				continue;

			PopulationLoss.INSTANCE.setVisible(true);
			break;

		}

	}

	private void createPlayerDeck() {

		int stormCards = 6;

		// create piles

		ArrayList<ArrayList<CardPlayer>> lists = new ArrayList<>();

		for (int counter = 1; counter <= stormCards; counter++)
			lists.addLast(new ArrayList<>());

		// populate piles

		int index = 0;

		while (!this.deck.isEmpty()) {

			ArrayList<CardPlayer> listTemp = lists.get(index);
			listTemp.addLast(this.deck.removeRandom());

			index++;

			if (index == lists.size())
				index = 0;

		}

		// add storm cards

		ArrayList<CardPlayer> storms = Cards.INSTANCE.getCardsPlayerStormClone();

		for (ArrayList<CardPlayer> listTemp : lists) {

			CardPlayer cardPlayer = storms.removeRandom();
			cardPlayer.getImageView().setVisible(true);
			listTemp.addLast(cardPlayer);

		}

		// shuffle piles

		for (ArrayList<CardPlayer> listTemp : lists)
			listTemp.shuffle();

		lists.shuffle();

		// add to deck

		for (ArrayList<CardPlayer> listTemp : lists)
			DeckPlayer.INSTANCE.addDeckFirst(listTemp);

	}

	private void createPlayerHands() {

		// create cards region

		this.deck.addAllLast(Cards.INSTANCE.getCardsPlayerRegionClone());

		// add card events

		ArrayList<CardPlayer> events = Cards.INSTANCE.getCardsPlayerEventClone();

		for (int counter = 1; counter <= 4; counter++)
			this.deck.addLast(events.removeRandom());

		// draw four cards

		CardPlayer cardPlayer = null;

		for (int counter = 1; counter <= 4; counter++) {

			cardPlayer = this.deck.removeRandom();
			cardPlayer.getImageView().setVisible(true);
			AddCardToPlayer.INSTANCE.executeActivePlayer(cardPlayer);

			cardPlayer = this.deck.removeRandom();
			cardPlayer.getImageView().setVisible(true);
			AddCardToPlayer.INSTANCE.executePassivePlayer(cardPlayer);

		}

	}

	private void addPlayerPawns() {

		ArrayList<Player> list = new ArrayList<>();
		list.addLast(Players.INSTANCE.getActivePlayer());
		list.addLast(Players.INSTANCE.getPassivePlayer());

		for (Player player : list) {

			Pawn pawn = null;
			pawn = Pawns.INSTANCE
					.getPawn(player.getCardRole().getArrayList().getFirst().getERole());
			pawn.getImageView().setVisible(true);
			ERegion.DELFLAND.getRegion().getPawns().getArrayList().addLast(pawn);

		}

		ERegion.DELFLAND.getRegion().relocateComponents();

	}

	private void createPlayerRoles() {

		ArrayList<CardRole> list = Cards.INSTANCE.getCardsRoleClone();
		CardRole cardRole = null;

		// player active

		cardRole = list.removeRandom();
		cardRole.getImageView().setVisible(true);
		Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().addLast(cardRole);
		Players.INSTANCE.getActivePlayer().getCardRole().relocateImageViews();

		// player passive

		cardRole = list.removeRandom();
		cardRole.getImageView().setVisible(true);
		Players.INSTANCE.getPassivePlayer().getCardRole().getArrayList().addLast(cardRole);
		Players.INSTANCE.getPassivePlayer().getCardRole().relocateImageViews();

	}

	private void createDegradeRegions() {

		for (int degradeRegionAmount = 3; degradeRegionAmount >= 1; degradeRegionAmount--) {

			for (int cardsDikeFailureToDraw = 1; cardsDikeFailureToDraw <= 3; cardsDikeFailureToDraw++) {

				getFlow().addLast(DrawCardDikeFailure.class);
				getFlow().addLast(DegradeRegionNoFlood.class, degradeRegionAmount);

			}

		}

		getFlow().addLast(ActionWaterFlows.class);

	}

	private void createDikeFailureDeck() {
		DeckDikeFailure.INSTANCE.setUpDeck(Cards.INSTANCE.getCardsDikeFailureClone());
	}

	private void setUpWaterCubes() {

		AddWaterToRegion.INSTANCE.execute(ERegion.NOORDZEE);
		AddWaterToRegion.INSTANCE.execute(ERegion.NOORDZEE);
		AddWaterToRegion.INSTANCE.execute(ERegion.ZUIDERZEE);
		AddWaterToRegion.INSTANCE.execute(ERegion.ZUIDERZEE);
		AddWaterToRegion.INSTANCE.execute(ERegion.WIERINGERMEER);
		AddWaterToRegion.INSTANCE.execute(ERegion.MARKERWAARD);
		AddWaterToRegion.INSTANCE.execute(ERegion.MARKERWAARD);
		AddWaterToRegion.INSTANCE.execute(ERegion.FLEVOLAND);
		AddWaterToRegion.INSTANCE.execute(ERegion.FLEVOLAND);
		AddWaterToRegion.INSTANCE.execute(ERegion.NOORDOOSTPOLDER);
		AddWaterToRegion.INSTANCE.execute(ERegion.NOORDOOSTPOLDER);

	}

	private void setUpDikes() {

		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDZEE, ERegion.ZEEUWS_VLAANDEREN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDZEE, ERegion.WALCHEREN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDZEE, ERegion.SCHOUWEN_DUIVELAND));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDZEE, ERegion.GOERRE_OVERFLAKKEE));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDZEE, ERegion.VOORNE_PUTTEN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDZEE, ERegion.DELFLAND));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDZEE, ERegion.KENNEMERLAND));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDZEE, ERegion.FRYSLAN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDZEE, ERegion.NOORDERZIJLVEST));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.WALCHEREN, ERegion.ZEEUWS_VLAANDEREN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.WALCHEREN, ERegion.ZUID_BEVELAND));
		BuildDike.INSTANCE
				.execute(getDikeLocation(ERegion.ZEEUWS_VLAANDEREN, ERegion.ZUID_BEVELAND));
		BuildDike.INSTANCE
				.execute(getDikeLocation(ERegion.SCHOUWEN_DUIVELAND, ERegion.ZUID_BEVELAND));
		BuildDike.INSTANCE
				.execute(getDikeLocation(ERegion.SCHOUWEN_DUIVELAND, ERegion.GOERRE_OVERFLAKKEE));
		BuildDike.INSTANCE
				.execute(getDikeLocation(ERegion.SCHOUWEN_DUIVELAND, ERegion.WEST_BRABANT));
		BuildDike.INSTANCE
				.execute(getDikeLocation(ERegion.GOERRE_OVERFLAKKEE, ERegion.VOORNE_PUTTEN));
		BuildDike.INSTANCE
				.execute(getDikeLocation(ERegion.GOERRE_OVERFLAKKEE, ERegion.WEST_BRABANT));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.DELFLAND, ERegion.VOORNE_PUTTEN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.DELFLAND, ERegion.KROMME_RIJN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.DELFLAND, ERegion.MARKERWAARD));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.HOEKSE_WAARD, ERegion.VOORNE_PUTTEN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.HOEKSE_WAARD, ERegion.VIJFHERELANDEN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.HOEKSE_WAARD, ERegion.LAND_VAN_ALTENA));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.HOEKSE_WAARD, ERegion.WEST_BRABANT));
		BuildDike.INSTANCE
				.execute(getDikeLocation(ERegion.LAND_VAN_ALTENA, ERegion.VIJFHERELANDEN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.LAND_VAN_ALTENA, ERegion.WEST_BRABANT));
		BuildDike.INSTANCE
				.execute(getDikeLocation(ERegion.LAND_VAN_ALTENA, ERegion.LAND_VAN_HEUSDEN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.BETUWE, ERegion.LAND_VAN_HEUSDEN));
		BuildDike.INSTANCE
				.execute(getDikeLocation(ERegion.LAND_VAN_HEUSDEN, ERegion.LAND_VAN_MAAS_EN_WAAL));
		BuildDike.INSTANCE
				.execute(getDikeLocation(ERegion.LAND_VAN_HEUSDEN, ERegion.LAND_VAN_MAAS_EN_WAAL));
		BuildDike.INSTANCE.execute(
				getDikeLocation(ERegion.PEEL_EN_MAASVALLEI, ERegion.LAND_VAN_MAAS_EN_WAAL));
		BuildDike.INSTANCE
				.execute(getDikeLocation(ERegion.PEEL_EN_MAASVALLEI, ERegion.ROER_EN_OVERMAAS));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.BETUWE, ERegion.VIJFHERELANDEN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.BETUWE, ERegion.KROMME_RIJN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.BETUWE, ERegion.RIJN_EN_IJSSEL));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.BETUWE, ERegion.LAND_VAN_MAAS_EN_WAAL));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.KROMME_RIJN, ERegion.VIJFHERELANDEN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.VOLLENHOVE, ERegion.RIJN_EN_IJSSEL));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.VOLLENHOVE, ERegion.RIJN_EN_IJSSEL));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.IJSSELDELTA, ERegion.RIJN_EN_IJSSEL));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.IJSSELDELTA, ERegion.FLEVOLAND));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.FLEVOLAND, ERegion.KROMME_RIJN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.FLEVOLAND, ERegion.GELDERSE_VALLEI));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDOOSTPOLDER, ERegion.IJSSELDELTA));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDOOSTPOLDER, ERegion.VOLLENHOVE));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.NOORDOOSTPOLDER, ERegion.FRYSLAN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.ZUIDERZEE, ERegion.FRYSLAN));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.ZUIDERZEE, ERegion.KENNEMERLAND));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.MARKERWAARD, ERegion.KENNEMERLAND));
		BuildDike.INSTANCE.execute(getDikeLocation(ERegion.WIERINGERMEER, ERegion.KENNEMERLAND));

	}

	private DikeLocation getDikeLocation(ERegion eRegionA, ERegion eRegionB) {
		return Adjacencies.INSTANCE.getAdjecencyBetweenRegions(eRegionA, eRegionB)
				.getDikeLocation();
	}

}
