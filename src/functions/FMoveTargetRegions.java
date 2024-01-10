package functions;

import enums.ERegion;
import utils.ArrayList;

public enum FMoveTargetRegions {

	INSTANCE;

	private ArrayList<ERegion> moveWithoutUsingCard = new ArrayList<>();
	private ArrayList<ERegion> moveUsingCard = new ArrayList<>();
	private ERegion eRegionActivePlayer = null;

	public void execute() {

		setup();
		driveFerry();

	}

	private void setup() {

		// clear lists

		this.moveWithoutUsingCard.clear();
		this.moveUsingCard.clear();

		// set up active player eRegion

		this.eRegionActivePlayer = FGetERegionContainingPawn.INSTANCE
				.getERegionContainingActivePlayerPawn();
		
		System.out.println(this.eRegionActivePlayer);

	}

	private void driveFerry() {

	}

}
