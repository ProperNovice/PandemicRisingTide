package functions;

import business.Port;
import business.Region;
import enums.ERegion;
import model.Ports;

public enum BuildPort {

	INSTANCE;

	public void executeFromReserveActivePlayerRegion() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		executeFromReserve(eRegion);

	}

	public void executeFromReserve(ERegion eRegion) {

		Port port = Ports.INSTANCE.getList().getArrayList().removeFirst();

		addPumpingStationToERegion(eRegion, port);

	}

	public void executeFromAnotherRegion(Region region) {

		Port port = region.getPort().getArrayList().removeFirst();
		region.relocateComponents();

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		addPumpingStationToERegion(eRegion, port);

	}

	private void addPumpingStationToERegion(ERegion eRegion, Port port) {

		Region region = eRegion.getRegion();

		region.getPort().getArrayList().addLast(port);
		region.relocateComponents();

	}

}
