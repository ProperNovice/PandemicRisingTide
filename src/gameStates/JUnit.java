package gameStates;

import business.Pawn;
import business.Population;
import business.Port;
import business.Region;
import business.WaterCube;
import business.WaterPump;
import enums.ERegion;
import enums.ERole;
import gameStatesDefault.GameState;
import model.Regions;

public class JUnit extends GameState {

	@Override
	public void execute() {

//		handleKeyPressed(KeyCode.M);

		ERegion eRegion = ERegion.FRYSLAN;

		addWaterCubes(2, eRegion);
		addPopulations(3, eRegion);
		addPort(eRegion);
		addWaterPump(eRegion);
		addPawn(ERole.HYDRAULIC_ENGINEER, eRegion);
		addPawn(ERole.PUMP_OPERATOR, eRegion);

		Regions.INSTANCE.getRegion(eRegion).relocateComponents();

	}

	public void addPopulations(int amount, ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		for (int counter = 1; counter <= amount; counter++)
			region.getPopulations().getArrayList().addLast(new Population());

		region.relocateComponents();

	}

	public void addWaterCubes(int amount, ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		for (int counter = 1; counter <= amount; counter++)
			region.getWaterCubes().getArrayList().addLast(new WaterCube());

		region.relocateComponents();

	}

	public void addWaterPump(ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		region.getWaterPumps().getArrayList().addLast(new WaterPump());

		region.relocateComponents();

	}

	public void addPort(ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		region.getPorts().getArrayList().addLast(new Port());

		region.relocateComponents();

	}

	public void addPawn(ERole eRole, ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		Pawn pawn = new Pawn(eRole);
		pawn.getImageView().setVisible(true);

		region.getPawns().getArrayList().addLast(pawn);

		region.relocateComponents();

	}

}
