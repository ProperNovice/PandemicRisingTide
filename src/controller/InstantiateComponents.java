package controller;

import model.Actions;
import model.Adjacencies;
import model.Cards;
import model.Dikes;
import model.HydraulicStructures;
import model.Map;
import model.Objectives;
import model.Pawns;
import model.Players;
import model.Populations;
import model.Ports;
import model.PumpingStations;
import model.Regions;
import model.SeaLevel;
import model.WaterCubes;

public enum InstantiateComponents {

	INSTANCE;

	private InstantiateComponents() {

		Map.values();
		Regions.values();
		WaterCubes.values();
		Dikes.values();
		PumpingStations.values();
		Ports.values();
		Populations.values();
		Adjacencies.values();
		Cards.values();
		Pawns.values();
		Players.values();
		Actions.values();
		HydraulicStructures.values();
		SeaLevel.values();
		Objectives.values();

	}

}
