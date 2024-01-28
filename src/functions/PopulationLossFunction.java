package functions;

import business.PopulationCube;
import business.Region;
import enums.ERegion;
import model.PopulationLoss;

public enum PopulationLossFunction {

	INSTANCE;

	public void execute(ERegion eRegion) {

		Region region = eRegion.getRegion();
		PopulationCube populationCube = region.getPopulations().getArrayList().removeFirst();
		region.relocateComponents();

		PopulationLoss.INSTANCE.getList().getArrayList().addLast(populationCube);
		PopulationLoss.INSTANCE.getList().relocateImageViews();

	}

}
