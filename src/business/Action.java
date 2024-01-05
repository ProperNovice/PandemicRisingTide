package business;

import controller.Credentials;
import enums.EAction;
import utils.Flow;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class Action implements IImageViewAble {

	private EAction eAction = null;

	public Action(EAction eAction) {

		this.eAction = eAction;

		String filePath = "actions/";
		filePath += this.eAction.toString();
		filePath += ".png";

		new ImageView(filePath, this);
		getImageView().setDimensions(Credentials.INSTANCE.dActionIndicator);
		getImageView().setVisible(false);

	}

	@Override
	public void handleMousePressedPrimary() {
		Flow.INSTANCE.getGameStateCurrent().handleActionPressed(this.eAction);
	}

	public EAction getEAction() {
		return this.eAction;
	}

}
