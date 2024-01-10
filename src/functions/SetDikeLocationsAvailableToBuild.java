package functions;

import business.Adjacency;
import business.DikeLocation;
import enums.ERegion;
import model.Adjacencies;
import utils.ArrayList;

public enum SetDikeLocationsAvailableToBuild {

	INSTANCE;

	public void execute() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		ArrayList<Adjacency> adjacencies = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion);

		for (Adjacency adjacency : adjacencies) {

			DikeLocation dikeLocation = adjacency.getDikeLocation();

			if (dikeLocation == null)
				continue;

			dikeLocation.setSelected();

		}

	}

}
