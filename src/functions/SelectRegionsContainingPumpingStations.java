package functions;

import business.Region;
import enums.ERegion;

public enum SelectRegionsContainingPumpingStations {

	INSTANCE;

	public void execute() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.getPumpingStation().getArrayList().isEmpty())
				continue;

			region.setSelected();

		}

	}

}
