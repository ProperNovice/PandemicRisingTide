package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class Port implements IImageViewAble {

	public Port() {

		new ImageView("port.png", ELayerZ.MAP_TOKENS, this);
		getImageView().setHeight(Credentials.INSTANCE.dPort.y);

	}

}
