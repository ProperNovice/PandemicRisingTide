package business;

import controller.Credentials;
import enums.EColor;
import enums.ERegion;
import utils.Interfaces.ISelectCoordinatesAble;
import utils.Logger;
import utils.Vector2;

public class Region implements ISelectCoordinatesAble {

	private ERegion eRegion = null;
	private EColor eColor = null;
	private Vector2 coordinates = null;
	private boolean isSea = false, isHighElevated = false, canBuildHydraulicStructure = false;

	public Region(ERegion eRegion, double x, double y) {
		this(eRegion, x, y, null);
	}

	public Region(ERegion eRegion, double x, double y, EColor eColor) {

		this.eRegion = eRegion;
		this.eColor = eColor;

		x += Credentials.INSTANCE.gapBetweenBorders;
		y += Credentials.INSTANCE.gapBetweenBorders;

		this.coordinates = new Vector2(x, y);

	}

	public void setIsSea(boolean value) {
		this.isSea = value;
	}

	public void setIsHighElevated() {
		this.isHighElevated = true;
	}

	public void setCanBuildHydraulicStructure() {
		this.canBuildHydraulicStructure = true;
	}

	public void print() {

		Logger.INSTANCE.log("printing region");
		Logger.INSTANCE.log(this.eRegion);

		if (this.isSea)
			Logger.INSTANCE.log("is sea");

		if (this.eColor != null)
			Logger.INSTANCE.log(this.eColor);

		if (this.isHighElevated)
			Logger.INSTANCE.log("is high elevated");

		Logger.INSTANCE.newLine();

	}

	public ERegion getERegion() {
		return this.eRegion;
	}

	public EColor getEColor() {
		return this.eColor;
	}

	@Override
	public Vector2 getCoordinatesCenter() {
		return this.coordinates;
	}

	public boolean isSea() {
		return this.isSea;
	}

	public boolean isHighElevated() {
		return this.isHighElevated;
	}

	public boolean canBuildHydraulicStructure() {
		return this.canBuildHydraulicStructure;
	}

}
