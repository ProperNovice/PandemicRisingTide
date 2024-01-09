package functions;

import business.Dike;
import business.DikeLocation;
import model.Dikes;

public enum FRemoveDike {

	INSTANCE;

	public void execute(DikeLocation dikeLocation) {

		Dike dike = dikeLocation.removeDikeRelocate();
		Dikes.INSTANCE.getList().getArrayList().addFirst(dike);
		Dikes.INSTANCE.getList().relocateImageViews();

	}

}
