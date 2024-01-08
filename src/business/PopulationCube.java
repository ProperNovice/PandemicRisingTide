package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.Flow;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class PopulationCube implements IImageViewAble {

	public PopulationCube() {

		new ImageView("population.png", ELayerZ.MAP_CUBES, this);
		getImageView().setDimensions(Credentials.INSTANCE.dPopulation);

	}

	@Override
	public void handleMousePressedPrimary() {
		Flow.INSTANCE.getGameStateCurrent().handlePopulationCubePressed(this);
	}

}
