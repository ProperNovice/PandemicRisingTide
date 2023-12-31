package model;

import cards.CardPlayerEvent;
import cards.CardPlayerRegion;
import cards.CardPlayerStorm;
import enums.EColor;
import enums.EEvent;
import enums.ERegion;
import utils.ArrayList;

public enum Cards {

	INSTANCE;

	private ArrayList<CardPlayerRegion> cardsPlayerRegion = new ArrayList<>();
	private ArrayList<CardPlayerEvent> cardPlayerEvent = new ArrayList<>();
	private ArrayList<CardPlayerStorm> cardPlayerStorm = new ArrayList<>();

	private Cards() {

		createCardsPlayerCardPlayerRegion();
		createCardsPlayerEvent();
		createCardsPlayerStorm();

	}

	private void createCardsPlayerStorm() {

		for (int counter = 1; counter <= 8; counter++)
			this.cardPlayerStorm.addLast(new CardPlayerStorm());

	}

	private void createCardsPlayerEvent() {

		for (EEvent eEvent : EEvent.values())
			this.cardPlayerEvent.addLast(new CardPlayerEvent(eEvent));

	}

	private void createCardsPlayerCardPlayerRegion() {

		// purple

		this.cardsPlayerRegion
				.addLast(new CardPlayerRegion(ERegion.NOORDERZIJLVEST, EColor.PURPLE));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.FRYSLAN, EColor.PURPLE));
		this.cardsPlayerRegion
				.addLast(new CardPlayerRegion(ERegion.NOORDOOSTPOLDER, EColor.PURPLE));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.FLEVOLAND, EColor.PURPLE));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.MARKERWAARD, EColor.PURPLE));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.WIERINGERMEER, EColor.PURPLE));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.KENNEMERLAND, EColor.PURPLE));

		// orange

		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.DELFLAND, EColor.ORANGE));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.VOORNE_PUTTEN, EColor.ORANGE));
		this.cardsPlayerRegion
				.addLast(new CardPlayerRegion(ERegion.GOERRE_OVERFLAKKEE, EColor.ORANGE));
		this.cardsPlayerRegion
				.addLast(new CardPlayerRegion(ERegion.SCHOUWEN_DUIVELAND, EColor.ORANGE));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.WALCHEREN, EColor.ORANGE));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.ZUID_BEVELAND, EColor.ORANGE));
		this.cardsPlayerRegion
				.addLast(new CardPlayerRegion(ERegion.ZEEUWS_VLAANDEREN, EColor.ORANGE));

		// green

		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.WEST_BRABANT, EColor.GREEN));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.HOEKSE_WAARD, EColor.GREEN));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.LAND_VAN_ALTENA, EColor.GREEN));
		this.cardsPlayerRegion
				.addLast(new CardPlayerRegion(ERegion.LAND_VAN_HEUSDEN, EColor.GREEN));
		this.cardsPlayerRegion
				.addLast(new CardPlayerRegion(ERegion.LAND_VAN_MAAS_EN_WAAL, EColor.GREEN));
		this.cardsPlayerRegion
				.addLast(new CardPlayerRegion(ERegion.PEEL_EN_MAASVALLEI, EColor.GREEN));
		this.cardsPlayerRegion
				.addLast(new CardPlayerRegion(ERegion.ROER_EN_OVERMAAS, EColor.GREEN));

		// yellow

		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.VOLLENHOVE, EColor.YELLOW));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.IJSSELDELTA, EColor.YELLOW));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.RIJN_EN_IJSSEL, EColor.YELLOW));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.BETUWE, EColor.YELLOW));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.VIJFHERELANDEN, EColor.YELLOW));
		this.cardsPlayerRegion.addLast(new CardPlayerRegion(ERegion.KROMME_RIJN, EColor.YELLOW));
		this.cardsPlayerRegion
				.addLast(new CardPlayerRegion(ERegion.GELDERSE_VALLEI, EColor.YELLOW));

	}

}
