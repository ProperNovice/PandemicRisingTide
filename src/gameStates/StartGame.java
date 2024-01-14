package gameStates;

import business.DikeLocation;
import enums.ERegion;
import enums.EText;
import functions.AddWaterToRegion;
import functions.BuildDike;
import gameStatesDefault.GameState;
import model.Adjacencies;
import model.Cards;
import model.DeckDikeFailure;
import model.HydraulicStructures;
import model.SeaLevel;

public class StartGame extends GameState {

	@Override
	public void execute() {

		EText.START_GAME.show();
		HydraulicStructures.INSTANCE.reset();
		ERegion.ZUIDERZEE.getRegion().setIsSea(true);
		SeaLevel.INSTANCE.reset();

		setUpDikes();
		setUpWaterCubes();
		createDikeFailureDeck();
		createDegradeRegions();

		proceedToNextGameState();

	}

	@Override
	protected void executeTextOption(EText eText) {

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
