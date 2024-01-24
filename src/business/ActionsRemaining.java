package business;

import controller.Credentials;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class ActionsRemaining implements IImageViewAble {

	public ActionsRemaining() {

		new ImageView("actionRemaining.png", this);
		getImageView().setDimensions(Credentials.INSTANCE.dActionsRemaining);
		getImageView().setVisible(false);

	}

}
