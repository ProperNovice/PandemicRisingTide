package functions;

import business.Port;
import business.Region;
import enums.ERegion;
import model.Ports;

public enum BuildPort {

	INSTANCE;

	public void executeFromReserve() {

		Port port = Ports.INSTANCE.getList().getArrayList().removeFirst();
		addPumpingStationToActivePlayerERegion(port);

	}

	public void executeFromAnotherRegion(Region region) {

		Port port = region.getPort().getArrayList().removeFirst();
		region.relocateComponents();

		addPumpingStationToActivePlayerERegion(port);

	}

	private void addPumpingStationToActivePlayerERegion(Port port) {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();

		Region region = eRegion.getRegion();

		region.getPort().getArrayList().addLast(port);
		region.relocateComponents();

	}

}
