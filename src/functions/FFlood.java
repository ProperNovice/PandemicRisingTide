package functions;

import business.Adjacency;
import business.DikeLocation;
import business.Region;
import enums.ERegion;
import model.Adjacencies;
import utils.ArrayList;

public enum FFlood {

	INSTANCE;

	private ERegion eRegionToFlood = null;
	private ArrayList<ERegion> eRegionsFloodedThisTurn = new ArrayList<>();
	private ArrayList<ERegion> eRegionsToFloodNow = new ArrayList<>();
	private ArrayList<ERegion> eRegionsToFloodNext = new ArrayList<>();

	public void execute(ERegion eRegion) {

		setUp(eRegion);
		addAdjacentRegionsToList();
		filterOutSeasAndHighElevationRegions();
		filterOutRegionsThatHaveDike();

		addWaterCubesToRegions();
		executeConsecutiveFlood();

	}

	private void executeConsecutiveFlood() {

		if (this.eRegionsToFloodNext.isEmpty())
			return;

		execute(this.eRegionsToFloodNext.removeFirst());

	}

	private void addWaterCubesToRegions() {

		for (ERegion eRegion : this.eRegionsToFloodNow) {

			Region region = eRegion.getRegion();

			if (!region.getWaterCubes().getArrayList().isMaxCapacity())
				FAddWaterToRegion.INSTANCE.execute(eRegion);

			else if (!this.eRegionsFloodedThisTurn.contains(eRegion))
				if (!this.eRegionsToFloodNext.contains(eRegion))
					this.eRegionsToFloodNext.addLast(eRegion);

		}

	}

	private void filterOutRegionsThatHaveDike() {

		for (ERegion eRegion : this.eRegionsToFloodNow.clone()) {

			Adjacency adjacency = Adjacencies.INSTANCE.getAdjecencyBetweenRegions(eRegion,
					this.eRegionToFlood);

			DikeLocation dikeLocation = adjacency.getDikeLocation();

			if (dikeLocation.isEmpty())
				continue;

			this.eRegionsToFloodNow.remove(eRegion);

		}

	}

	private void filterOutSeasAndHighElevationRegions() {

		for (ERegion eRegion : this.eRegionsToFloodNow.clone()) {

			Region region = eRegion.getRegion();

			if (region.isHighElevated())
				this.eRegionsToFloodNow.remove(eRegion);

			else if (region.isSea())
				this.eRegionsToFloodNow.remove(eRegion);

		}

	}

	private void addAdjacentRegionsToList() {

		this.eRegionsToFloodNow
				.addAllLast(Adjacencies.INSTANCE.getAdjacentERegions(this.eRegionToFlood));

	}

	private void setUp(ERegion eRegion) {

		this.eRegionToFlood = eRegion;
		this.eRegionsFloodedThisTurn.addLast(eRegion);
		this.eRegionsToFloodNow.clear();

	}

	public boolean regionCanFlood(ERegion eRegion) {
		return this.eRegionsFloodedThisTurn.contains(eRegion);
	}

	public void clearList() {
		this.eRegionsFloodedThisTurn.clear();
	}

}
