package gameStates;

import business.Region;
import cards.CardPlayer;
import enums.EAction;
import enums.EColor;
import enums.ERegion;
import functions.DiscardCardFromPlayer;
import functions.ExpandPopulationToERegion;
import functions.GetCardsPlayerHasWithEColor;
import functions.GetCardsSelectedActivePlayer;
import functions.GetERegionContainingPlayerPawn;
import gameStatesDefault.GameState;
import model.Actions;
import model.Populations;
import utils.ArrayList;
import utils.SelectImageViewManager;

public class ActionExpandPopulation extends GameState {

	private ArrayList<CardPlayer> list = new ArrayList<>();
	private int populationCanBeAdded = 3;
	private ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
			.getERegionContainingPlayerPawnActive();
	private Region region = eRegion.getRegion();
	private EColor eColor = region.getEColor();

	@Override
	public void execute() {

		createDiscardableCards();
		calculatePopulationCanBeAdded();
		handle();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {

		for (CardPlayer cardPlayer : GetCardsSelectedActivePlayer.INSTANCE.execute()) {

			DiscardCardFromPlayer.INSTANCE.executeActivePlayer(cardPlayer);
			ExpandPopulationToERegion.INSTANCE.execute(this.eRegion);

		}

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		proceedToNextGameState();

	}

	@Override
	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

		if (!this.list.contains(cardPlayer))
			return;

		cardPlayer.reverseSelected();
		handle();

	}

	private void calculatePopulationCanBeAdded() {

		this.populationCanBeAdded -= this.region.getWaterCubes().getArrayList().size();
		this.populationCanBeAdded -= this.region.getPopulations().getArrayList().size();

		this.populationCanBeAdded = Math.min(this.populationCanBeAdded,
				Populations.INSTANCE.getList().getArrayList().size());

	}

	private void handle() {

		Actions.INSTANCE.concealActions();

		EAction.EXPAND_POPULATION.show();

		if (SelectImageViewManager.INSTANCE.getSelectedImageViewAbles().size() == 0)
			EAction.CHOOSE_CARD_TO_DISCARD.show();

		else if (SelectImageViewManager.INSTANCE.getSelectedImageViewAbles()
				.size() > this.populationCanBeAdded)
			EAction.CHOOSE_CARD_TO_DISCARD.show();

		else
			EAction.CHOOSE_CARD_TO_DISCARD.showAndSelect();

	}

	private void createDiscardableCards() {

		this.list.addAllLast(GetCardsPlayerHasWithEColor.INSTANCE.execute(eColor));

		for (CardPlayer cardPlayer : this.list)
			cardPlayer.setSelected();

	}

}
