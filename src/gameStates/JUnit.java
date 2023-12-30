package gameStates;

import business.Region;
import enums.ERegion;
import gameStatesDefault.GameState;
import model.Adjacencies;
import model.Regions;
import utils.ArrayList;
import utils.CameraView;

public class JUnit extends GameState {

	@Override
	public void execute() {

//		handleKeyPressed(KeyCode.M);

		CameraView.INSTANCE.setCameraViewingSpot(1);
		
		testAdjacentRegions(ERegion.WIERINGERMEER);

	}

	public void testAdjacentRegions(ERegion eRegion) {

		ArrayList<ERegion> eRegions = Adjacencies.INSTANCE.getAdjacentERegions(eRegion);

		ArrayList<Region> regions = new ArrayList<>();

		for (ERegion eRegionTemp : eRegions)
			regions.addLast(Regions.INSTANCE.getRegion(eRegionTemp));

		for (Region region : regions)
			region.setSelected();

	}

}
