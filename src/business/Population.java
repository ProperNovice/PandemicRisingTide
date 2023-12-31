package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class Population implements IImageViewAble {

	public Population() {

		new ImageView("population.png", ELayerZ.TOKENS, this);
		getImageView().setDimensions(Credentials.INSTANCE.dPopulation);

	}

}
