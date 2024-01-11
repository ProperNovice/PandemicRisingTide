package business;

import enums.EColor;
import utils.Vector2;

public class HydraulicStructureLocation {

	private EColor eColor = null;
	private Vector2 vector2 = null;

	public HydraulicStructureLocation(EColor eColor, Vector2 vector2) {

		this.eColor = eColor;
		this.vector2 = vector2;

	}

	public EColor getEColor() {
		return this.eColor;
	}

	public Vector2 getVector2() {
		return this.vector2;
	}

}
