package business;

import controller.Credentials;
import enums.EColor;
import enums.ERegion;
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

		relocatePopulationWaterCubes();
		relocatePortsWaterPumps();

		// show list size

		this.populations.getListCredentials().showListSize = this.populations.getArrayList()
				.size() >= 2;

		this.waterCubes.getListCredentials().showListSize = this.waterCubes.getArrayList()
				.size() >= 2;

		// relocate image views

		this.populations.relocateImageViews();
		this.waterCubes.relocateImageViews();
		this.waterPumps.relocateImageViews();
		this.ports.relocateImageViews();
		this.pawns.relocateImageViews();

	}

	private void relocatePortsWaterPumps() {

		double totalX = 0, totalGaps = -1, x;

		if (!this.ports.getArrayList().isEmpty()) {

			totalGaps++;
			totalX += this.ports.getArrayList().getFirst().getImageView().getWidth();

		}

		if (!this.waterPumps.getArrayList().isEmpty()) {

			totalGaps++;
			totalX += this.waterPumps.getArrayList().getFirst().getImageView().getWidth();

		}

		totalX += totalGaps * Credentials.INSTANCE.dGapBetweenComponents.x;

		x = this.coordinates.x;
		x -= totalX / 2;

		if (!this.ports.getArrayList().isEmpty()) {

			x += this.ports.getArrayList().getFirst().getImageView().getWidth() / 2;
			this.ports.getListCredentials().coordinatesList.x = x;

			x += this.ports.getArrayList().getFirst().getImageView().getWidth() / 2;
			x += Credentials.INSTANCE.dGapBetweenComponents.x;

		}

		if (!this.waterPumps.getArrayList().isEmpty()) {

			x += this.waterPumps.getArrayList().getFirst().getImageView().getWidth() / 2;
			this.waterPumps.getListCredentials().coordinatesList.x = x;

			x += this.waterPumps.getArrayList().getFirst().getImageView().getWidth() / 2;
			x += Credentials.INSTANCE.dGapBetweenComponents.x;

		}

	}

	private void relocatePopulationWaterCubes() {

		double totalX = 0, totalGaps = -1, x;

		if (!this.populations.getArrayList().isEmpty()) {

			totalGaps++;
			totalX += this.populations.getArrayList().getFirst().getImageView().getWidth();

		}

		if (!this.waterCubes.getArrayList().isEmpty()) {

			totalGaps++;
			totalX += this.waterCubes.getArrayList().getFirst().getImageView().getWidth();

		}

		totalX += totalGaps * Credentials.INSTANCE.dGapBetweenComponents.x;

		x = this.coordinates.x;
		x -= totalX / 2;

		if (!this.populations.getArrayList().isEmpty()) {

			x += this.populations.getArrayList().getFirst().getImageView().getWidth() / 2;
			this.populations.getListCredentials().coordinatesList.x = x;

			x += this.populations.getArrayList().getFirst().getImageView().getWidth() / 2;
			x += Credentials.INSTANCE.dGapBetweenComponents.x;

		}

		if (!this.waterCubes.getArrayList().isEmpty()) {

			x += this.waterCubes.getArrayList().getFirst().getImageView().getWidth() / 2;
			this.waterCubes.getListCredentials().coordinatesList.x = x;

			x += this.waterCubes.getArrayList().getFirst().getImageView().getWidth() / 2;
			x += Credentials.INSTANCE.dGapBetweenComponents.x;

		}

	}

	private void createLists() {

		this.waterCubes = new ListImageViewAbles<>();

		// populations

		this.populations.getListCredentials().coordinatesList.y = this.coordinates.y;
		this.populations.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.populations.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.populations.getListCredentials().listQuantityRatioImageViewDimensions = 0.75;

		// water cubes

		this.waterCubes.getListCredentials().coordinatesList.y = this.coordinates.y;
		this.waterCubes.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.waterCubes.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.waterCubes.getListCredentials().listQuantityRatioImageViewDimensions = 1;

		// water pumps

		this.waterPumps.getListCredentials().coordinatesList.y = this.coordinates.y;
		this.waterPumps.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;

		// ports

		this.ports.getListCredentials().coordinatesList.y = this.coordinates.y;
		this.ports.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;

		// pawns

		this.pawns.getListCredentials().coordinatesList = this.coordinates;
		this.pawns.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.pawns.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.PIVOT;

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
