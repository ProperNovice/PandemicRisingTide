package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class SeaLevelMarker implements IImageViewAble {

	public SeaLevelMarker() {

		new ImageView("sea level marker blue.png", ELayerZ.SEA_LEVEL_MARKER, this);
		getImageView().setHeight(Credentials.INSTANCE.hSeaLevelMarker);

	}

}
