package business;

import controller.Credentials;
import enums.ELayerZ;
import enums.ERole;
import utils.Flow;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class Pawn implements IImageViewAble {

	private ERole eRole = null;

	public Pawn(ERole eRole) {

		this.eRole = eRole;

		String fileName = "pawns/";
		fileName += this.eRole.toString();
		fileName += ".png";

		new ImageView(fileName, ELayerZ.MAP_PAWNS, this);
		getImageView().setDimensions(Credentials.INSTANCE.dPawn);
		getImageView().setVisible(false);

	}

	@Override
	public void handleMousePressedPrimary() {
		Flow.INSTANCE.getGameStateCurrent().handlePawnPressed(this);
	}

	public ERole getERole() {
		return this.eRole;
	}

}
