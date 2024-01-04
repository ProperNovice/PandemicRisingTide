package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class WaterCube implements IImageViewAble {

	public WaterCube() {

		new ImageView("water cube - dark.png", ELayerZ.MAP_CUBES, this);
		getImageView().setDimensions(Credentials.INSTANCE.dWaterCube);

	}

}
