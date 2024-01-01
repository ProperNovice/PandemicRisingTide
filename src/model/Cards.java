package model;

import cards.CardDikeFailure;
import cards.CardPlayerEvent;
import cards.CardPlayerRegion;
import cards.CardPlayerStorm;
import cards.CardRole;
import enums.EColor;
import enums.EEvent;
import enums.ERegion;
import enums.ERole;
import utils.ArrayList;

public enum Cards {

	INSTANCE;

	private ArrayList<CardPlayerRegion> cardsPlayerRegion = new ArrayList<>();
	private ArrayList<CardPlayerEvent> cardsPlayerEvent = new ArrayList<>();
	private ArrayList<CardPlayerStorm> cardsPlayerStorm = new ArrayList<>();
	private ArrayList<CardDikeFailure> cardsDikeFailure = new ArrayList<>();
	private ArrayList<CardRole> cardsRole = new ArrayList<>();

	private Cards() {

		createCardsRegion();
		createCardsPlayerEvent();
		createCardsPlayerStorm();
		createCardsRole();

	}

	public ArrayList<CardPlayerRegion> getCardsPlayerRegionClone() {
		return this.cardsPlayerRegion.clone();
	}

	public ArrayList<CardPlayerEvent> getCardsPlayerEventClone() {
		return this.cardsPlayerEvent.clone();
	}

	public ArrayList<CardPlayerStorm> getCardsPlayerStormClone() {
		return this.cardsPlayerStorm.clone();
	}

	public ArrayList<CardDikeFailure> getCardsDikeFailureClone() {
		return this.cardsDikeFailure.clone();
	}

	public ArrayList<CardRole> getCardsRoleClone() {
		return this.cardsRole.clone();
	}

	private void createCardsRole() {

		for (ERole eRole : ERole.values())
			this.cardsRole.addLast(new CardRole(eRole));

	}

	private void createCardsPlayerStorm() {

		for (int counter = 1; counter <= 8; counter++)
			this.cardsPlayerStorm.addLast(new CardPlayerStorm());

	}

	private void createCardsPlayerEvent() {

		for (EEvent eEvent : EEvent.values())
			this.cardsPlayerEvent.addLast(new CardPlayerEvent(eEvent));

	}

	private void createCardsRegion() {

		// purple

		createCardsRegion(ERegion.NOORDERZIJLVEST, EColor.PURPLE);
		createCardsRegion(ERegion.FRYSLAN, EColor.PURPLE);
		createCardsRegion(ERegion.NOORDOOSTPOLDER, EColor.PURPLE);
		createCardsRegion(ERegion.FLEVOLAND, EColor.PURPLE);
		createCardsRegion(ERegion.MARKERWAARD, EColor.PURPLE);
		createCardsRegion(ERegion.WIERINGERMEER, EColor.PURPLE);
		createCardsRegion(ERegion.KENNEMERLAND, EColor.PURPLE);

		// orange

		createCardsRegion(ERegion.DELFLAND, EColor.ORANGE);
		createCardsRegion(ERegion.VOORNE_PUTTEN, EColor.ORANGE);
		createCardsRegion(ERegion.GOERRE_OVERFLAKKEE, EColor.ORANGE);
		createCardsRegion(ERegion.SCHOUWEN_DUIVELAND, EColor.ORANGE);
		createCardsRegion(ERegion.WALCHEREN, EColor.ORANGE);
		createCardsRegion(ERegion.ZUID_BEVELAND, EColor.ORANGE);
		createCardsRegion(ERegion.ZEEUWS_VLAANDEREN, EColor.ORANGE);

		// green

		createCardsRegion(ERegion.WEST_BRABANT, EColor.GREEN);
		createCardsRegion(ERegion.HOEKSE_WAARD, EColor.GREEN);
		createCardsRegion(ERegion.LAND_VAN_ALTENA, EColor.GREEN);
		createCardsRegion(ERegion.LAND_VAN_HEUSDEN, EColor.GREEN);
		createCardsRegion(ERegion.LAND_VAN_MAAS_EN_WAAL, EColor.GREEN);
		createCardsRegion(ERegion.PEEL_EN_MAASVALLEI, EColor.GREEN);
		createCardsRegion(ERegion.ROER_EN_OVERMAAS, EColor.GREEN);

		// yellow

		createCardsRegion(ERegion.VOLLENHOVE, EColor.YELLOW);
		createCardsRegion(ERegion.IJSSELDELTA, EColor.YELLOW);
		createCardsRegion(ERegion.RIJN_EN_IJSSEL, EColor.YELLOW);
		createCardsRegion(ERegion.BETUWE, EColor.YELLOW);
		createCardsRegion(ERegion.VIJFHERELANDEN, EColor.YELLOW);
		createCardsRegion(ERegion.KROMME_RIJN, EColor.YELLOW);
		createCardsRegion(ERegion.GELDERSE_VALLEI, EColor.YELLOW);

	}

	private void createCardsRegion(ERegion eRegion, EColor eColor) {
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(eRegion, eColor));
		this.cardsDikeFailure.addLast(new CardDikeFailure(eRegion));
	}

}
