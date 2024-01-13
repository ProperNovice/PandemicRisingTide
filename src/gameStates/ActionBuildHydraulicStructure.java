package gameStates;

import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.EAction;
import enums.EColor;
import functions.DiscardCardsSelected;
import functions.GetCardsSelectedActivePlayer;
import functions.GetERegionContainingPlayerPawn;
import functions.SelectCardsForHydraulicStructure;
import gameStatesDefault.GameState;
import javafx.scene.input.KeyCode;
import model.Actions;
import model.HydraulicStructures;
import model.Players;

public class ActionBuildHydraulicStructure extends GameState {

	@Override
	public void execute() {

		SelectCardsForHydraulicStructure.INSTANCE.execute();

		if (GetCardsSelectedActivePlayer.INSTANCE.execute().size() == 5)
			discardCardsSelectedProceed();
		else
			EAction.BUILD_HYDRAULIC_STRUCTURE.show();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		discardCardsSelectedProceed();

	}

	@Override
	protected void handleKeyPressed(KeyCode keyCode) {

		for (CardPlayer cardPlayer : Players.INSTANCE.getActivePlayer().getCardsPlayer()) {

			CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;

			System.out.println(cardPlayerRegion.getERegion() + " - " + cardPlayerRegion.getEColor()
					+ " - " + cardPlayerRegion.isSelected());

		}

		System.out.println();

	}

	@Override
	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

		if (!(cardPlayer instanceof CardPlayerRegion))
			return;

		CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;
		EColor eColor = cardPlayerRegion.getEColor();

		if (!eColor.equals(GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive().getRegion().getEColor()))
			return;

		cardPlayerRegion.reverseSelected();

		if (GetCardsSelectedActivePlayer.INSTANCE.execute().size() == 5)
			Actions.INSTANCE.selectAction(EAction.BUILD_HYDRAULIC_STRUCTURE);
		else
			Actions.INSTANCE.deselectAction(EAction.BUILD_HYDRAULIC_STRUCTURE);

	}

	private void discardCardsSelectedProceed() {

		DiscardCardsSelected.INSTANCE.execute();

		HydraulicStructures.INSTANCE
				.buildHydraulicStructureMap(GetERegionContainingPlayerPawn.INSTANCE
						.getERegionContainingPlayerPawnActive().getRegion().getEColor());

		proceedToNextGameState();

	}

}
