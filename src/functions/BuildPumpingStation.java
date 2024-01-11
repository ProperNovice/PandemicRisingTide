package functions;

import business.PumpingStation;
import business.Region;
import enums.ERegion;
import model.PumpingStations;

public enum BuildPumpingStation {

	INSTANCE;

	public void executeFromReserve() {

		PumpingStation pumpingStation = PumpingStations.INSTANCE.getList().getArrayList()
				.removeFirst();

		addPumpingStationToActivePlayerERegion(pumpingStation);

	}

	public void executeFromAnotherRegion(Region region) {

		PumpingStation pumpingStation = region.getPumpingStations().getArrayList().removeFirst();
		region.relocateComponents();

		addPumpingStationToActivePlayerERegion(pumpingStation);

	}

	private void addPumpingStationToActivePlayerERegion(PumpingStation pumpingStation) {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		Region region = eRegion.getRegion();

		region.getPumpingStations().getArrayList().addLast(pumpingStation);
		region.relocateComponents();

	}

}
