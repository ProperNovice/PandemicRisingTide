package functions;

import enums.EColor;
import enums.ERegion;
import model.HydraulicStructures;

public enum BuildHydraulicStructure {

	INSTANCE;

	public void execute() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();
		EColor eColor = eRegion.getRegion().getEColor();

		HydraulicStructures.INSTANCE.buildHydraulicStructureMap(eColor);

	}

}
