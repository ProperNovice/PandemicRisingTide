package business;

import enums.ERole;
import utils.Interfaces.IImageViewAble;

public class Pawn implements IImageViewAble {

	private ERole eRole = null;

	public Pawn(ERole eRole) {

		this.eRole = eRole;

	}

	public ERole getERole() {
		return this.eRole;
	}

}
