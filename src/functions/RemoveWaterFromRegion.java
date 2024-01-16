package functions;

import business.Region;
import business.WaterCube;
import controller.Credentials;
import enums.ERegion;
import model.WaterCubes;

public enum RemoveWaterFromRegion {

	INSTANCE;

	public void execute(ERegion eRegion) {
		execute(eRegion.getRegion());
	}

	public void execute(Region region) {

		WaterCube waterCube = region.getWaterCubes().getArrayList().removeFirst();
		waterCube.getImageView().setDimensions(Credentials.INSTANCE.dWaterCube);

		region.relocateComponents();

		WaterCubes.INSTANCE.getList().getArrayList().addFirst(waterCube);
		WaterCubes.INSTANCE.getList().relocateImageViews();

	}

}
