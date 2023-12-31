package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class WaterPump implements IImageViewAble {

	public WaterPump() {

		new ImageView("water pump.png", ELayerZ.TOKENS, this);
		getImageView().setHeight(Credentials.INSTANCE.dWaterPump.y);

	}

}
