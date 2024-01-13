package gameStates;

import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.EAction;
import enums.EColor;
import functions.BuildHydraulicStructure;
import functions.DiscardCardsSelected;
import functions.GetCardsSelectedActivePlayer;
import functions.GetERegionContainingPlayerPawn;
import functions.SelectCardsForHydraulicStructure;
import gameStatesDefault.GameState;
import model.Actions;

public class ActionBuildHydraulicStructure extends GameState {

	@Override
	public void execute() {

		SelectCardsForHydraulicStructure.INSTANCE.execute();

		if (GetCardsSelectedActivePlayer.INSTANCE.execute().size() == 5)
			proceed();
		else
			EAction.BUILD_HYDRAULIC_STRUCTURE.show();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {
		proceed();
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

	private void proceed() {

		DiscardCardsSelected.INSTANCE.execute();
		BuildHydraulicStructure.INSTANCE.execute();
		proceedToNextGameState();

	}

}
