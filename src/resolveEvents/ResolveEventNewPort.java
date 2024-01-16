package resolveEvents;

import business.Adjacency;
import business.DikeLocation;
import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.BuildDike;
import functions.BuildPort;
import gameStatesDefault.GameState;
import model.Actions;
import model.Adjacencies;
import model.Dikes;
import model.Ports;

public class ResolveEventNewPort extends GameState {

	@Override
	public void execute() {

		EAction.RESOLVE_EVENT.show();
		setUpRegions();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

		handlePort(eRegion);
		handleDikeLocation(eRegion);

	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		BuildDike.INSTANCE.execute(dikeLocation);
		proceed();

	}

	private void handleDikeLocation(ERegion eRegion) {

		if (Dikes.INSTANCE.getList().getArrayList().isEmpty()) {
			proceed();
			return;
		}

		for (Adjacency adjacency : Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion)) {

			DikeLocation dikeLocation = adjacency.getDikeLocation();

			if (dikeLocation == null)
				continue;

			dikeLocation.setSelected();

		}

	}

	private void handlePort(ERegion eRegion) {

		if (Ports.INSTANCE.getList().getArrayList().isEmpty())
			return;

		if (!eRegion.getRegion().getPort().getArrayList().isEmpty())
			return;

		BuildPort.INSTANCE.executeFromReserve(eRegion);

	}

	private void setUpRegions() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			if (region.isHighElevated())
				continue;

			region.setSelected();

		}

	}

	private void proceed() {

		Actions.INSTANCE.concealActions();
		proceedToNextGameState();

	}

}
