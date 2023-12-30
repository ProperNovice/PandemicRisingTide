package controller;

import model.Adjacencies;
import model.Dikes;
import model.Map;
import model.Regions;
import model.WaterCubes;

public enum InstantiateComponents {

	INSTANCE;

	private InstantiateComponents() {

		Map.values();
		Regions.values();
		WaterCubes.values();
		Dikes.values();
		Adjacencies.values();

	}

}
