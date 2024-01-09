package functions;

import business.Region;
import business.WaterCube;
import controller.Credentials;
import enums.ERegion;
import model.Regions;
import model.WaterCubes;

public enum FRemoveWaterFromRegion {

	INSTANCE;

	public void execute(ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		WaterCube waterCube = region.getWaterCubes().getArrayList().removeFirst();
		waterCube.getImageView().setDimensions(Credentials.INSTANCE.dWaterCube);

		WaterCubes.INSTANCE.getList().getArrayList().addFirst(waterCube);
		WaterCubes.INSTANCE.getList().relocateImageViews();

	}

}
