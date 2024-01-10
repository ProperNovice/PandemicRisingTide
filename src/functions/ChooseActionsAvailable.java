package functions;

import business.Region;
import enums.EAction;
import enums.ERegion;
import model.Dikes;

public enum ChooseActionsAvailable {

	INSTANCE;

	public void execute() {

		move();
		pumpWater();
		buildDike();

	}

	private void buildDike() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		Region region = eRegion.getRegion();

		if (!region.getWaterCubes().getArrayList().isEmpty())
			return;

		if (Dikes.INSTANCE.getList().getArrayList().isEmpty())
			return;

		EAction.BUILD_DIKE.showAndSelect();

	}

	private void move() {
		EAction.MOVE.showAndSelect();
	}

	private void pumpWater() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		Region region = eRegion.getRegion();

		if (region.getWaterCubes().getArrayList().isEmpty())
			return;

		EAction.PUMP_WATER.showAndSelect();

	}

}
