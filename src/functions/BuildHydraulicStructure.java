package functions;

import model.HydraulicStructures;

public enum BuildHydraulicStructure {

	INSTANCE;

	public void execute() {

		HydraulicStructures.INSTANCE
				.buildHydraulicStructureMap(GetERegionContainingPlayerPawn.INSTANCE
						.getERegionContainingPlayerPawnActive().getRegion().getEColor());

	}

}
