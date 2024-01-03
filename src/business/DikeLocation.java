package business;

import controller.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Enums.RelocateTypeEnum;
import utils.Interfaces.ISelectCoordinatesAble;
import utils.ListImageViewAbles;
import utils.Vector2;

public class DikeLocation implements ISelectCoordinatesAble {

	private ListImageViewAbles<Dike> list = new ListImageViewAbles<>();

	public DikeLocation(double x, double y) {

		x += Credentials.INSTANCE.gapBetweenBorders;
		y += Credentials.INSTANCE.gapBetweenBorders;

		this.list.getListCredentials().coordinatesList = new Vector2(x, y);

		this.list.getListCredentials().layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		this.list.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.list.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
		this.list.getListCredentials().showListSize = true;
		this.list.getListCredentials().listQuantityRatioImageViewDimensions = 0.75;

	}

	public void addDikeRelocate(Dike dike) {

		this.list.getArrayList().addLast(dike);
		relocateShowListSize();

	}

	public Dike removeDikeRelocate() {

		Dike dike = this.list.getArrayList().removeLast();
		relocateShowListSize();

		return dike;

	}

	public int dikeSize() {
		return this.list.getArrayList().size();
	}

	private void relocateShowListSize() {

		this.list.getListCredentials().showListSize = this.list.getArrayList().size() >= 2;
		this.list.relocateImageViews();

	}

	@Override
	public Vector2 getCoordinatesCenter() {
		return this.list.getListCredentials().coordinatesList;
	}

}
