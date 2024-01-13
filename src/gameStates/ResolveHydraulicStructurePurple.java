package gameStates;

import business.Region;
import enums.ERegion;
import functions.RemoveWaterFromRegion;
import gameStatesDefault.GameState;

public class ResolveHydraulicStructurePurple extends GameState {

	@Override
	public void execute() {

		Region region = ERegion.ZUIDERZEE.getRegion();
		region.setIsSea(false);

		if (region.getWaterCubes().getArrayList().size() == 4)
			RemoveWaterFromRegion.INSTANCE.execute(ERegion.ZUIDERZEE);
		
		proceedToNextGameState();

	}

}
