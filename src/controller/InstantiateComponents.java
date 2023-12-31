package controller;

import model.Adjacencies;
import model.Cards;
import model.Dikes;
import model.Map;
import model.Ports;
import model.Regions;
import model.WaterCubes;
import model.WaterPumps;

public enum InstantiateComponents {

	INSTANCE;

	private InstantiateComponents() {

		Map.values();
		Regions.values();
		WaterCubes.values();
		Dikes.values();
		WaterPumps.values();
		Ports.values();
		Adjacencies.values();
		Cards.values();

	}

}
