package functions;

import business.Adjacency;
import business.DikeLocation;
import business.PopulationCube;
import business.Port;
import business.PumpingStation;
import business.Region;
import enums.ERegion;
import model.Actions;
import model.Adjacencies;
import model.PopulationLoss;
import model.Populations;
import model.Ports;
import model.PumpingStations;

public enum ComponentsWrapUp {

	INSTANCE;

	public void execute() {

		waterCubes();
		dikes();
		pumpingStations();
		ports();
		populationCubes();
		drawnCircles();
		actions();
		cards();

	}

	private void cards() {

	}

	private void actions() {
		Actions.INSTANCE.concealActions();
	}

	private void drawnCircles() {
		UpdateDikeFailureCardsDrawnCircle.INSTANCE.reset();
	}

	private void populationCubes() {

		// regions

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			while (!region.getPopulations().getArrayList().isEmpty()) {

				PopulationCube populationCube = region.getPopulations().getArrayList()
						.removeRandom();
				Populations.INSTANCE.getList().getArrayList().addLast(populationCube);

			}

		}

		// population loss

		Populations.INSTANCE.getList().getArrayList()
				.addAllLast(PopulationLoss.INSTANCE.getList().getArrayList().clear());

		Populations.INSTANCE.getList().relocateImageViews();

	}

	private void ports() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			while (!region.getPort().getArrayList().isEmpty()) {

				Port pumpingStation = region.getPort().getArrayList().removeFirst();
				Ports.INSTANCE.getList().getArrayList().addLast(pumpingStation);

			}

		}

		Ports.INSTANCE.getList().relocateImageViews();

	}

	private void pumpingStations() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			while (!region.getPumpingStation().getArrayList().isEmpty()) {

				PumpingStation pumpingStation = region.getPumpingStation().getArrayList()
						.removeFirst();
				PumpingStations.INSTANCE.getList().getArrayList().addLast(pumpingStation);

			}

		}

		PumpingStations.INSTANCE.getList().relocateImageViews();

	}

	private void dikes() {

		for (ERegion eRegion : ERegion.values()) {

			for (Adjacency adjacency : Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion)) {

				DikeLocation dikeLocation = adjacency.getDikeLocation();

				if (dikeLocation == null)
					continue;

				while (!dikeLocation.isEmpty())
					RemoveDike.INSTANCE.execute(dikeLocation);

			}

		}

	}

	private void waterCubes() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			while (!region.getWaterCubes().getArrayList().isEmpty())
				RemoveWaterFromRegion.INSTANCE.execute(region);

		}

	}

}
