package resolveEvents;

import business.Adjacency;
import business.DikeLocation;
import business.Region;
import enums.EAction;
import enums.ERegion;
import functions.BuildDike;
import functions.GetERegionContainingPlayerPawn;
import gameStatesDefault.GameState;
import model.Actions;
import model.Adjacencies;
import model.Dikes;
import utils.ArrayList;

public class ResolveEventTweeGebroedersPlugsBreach extends GameState {

	private ArrayList<DikeLocation> list = new ArrayList<>();

	@Override
	public void execute() {

		EAction.RESOLVE_EVENT.show();

		ERegion eRegionActive = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();
		ERegion eRegionPassive = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnPassive();

		if (eRegionActive.equals(eRegionPassive))
			setUpDikeLocations(eRegionActive);

		else {

			eRegionActive.getRegion().setSelected();
			eRegionPassive.getRegion().setSelected();

		}

	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		BuildDike.INSTANCE.execute(dikeLocation);
		this.list.remove(dikeLocation);

		if (!this.list.isEmpty() && !Dikes.INSTANCE.getList().getArrayList().isEmpty())
			selectDikeLocations();
		else
			proceed();

	}

	@Override
	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {
		setUpDikeLocations(eRegion);
	}

	private void setUpDikeLocations(ERegion eRegion) {

		ArrayList<Adjacency> list = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion);

		for (Adjacency adjacency : list)
			if (adjacency.getDikeLocation() != null)
				this.list.addLast(adjacency.getDikeLocation());

		selectDikeLocations();

	}

	private void selectDikeLocations() {

		if (this.list.size() <= Dikes.INSTANCE.getList().getArrayList().size())
			handleDikeLocationSelectedPressed(this.list.getFirst());

		else
			for (DikeLocation dikeLocation : this.list)
				dikeLocation.setSelected();

	}

	private void proceed() {
		Actions.INSTANCE.concealActions();
		proceedToNextGameState();
	}

}
