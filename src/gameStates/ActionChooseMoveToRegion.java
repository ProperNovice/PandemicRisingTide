package gameStates;

import business.Region;
import enums.EAction;
import enums.ERegion;
import enums.ERole;
import functions.PawnMoveToRegion;
import functions.SetUpMoveTargetRegions;
import gameStatesDefault.GameState;
import model.Actions;
import model.Players;
import utils.SelectImageViewManager;

public class ActionChooseMoveToRegion extends GameState {

	private boolean moveActivePlayer = true;

	@Override
	public void execute() {

		EAction.MOVE.show();
		SetUpMoveTargetRegions.INSTANCE.executeActivePlayer();

		if (!Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().getFirst().getERole()
				.equals(ERole.DIRECTOR))
			return;

		EAction.MOVE_PASSIVE_PLAYER.showAndSelect();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		this.moveActivePlayer = false;

		EAction.MOVE.show();
		SetUpMoveTargetRegions.INSTANCE.executePassivePlayer();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();
		PawnMoveToRegion.INSTANCE.setUpERegionToMove(eRegion);

		if (this.moveActivePlayer)
			handleRegionSelectedPressedActivePlayer(eRegion);
		else if (!moveActivePlayer)
			handleRegionSelectedPressedPassivePlayer(eRegion);

		proceedToNextGameState();

	}

	private void handleRegionSelectedPressedActivePlayer(ERegion eRegion) {

		if (SetUpMoveTargetRegions.INSTANCE.getFreeERegions().contains(eRegion))
			PawnMoveToRegion.INSTANCE.moveToERegionActivePlayer();
		else
			getFlow().addFirst(ChooseCardToDiscardForMoving.class);

	}

	private void handleRegionSelectedPressedPassivePlayer(ERegion eRegion) {
		PawnMoveToRegion.INSTANCE.moveToERegionPassivePlayer();
	}

}
