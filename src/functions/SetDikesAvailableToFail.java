package functions;

import business.Adjacency;
import business.DikeLocation;
import enums.ERegion;
import model.Adjacencies;
import model.DiscardPileDikeFailure;
import utils.ArrayList;

public enum SetDikesAvailableToFail {

	INSTANCE;

	private boolean dikesAvailableToFail = false;

	public void execute() {

		this.dikesAvailableToFail = false;

		ERegion eRegion = DiscardPileDikeFailure.INSTANCE.getFirstCardERegion();

		ArrayList<Adjacency> list = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion);

		for (Adjacency adjacency : list) {

			DikeLocation dikeLocation = adjacency.getDikeLocation();

			if (dikeLocation == null)
				continue;

			if (dikeLocation.isEmpty())
				continue;

			dikeLocation.selectDike();
			this.dikesAvailableToFail = true;

		}

	}

	public boolean dikesAvailableToFail() {
		return this.dikesAvailableToFail;
	}

}
