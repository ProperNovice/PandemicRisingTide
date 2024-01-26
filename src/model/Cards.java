package model;

import cards.CardDikeFailure;
import cards.CardPlayer;
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

	private ArrayList<CardPlayer> cardsPlayerRegion = new ArrayList<>();
	private ArrayList<CardPlayer> cardsPlayerEvent = new ArrayList<>();
	private ArrayList<CardPlayer> cardsPlayerStorm = new ArrayList<>();
	private ArrayList<CardDikeFailure> cardsDikeFailure = new ArrayList<>();
	private ArrayList<CardRole> cardsRole = new ArrayList<>();

	private Cards() {

		createCardsRegion();
		createCardsPlayerEvent();
		createCardsPlayerStorm();
		createCardsRole();

	}

	public ArrayList<CardPlayer> getCardsPlayerRegionClone() {
		return this.cardsPlayerRegion.clone();
	}

	public ArrayList<CardPlayer> getCardsPlayerEventClone() {
		return this.cardsPlayerEvent.clone();
	}

	public ArrayList<CardPlayer> getCardsPlayerStormClone() {
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

		createCardsRegion(ERegion.DELFLAND, EColor.RED);
		createCardsRegion(ERegion.VOORNE_PUTTEN, EColor.RED);
		createCardsRegion(ERegion.GOERRE_OVERFLAKKEE, EColor.RED);
		createCardsRegion(ERegion.SCHOUWEN_DUIVELAND, EColor.RED);
		createCardsRegion(ERegion.WALCHEREN, EColor.RED);
		createCardsRegion(ERegion.ZUID_BEVELAND, EColor.RED);
		createCardsRegion(ERegion.ZEEUWS_VLAANDEREN, EColor.RED);

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

		for (int counter = 1; counter <= 2; counter++) {

			this.cardsPlayerRegion.addLast(new CardPlayerRegion(eRegion, eColor));
			this.cardsDikeFailure.addLast(new CardDikeFailure(eRegion));

		}

	}

}
