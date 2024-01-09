package functions;

import business.Adjacency;
import business.DikeLocation;
import enums.ERegion;
import model.Adjacencies;
import model.DiscardPileDikeFailure;
import utils.ArrayList;

public enum FSetDikesAvailableToFail {

	INSTANCE;

	private ArrayList<DikeLocation> dikeLocations = new ArrayList<>();

	public void selectDikesAvailableToFail() {
		execute(true);
	}

	public int sizeDikesAvailableToFail() {
		return execute(false);
	}

	private int execute(boolean select) {

		this.dikeLocations.clear();
		int size = 0;

		ERegion eRegion = DiscardPileDikeFailure.INSTANCE.getFirstCardERegion();

		ArrayList<Adjacency> list = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion);

		for (Adjacency adjacency : list) {

			DikeLocation dikeLocation = adjacency.getDikeLocation();

			if (dikeLocation == null)
				continue;

			if (dikeLocation.isEmpty())
				continue;

			if (select)
				dikeLocation.setSelected();

			size += dikeLocation.size();

		}

		return size;

	}

}
