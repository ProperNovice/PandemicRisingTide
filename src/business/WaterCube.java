package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.Flow;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class WaterCube implements IImageViewAble {

	public WaterCube() {

		new ImageView("water cube - light.png", ELayerZ.MAP_CUBES, this);
		getImageView().setDimensions(Credentials.INSTANCE.dWaterCube);

	}

	@Override
	public void handleMousePressedPrimary() {
		Flow.INSTANCE.getGameStateCurrent().handleWaterCubePressed(this);
	}

}
