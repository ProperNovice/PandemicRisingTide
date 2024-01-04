package gameStates;

import actions.WaterFlows;
import business.Adjacency;
import business.Dike;
import business.DikeLocation;
import business.Pawn;
import business.Population;
import business.Port;
import business.Region;
import business.WaterCube;
import business.WaterPump;
import controller.Credentials;
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

		handleKeyPressed(KeyCode.M);

//		addWaterCubes(4, ERegion.NOORDZEE);
//		addWaterCubes(4, ERegion.ZUIDERZEE);
		addWaterCubes(2, ERegion.FRYSLAN);
		addPopulations(3, ERegion.FRYSLAN);
		addWaterPump(ERegion.FRYSLAN);
		addPort(ERegion.FRYSLAN);
		addPawn(ERole.CARPENTER, ERegion.FRYSLAN);
		addPawn(ERole.SANITATION_ENGINEER, ERegion.FRYSLAN);
		addPawn(ERole.WEREHOUSE_MANAGER, ERegion.FRYSLAN);

		addDike(ERegion.FRYSLAN, ERegion.NOORDERZIJLVEST);
		addDike(ERegion.FRYSLAN, ERegion.NOORDERZIJLVEST);
//		addDike(ERegion.FRYSLAN, ERegion.VOLLENHOVE);
		addDike(ERegion.FRYSLAN, ERegion.NOORDOOSTPOLDER);
		addDike(ERegion.FRYSLAN, ERegion.NOORDZEE);
		addDike(ERegion.FRYSLAN, ERegion.ZUIDERZEE);

		WaterFlows.INSTANCE.execute();

	}

	public void addPopulations(int amount, ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		for (int counter = 1; counter <= amount; counter++) {

			Population population = new Population();
			population.getImageView().setHeight(Credentials.INSTANCE.hWaterPopulationCubeMap);
			region.getPopulations().getArrayList().addLast(population);

		}

		region.relocateComponents();

	}

	public void addWaterCubes(int amount, ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		for (int counter = 1; counter <= amount; counter++) {

			WaterCube waterCube = new WaterCube();
			waterCube.getImageView().setHeight(Credentials.INSTANCE.hWaterPopulationCubeMap);
			region.getWaterCubes().getArrayList().addLast(waterCube);

		}

		region.relocateComponents();

	}

	public void addWaterPump(ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		region.getWaterPumps().getArrayList().addLast(new WaterPump());
		region.getWaterPumps().getArrayList().getLast().getImageView()
				.setHeight(Credentials.INSTANCE.hPortWaterPumpMap);

		region.relocateComponents();

	}

	public void addPort(ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		region.getPorts().getArrayList().addLast(new Port());
		region.getPorts().getArrayList().getLast().getImageView()
				.setHeight(Credentials.INSTANCE.hPortWaterPumpMap);

		region.relocateComponents();

	}

	public void addPawn(ERole eRole, ERegion eRegion) {

		Region region = Regions.INSTANCE.getRegion(eRegion);

		region.getPawns().getArrayList().addLast(new Pawn(eRole));
		region.getPawns().getArrayList().getLast().getImageView().setVisible(true);

		region.relocateComponents();

	}

	public void addDike(ERegion eRegionA, ERegion eRegionB) {

		ArrayList<Adjacency> list = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegionA);
		Adjacency adjacency = null;

		for (Adjacency adjacencyTemp : list) {

			if (!adjacencyTemp.getERegions().contains(eRegionB))
				continue;

			adjacency = adjacencyTemp;
			break;

		}

		DikeLocation dikeLocation = adjacency.getDikeLocation();
		dikeLocation.addDikeRelocate(new Dike());

	}

}
