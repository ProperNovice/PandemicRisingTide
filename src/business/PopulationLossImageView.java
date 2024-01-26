package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;
import utils.Vector2;

public class PopulationLossImageView implements IImageViewAble {

	public PopulationLossImageView() {

		String filePath = "population loss.png";

		new ImageView(filePath, ELayerZ.POPULATION_LOSS, this);
		getImageView().setVisible(false);

		Vector2 coordinates = Credentials.INSTANCE.cPopulationLoss.clone();
		coordinates.addX(Credentials.INSTANCE.gapBetweenBorders);
		coordinates.addY(Credentials.INSTANCE.gapBetweenBorders);

		getImageView().relocateCenter(coordinates);

	}

}
