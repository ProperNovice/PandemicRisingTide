package business;

import controller.Credentials;
import enums.ELayerZ;
import enums.ERole;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class Pawn implements IImageViewAble {

	private ERole eRole = null;

	public Pawn(ERole eRole) {

		this.eRole = eRole;

		String fileName = "pawns/";
		fileName += this.eRole.getPawnFileName();
		fileName += ".png";

		new ImageView(fileName, ELayerZ.TOKENS, this);
		getImageView().setDimensions(Credentials.INSTANCE.dPawn);
		getImageView().setVisible(false);

	}

	public ERole getERole() {
		return this.eRole;
	}

}
