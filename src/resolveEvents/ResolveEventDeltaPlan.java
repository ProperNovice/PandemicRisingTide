package resolveEvents;

import business.Adjacency;
import business.DikeLocation;
import enums.EAction;
import enums.ERegion;
import functions.BuildDike;
import gameStatesDefault.GameState;
import model.Actions;
import model.Adjacencies;
import model.Dikes;
import utils.ArrayList;
import utils.SelectImageViewManager;

public class ResolveEventDeltaPlan extends GameState {

	private int dikesToBuild = 3;

	@Override
	public void execute() {

		this.dikesToBuild = Math.min(3, Dikes.INSTANCE.getList().getArrayList().size());
		handleAction();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {
		proceed();
	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		Actions.INSTANCE.concealActions();
		BuildDike.INSTANCE.execute(dikeLocation);

		this.dikesToBuild--;

		if (this.dikesToBuild == 0)
			proceed();
		else
			handleAction();

	}

	private void handleAction() {

		Actions.INSTANCE.concealActions();
		EAction.RESOLVE_EVENT.showAndSelect();

		setDikeLocations();

	}

	private void setDikeLocations() {

		for (ERegion eRegion : ERegion.values()) {

			ArrayList<Adjacency> list = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion);

			for (Adjacency adjacency : list) {

				DikeLocation dikeLocation = adjacency.getDikeLocation();

				if (dikeLocation == null)
					continue;

				if (dikeLocation.isSelected())
					continue;

				dikeLocation.setSelected();

			}

		}

	}

	private void proceed() {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		proceedToNextGameState();

	}

}
