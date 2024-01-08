package functions;

import business.Region;
import enums.ERegion;
import model.Regions;
import utils.ArrayList;

public enum OperateWaterPump {

	INSTANCE;

	private ArrayList<ERegion> waterPumpsAvailableToOperate = new ArrayList<>();
	private ArrayList<ERegion> waterPumpsAlreadyOperated = new ArrayList<>();

	public void selectWaterPumpsAvailableToOperate() {

		addWaterPumpsToAvailable();
		filterOutRegionsThatDotContainWaterCube();

	}

	private void filterOutRegionsThatDotContainWaterCube() {

	}

	private void addWaterPumpsToAvailable() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = Regions.INSTANCE.getRegion(eRegion);

			if (region.getWaterPumps().getArrayList().isEmpty())
				continue;

			if (this.waterPumpsAlreadyOperated.contains(eRegion))
				continue;

			this.waterPumpsAvailableToOperate.addLast(eRegion);

		}

	}

}
