package functions;

import business.Region;
import enums.ERegion;
import utils.ArrayList;

public enum GetRegionsContainingAtLeastOneWaterCube {

	INSTANCE;

	public ArrayList<Region> execute() {

		ArrayList<Region> list = new ArrayList<>();

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			if (region.getWaterCubes().getArrayList().isEmpty())
				continue;

			list.addLast(region);

		}

		return list;

	}

}
