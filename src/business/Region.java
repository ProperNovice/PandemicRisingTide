package business;

import controller.Credentials;
import enums.EColor;
import enums.ERegion;
import utils.Enums.DirectionEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.Interfaces.ISelectCoordinatesAble;
import utils.ListImageViewAbles;
import utils.Logger;
import utils.Vector2;

public class Region implements ISelectCoordinatesAble {

	private ERegion eRegion = null;
	private EColor eColor = null;
	private Vector2 coordinates = null;
	private boolean isSea = false, isHighElevated = false, canBuildHydraulicStructure = false;
	private ListImageViewAbles<Population> populations = new ListImageViewAbles<>();
	private ListImageViewAbles<WaterCube> waterCubes = new ListImageViewAbles<>();
	private ListImageViewAbles<WaterPump> waterPumps = new ListImageViewAbles<>();
	private ListImageViewAbles<Port> ports = new ListImageViewAbles<>();
	private ListImageViewAbles<Pawn> pawns = new ListImageViewAbles<>();

	public Region(ERegion eRegion, double x, double y) {
		this(eRegion, x, y, null);
	}

	public Region(ERegion eRegion, double x, double y, EColor eColor) {

		this.eRegion = eRegion;
		this.eColor = eColor;

		x += Credentials.INSTANCE.gapBetweenBorders;
		y += Credentials.INSTANCE.gapBetweenBorders;

		this.coordinates = new Vector2(x, y);

		createLists();

	}

	public void relocateComponents() {

		double totalX = 0, totalGap = -1;

		totalX += Credentials.INSTANCE.dPopulation.x * this.populations.getArrayList().size();
		totalX += Credentials.INSTANCE.dWaterCube.x * this.populations.getArrayList().size();
		totalX += Credentials.INSTANCE.dWaterPump.x * this.populations.getArrayList().size();
		totalX += Credentials.INSTANCE.dPort.x * this.populations.getArrayList().size();
		totalX += Credentials.INSTANCE.dPawn.x * this.populations.getArrayList().size();

		totalGap += this.populations.getArrayList().size();
		totalGap += this.waterCubes.getArrayList().size();
		totalGap += this.waterPumps.getArrayList().size();
		totalGap += this.ports.getArrayList().size();
		totalGap += this.pawns.getArrayList().size();

		// relocate image views

		this.populations.relocateImageViews();
		this.waterCubes.relocateImageViews();
		this.waterPumps.relocateImageViews();
		this.ports.relocateImageViews();
		this.pawns.relocateImageViews();

	}

	private void createLists() {

		this.waterCubes = new ListImageViewAbles<>();

		// populations

		this.populations.getListCredentials().coordinatesList.y = this.coordinates.y;
		this.populations.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.populations.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;

		// water cubes

		this.waterCubes.getListCredentials().coordinatesList.y = this.coordinates.y;
		this.waterCubes.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.waterCubes.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;

		// water pumps

		this.waterPumps.getListCredentials().coordinatesList.y = this.coordinates.y;
		this.waterPumps.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;

		// ports

		this.ports.getListCredentials().coordinatesList.y = this.coordinates.y;
		this.ports.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;

		// pawns

		this.pawns.getListCredentials().coordinatesList.y = this.coordinates.y;
		this.pawns.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.pawns.getListCredentials().directionEnumHorizontal = DirectionEnum.LEFT;

	}

	public ListImageViewAbles<Population> getPopulations() {
		return this.populations;
	}

	public ListImageViewAbles<WaterCube> getWaterCubes() {
		return this.waterCubes;
	}

	public ListImageViewAbles<WaterPump> getWaterPumps() {
		return this.waterPumps;
	}

	public ListImageViewAbles<Port> getPorts() {
		return this.ports;
	}

	public ListImageViewAbles<Pawn> getPawns() {
		return this.pawns;
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
