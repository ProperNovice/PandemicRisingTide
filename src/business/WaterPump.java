package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.Flow;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class WaterPump implements IImageViewAble {

	public WaterPump() {

		new ImageView("water pump.png", ELayerZ.MAP_BUILDINGS, this);
		getImageView().setHeight(Credentials.INSTANCE.dWaterPump.y);

	}

	@Override
	public void handleMousePressedPrimary() {
		Flow.INSTANCE.getGameStateCurrent().handleWaterPumpPressed(this);
	}

}
