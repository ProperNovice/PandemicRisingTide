package resolveEvents;

import business.Adjacency;
import business.Region;
import cards.Card;
import cards.CardRole;
import enums.EAction;
import enums.ERegion;
import functions.MovePawnToRegion;
import gameStatesDefault.GameState;
import model.Actions;
import model.Adjacencies;
import model.Players;
import utils.ArrayList;
import utils.Interfaces.IImageViewAble;
import utils.Logger;
import utils.SelectImageViewManager;

public class ResolveEventZuiderzeevereeniging extends GameState {

	private boolean activePlayerIsSelected = false;
	private boolean passivePlayerIsSelected = false;

	@Override
	public void execute() {

		EAction.RESOLVE_EVENT.show();

	}

	@Override
	protected void handleCardRolePlayerPressed(CardRole cardRole) {

		Actions.INSTANCE.concealActions();

		cardRole.reverseSelected();

		if (SelectImageViewManager.INSTANCE.getSelectedImageViewAbles().isEmpty())
			EAction.RESOLVE_EVENT.show();
		else
			EAction.RESOLVE_EVENT.showAndSelect();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		for (IImageViewAble imageViewAble : SelectImageViewManager.INSTANCE
				.getSelectedImageViewAbles()) {

			Card card = (Card) imageViewAble;

			if (Players.INSTANCE.getActivePlayer().getCardRole().getArrayList().contains(card))
				this.activePlayerIsSelected = true;

			else if (Players.INSTANCE.getPassivePlayer().getCardRole().getArrayList()
					.contains(card))
				this.passivePlayerIsSelected = true;

		}

		Logger.INSTANCE.log("active - " + this.activePlayerIsSelected);
		Logger.INSTANCE.log("passive - " + this.passivePlayerIsSelected);
		Logger.INSTANCE.newLine();

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		EAction.RESOLVE_EVENT.show();
		selectRegionsAdjacentToSeas();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		Actions.INSTANCE.concealActions();

		MovePawnToRegion.INSTANCE.setUpERegionToMove(eRegion);

		if (this.activePlayerIsSelected)
			MovePawnToRegion.INSTANCE.moveToERegionActivePlayer();
		if (this.passivePlayerIsSelected)
			MovePawnToRegion.INSTANCE.moveToERegionPassivePlayer();

		proceedToNextGameState();

	}

	private void selectRegionsAdjacentToSeas() {

		for (ERegion eRegion : ERegion.values()) {

			ArrayList<Adjacency> list = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion);

			for (Adjacency adjacency : list) {

				if (!adjacency.getERegionsClone().contains(ERegion.ZUIDERZEE)
						&& !adjacency.getERegionsClone().contains(ERegion.NOORDZEE))
					continue;

				for (ERegion eRegionTemp : adjacency.getERegionsClone())

					if (eRegionTemp.equals(ERegion.ZUIDERZEE)
							|| eRegionTemp.equals(ERegion.NOORDZEE))
						continue;

					else if (!eRegionTemp.getRegion().isSelected())
						eRegionTemp.getRegion().setSelected();

			}

		}

	}

}
