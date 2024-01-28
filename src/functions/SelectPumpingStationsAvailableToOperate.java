package functions;

import business.Region;
import enums.ERegion;
import utils.ArrayList;

public enum SelectPumpingStationsAvailableToOperate {

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
		this.waterPumpsAlreadyOperated.clear();
	}

	public void setWaterPumpAlreadyOperated(ERegion eRegion) {
		this.waterPumpsAlreadyOperated.addLast(eRegion);
	}

	private void selectERegionsAvailableToOperate() {

		for (ERegion eRegion : this.waterPumpsAvailableToOperate) {

			Region region = eRegion.getRegion();
			region.setSelected();

		}

	}

	private void filterOutRegionsThatDontContainWaterCube() {

		for (ERegion eRegion : this.waterPumpsAvailableToOperate.clone()) {

			Region region = eRegion.getRegion();

			if (!region.getWaterCubes().getArrayList().isEmpty())
				continue;

			this.waterPumpsAvailableToOperate.remove(eRegion);

		}

	}

	private void addWaterPumpsRegionsToAvailable() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.getPumpingStation().getArrayList().isEmpty())
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
