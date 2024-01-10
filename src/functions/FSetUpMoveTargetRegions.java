package functions;

import business.Region;
import enums.ERegion;
import model.Adjacencies;
import model.Regions;
import utils.ArrayList;

public enum FSetUpMoveTargetRegions {

	INSTANCE;

	private ArrayList<ERegion> free = new ArrayList<>();
	private ArrayList<ERegion> usingCard = new ArrayList<>();
	private ERegion eRegionPlayer = null;

	public void execute() {

		setup();
		driveFerry();
		returnToPort();
		sail();

		selectRegions();

	}

	private void sail() {

	}

	private void returnToPort() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = Regions.INSTANCE.getRegion(eRegion);

		}

	}

	private void selectRegions() {

		for (ERegion eRegion : this.free)
			Regions.INSTANCE.getRegion(eRegion).setSelected();

		for (ERegion eRegion : this.usingCard)
			Regions.INSTANCE.getRegion(eRegion).setSelected();

	}

	private void driveFerry() {

		ArrayList<ERegion> list = Adjacencies.INSTANCE.getAdjacentERegions(this.eRegionPlayer);

		for (ERegion eRegion : list) {

			Region region = Regions.INSTANCE.getRegion(eRegion);

			if (region.isSea())
				continue;

			addERegion(eRegion, this.free);

		}

	}

	private void addERegion(ERegion eRegion, ArrayList<ERegion> list) {

		if (this.free.contains(eRegion) || this.usingCard.contains(eRegion))
			return;

		list.addLast(eRegion);

	}

	private void setup() {

		// clear lists

		this.free.clear();
		this.usingCard.clear();

		// set up active player eRegion

		this.eRegionPlayer = FGetERegionContainingPawn.INSTANCE
				.getERegionContainingActivePlayerPawn();

	}

}
