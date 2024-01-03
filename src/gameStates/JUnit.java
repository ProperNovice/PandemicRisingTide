package gameStates;

import business.Adjacency;
import business.Dike;
import business.DikeLocation;
import business.Pawn;
import business.Population;
import business.Port;
import business.Region;
import business.WaterCube;
import business.WaterPump;
import enums.ERegion;
import enums.ERole;
import gameStatesDefault.GameState;
import javafx.scene.input.KeyCode;
import model.Adjacencies;
import model.Regions;
import utils.ArrayList;

public class JUnit extends GameState {

	@Override
	public void execute() {

//		handleKeyPressed(KeyCode.M);

	}

	@Override
	protected void handleKeyPressed(KeyCode keyCode) {

		boolean q = true;

		if (keyCode.equals(KeyCode.W))
			q = false;

		addRemoveDike(ERegion.FRYSLAN, ERegion.NOORDERZIJLVEST, q);

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

	public void addRemoveDike(ERegion eRegionA, ERegion eRegionB, boolean add) {

		ArrayList<Adjacency> list = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegionA);
		Adjacency adjacency = null;

		for (Adjacency adjacencyTemp : list) {

			if (!adjacencyTemp.getERegions().contains(eRegionB))
				continue;

			adjacency = adjacencyTemp;
			break;

		}

		DikeLocation dikeLocation = adjacency.getDikeLocation();

		if (add)
			dikeLocation.addDikeRelocate(new Dike());
		else
			dikeLocation.removeDikeRelocate();

	}

}
