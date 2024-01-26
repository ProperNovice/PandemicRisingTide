package business;

import controller.Credentials;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;
import utils.Interfaces.IMouseEventAble;

public class ObjectiveSelect implements IImageViewAble, IMouseEventAble {

	public ObjectiveSelect() {

		new ImageView("misc/select.png", ELayerZ.SELECT_IMAGEVIEW, this);
		this.getImageView().setVisible(false);
		this.getImageView().setDimensions(Credentials.INSTANCE.dObjectiveSelect);

	}

}
