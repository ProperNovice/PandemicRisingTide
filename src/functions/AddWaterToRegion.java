package functions;

import business.Region;
import business.WaterCube;
import controller.Credentials;
import enums.ERegion;
import model.Regions;
import model.WaterCubes;

public enum AddWaterToRegion {

	INSTANCE;

	private boolean floodTriggered = false;

	public void execute(ERegion eRegion, int amount) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		while (!region.getWaterCubes().getArrayList().isMaxCapacity() && amount > 0) {

			amount--;

			WaterCube waterCube = WaterCubes.INSTANCE.getList().getArrayList().removeFirst();
			waterCube.getImageView().setHeight(Credentials.INSTANCE.hWaterPopulationCubeMap);

			region.getWaterCubes().getArrayList().addLast(waterCube);

		}

		region.relocateComponents();

		this.floodTriggered = amount > 0;

	}

	public boolean floodIsTriggered() {
		return this.floodTriggered;
	}

}
