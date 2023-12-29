package controller;

import model.Map;
import model.Regions;

public enum InstantiateComponents {

	INSTANCE;

	private InstantiateComponents() {

		Map.values();
		Regions.values();

	}

}
