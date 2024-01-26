package functions;

import business.PopulationCube;
import business.Region;
import controller.Credentials;
import enums.ERegion;
import model.Populations;

public enum ExpandPopulationToERegion {

	INSTANCE;

	public void execute(ERegion eRegion) {

		Region region = eRegion.getRegion();

		PopulationCube populationCube = Populations.INSTANCE.getList().getArrayList().removeFirst();
		populationCube.getImageView().setHeight(Credentials.INSTANCE.hWaterPopulationCubeMap);

		region.getPopulations().getArrayList().addLast(populationCube);
		region.relocateComponents();

	}

}
