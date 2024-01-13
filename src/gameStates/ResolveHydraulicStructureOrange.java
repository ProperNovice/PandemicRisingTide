package gameStates;

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

public class ResolveHydraulicStructureOrange extends GameState {

	private ArrayList<DikeLocation> list = new ArrayList<>();

	@Override
	public void execute() {

		createList();
		handleActions();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {
		proceed();
	}

	@Override
	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

		Actions.INSTANCE.concealActions();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		this.list.remove(dikeLocation);
		BuildDike.INSTANCE.execute(dikeLocation);

		handleActions();

	}

	private void handleActions() {

		if (list.isEmpty() || Dikes.INSTANCE.getList().getArrayList().isEmpty())
			proceed();

		else {

			EAction.BUILD_DIKE.showAndSelect();

			for (DikeLocation dikeLocation : this.list)
				dikeLocation.setSelected();

		}

	}

	private void createList() {

		this.list.addLast(Adjacencies.INSTANCE
				.getAdjecencyBetweenRegions(ERegion.NOORDZEE, ERegion.VOORNE_PUTTEN)
				.getDikeLocation());

		this.list.addLast(Adjacencies.INSTANCE
				.getAdjecencyBetweenRegions(ERegion.NOORDZEE, ERegion.GOERRE_OVERFLAKKEE)
				.getDikeLocation());

		this.list.addLast(Adjacencies.INSTANCE
				.getAdjecencyBetweenRegions(ERegion.NOORDZEE, ERegion.SCHOUWEN_DUIVELAND)
				.getDikeLocation());

		this.list.addLast(Adjacencies.INSTANCE
				.getAdjecencyBetweenRegions(ERegion.NOORDZEE, ERegion.WALCHEREN).getDikeLocation());

		this.list.addLast(Adjacencies.INSTANCE
				.getAdjecencyBetweenRegions(ERegion.NOORDZEE, ERegion.ZEEUWS_VLAANDEREN)
				.getDikeLocation());

	}

	private void proceed() {

		Actions.INSTANCE.concealActions();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		proceedToNextGameState();

	}

}
