package functions;

import business.Region;
import enums.ERegion;

public enum SelectRegionsContainingPorts {

	INSTANCE;

	public void execute() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.getPorts().getArrayList().isEmpty())
				continue;

			region.setSelected();

		}

	}

}
