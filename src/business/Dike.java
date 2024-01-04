package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class Dike implements IImageViewAble {

	public Dike() {

		new ImageView("dike.png", ELayerZ.MAP_BUILDINGS, this);
		getImageView().setDimensions(Credentials.INSTANCE.dDike);

	}

}
