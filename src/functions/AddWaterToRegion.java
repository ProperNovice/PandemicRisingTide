package functions;

import business.Region;
import business.WaterCube;
import controller.Credentials;
import enums.ERegion;
import model.Regions;
import model.WaterCubes;

public enum AddWaterToRegion {

	INSTANCE;

	public void execute(ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		WaterCube waterCube = WaterCubes.INSTANCE.getList().getArrayList().removeFirst();
		waterCube.getImageView().setHeight(Credentials.INSTANCE.hWaterPopulationCubeMap);

		region.getWaterCubes().getArrayList().addLast(waterCube);

		region.relocateComponents();

	}

}
