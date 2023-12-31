package functions;

import business.Region;
import enums.ERegion;
import model.Regions;
import utils.ArrayList;

public enum FSelectWaterPumpsAvailableToOperate {

	INSTANCE;

	private ArrayList<ERegion> waterPumpsAvailableToOperate = new ArrayList<>();
	private ArrayList<ERegion> waterPumpsAlreadyOperated = new ArrayList<>();

	public void execute() {

		clearWaterPumpsAvailableToOperate();
		addWaterPumpsRegionsToAvailable();
		filterOutRegionsThatDontContainWaterCube();
		selectERegionsAvailableToOperate();

	}

	public boolean isAvailableWaterPumpToOperate() {
		return !this.waterPumpsAvailableToOperate.isEmpty();
	}

	public void startNewTurn() {
		this.waterPumpsAvailableToOperate.clear();
	}

	public void setWaterPumpAlreadyOperated(ERegion eRegion) {
		this.waterPumpsAlreadyOperated.addLast(eRegion);
	}

	private void selectERegionsAvailableToOperate() {

		for (ERegion eRegion : this.waterPumpsAvailableToOperate) {

			Region region = Regions.INSTANCE.getRegion(eRegion);
			region.setSelected();

		}

	}

	private void filterOutRegionsThatDontContainWaterCube() {

		for (ERegion eRegion : this.waterPumpsAvailableToOperate.clone()) {

			Region region = Regions.INSTANCE.getRegion(eRegion);

			if (!region.getWaterCubes().getArrayList().isEmpty())
				continue;

			this.waterPumpsAvailableToOperate.remove(eRegion);

		}

	}

	private void addWaterPumpsRegionsToAvailable() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = Regions.INSTANCE.getRegion(eRegion);

			if (region.getWaterPumps().getArrayList().isEmpty())
				continue;

			if (this.waterPumpsAlreadyOperated.contains(eRegion))
				continue;

			this.waterPumpsAvailableToOperate.addLast(eRegion);

		}

	}

	private void clearWaterPumpsAvailableToOperate() {
		this.waterPumpsAvailableToOperate.clear();
	}

}
