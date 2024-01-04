package actions;

import business.Region;
import business.WaterCube;
import enums.ERegion;
import model.Regions;
import model.WaterCubes;

public enum AddWaterToRegion {

	INSTANCE;

	private AddWaterToRegion() {

	}

	public void execute(ERegion eRegion, int amount) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		for (int counter = 1; counter <= amount; counter++) {

			WaterCube waterCube = WaterCubes.INSTANCE.getList().getArrayList().removeFirst();
			region.getWaterCubes().getArrayList().addLast(waterCube);

		}

		region.relocateComponents();

	}

}
