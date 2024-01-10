package functions;

import business.Dike;
import business.DikeLocation;
import model.Dikes;

public enum BuildDike {

	INSTANCE;

	public void execute(DikeLocation dikeLocation) {

		Dike dike = Dikes.INSTANCE.getList().getArrayList().removeFirst();
		dikeLocation.addDikeRelocate(dike);

	}

}
