package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class Circle implements IImageViewAble {

	public Circle() {

		String filePath = "circles/";
		filePath += getFileName();
		filePath += ".png";

		new ImageView(filePath, ELayerZ.CIRCLES, this);
		getImageView().setDimensions(Credentials.INSTANCE.dCircle);
		getImageView().setVisible(false);

	}

	protected abstract String getFileName();

}
