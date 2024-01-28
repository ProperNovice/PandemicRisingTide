package functions;

import business.Region;
import business.WaterCube;
import controller.Credentials;
import enums.ERegion;
import model.WaterCubes;

public enum AddWaterToRegion {

	INSTANCE;

	public void execute(ERegion eRegion) {

		Region region = eRegion.getRegion();

		WaterCube waterCube = WaterCubes.INSTANCE.getList().getArrayList().removeFirst();
		waterCube.getImageView().setHeight(Credentials.INSTANCE.hWaterPopulationCubeMap);

		region.getWaterCubes().getArrayList().addLast(waterCube);
		region.relocateComponents();

		if (region.getWaterCubes().getArrayList().size()
				+ region.getPopulations().getArrayList().size() <= 3)
			return;

		PopulationLossFunction.INSTANCE.execute(eRegion);

	}

}
