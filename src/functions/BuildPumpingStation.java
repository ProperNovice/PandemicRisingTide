package functions;

import business.PumpingStation;
import business.Region;
import enums.ERegion;
import model.PumpingStations;

public enum BuildPumpingStation {

	INSTANCE;

	public void executeFromReserveActivePlayerRegion() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		executeFromReserve(eRegion);

	}

	public void executeFromReserve(ERegion eRegion) {

		PumpingStation pumpingStation = PumpingStations.INSTANCE.getList().getArrayList()
				.removeFirst();

		addPumpingStationToERegion(eRegion, pumpingStation);

	}

	public void executeFromAnotherRegion(Region region) {

		PumpingStation pumpingStation = region.getPumpingStation().getArrayList().removeFirst();
		region.relocateComponents();

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		addPumpingStationToERegion(eRegion, pumpingStation);

	}

	private void addPumpingStationToERegion(ERegion eRegion, PumpingStation pumpingStation) {

		Region region = eRegion.getRegion();

		region.getPumpingStation().getArrayList().addLast(pumpingStation);
		region.relocateComponents();

	}

}
