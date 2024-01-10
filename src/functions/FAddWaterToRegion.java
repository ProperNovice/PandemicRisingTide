package functions;

import business.Region;
import business.WaterCube;
import controller.Credentials;
import enums.ERegion;
import model.WaterCubes;

public enum FAddWaterToRegion {

	INSTANCE;

	public void execute(ERegion eRegion) {

		Region region = eRegion.getRegion();

		WaterCube waterCube = WaterCubes.INSTANCE.getList().getArrayList().removeFirst();
		waterCube.getImageView().setHeight(Credentials.INSTANCE.hWaterPopulationCubeMap);

		region.getWaterCubes().getArrayList().addLast(waterCube);

		region.relocateComponents();

	}

}
