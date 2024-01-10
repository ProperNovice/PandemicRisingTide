package functions;

import business.Region;
import business.WaterCube;
import controller.Credentials;
import enums.ERegion;
import model.WaterCubes;

public enum FRemoveWaterFromRegion {

	INSTANCE;

	public void execute(ERegion eRegion) {

		Region region = eRegion.getRegion();

		WaterCube waterCube = region.getWaterCubes().getArrayList().removeFirst();
		waterCube.getImageView().setDimensions(Credentials.INSTANCE.dWaterCube);

		region.relocateComponents();

		WaterCubes.INSTANCE.getList().getArrayList().addFirst(waterCube);
		WaterCubes.INSTANCE.getList().relocateImageViews();

	}

}
