package controller;

import utils.Enums.RearrangeTypeEnum;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public String primaryStageTitle = "Pandemic: Rising Tide", numbersImageViewColor = "black";
	public boolean colliderVisibility = true;
	public final double stagePixesOnTheLeft = 180, gapBetweenBorders = 14 + 2, textHeight = 50,
			selectEventHandlerAbleDimension = 100, imageViewCloneWidth = 200, animationStep = 4,
			cameraViewSpots = 3;
	public Vector2 dFrame, dGapBetweenComponents, dCameraView, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel, cImageViewClone;
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.LINEAR;

	public double hPortWaterPumpMap, hWaterPopulationCubeMap, hHydraulicStructure, hSeaLevelMarker,
			hSeaLevelHeight;
	public Vector2 dMap, dCard, dActionIndicator, dWaterCube, dDike, dPumpingStation, dPort,
			dPopulation, dPawn, dActionsRemaining, dCircle, dObjectiveSelect;
	public Vector2 cMap, cActionIndicators, cWaterCubes, cDikes, cPumpingStations, cPorts,
			cPopulation, cDeckPlayer, cDiscardPilePlayer, cDeckDikeFailure, cDiscardPileDikeFailure,
			cPlayerTop, cPlayerBottom, cHydraulicStructureMapGreen, cHydraulicStructureMapOrange,
			cHydraulicStructureMapPurple, cHydraulicStructureMapYellow,
			cHydraulicStructurePurpleBuilding, cSeaLevelMarkerFirst, cCardsDeckPanel, cObjectives,
			cObjectiveSelect, cPopulationLoss;

	private Credentials() {

		double x = 0, y = 0;

		// frame

		this.dFrame = new Vector2(2560 - 4 + 4, 1440);

		// gaps

		this.dGapBetweenComponents = new Vector2(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		// d map

		x = 1696;
		y = 2316;
		this.dMap = new Vector2(x, y);

		// camera view

		this.dCameraView = this.dMap.clone();

		// c text panel

		x = 0;
		y = 0;

		this.cTextPanel = new Vector2(x, y);

		// c image view indicator

		x = this.gapBetweenBorders;
		y = this.gapBetweenBorders;
		this.cImageViewClone = new Vector2(x, y);

		// d card

		x = 205;
		y = 280;
		this.dCard = new Vector2(x, y);

		// c map

		x = this.gapBetweenBorders;
		y = this.gapBetweenBorders;
		this.cMap = new Vector2(x, y);

		// d action indicator

		y = this.dCard.y / 5;
		this.dActionIndicator = new Vector2(y, y);

		// d water pump

		y = 78; // or
		y = 64;
		x = 86 * y / 100;
		this.dPumpingStation = new Vector2(x, y);

		// d port

		y = this.dPumpingStation.y;
		x = 100 * y / 100;
		this.dPort = new Vector2(x, y);

		// d water cube

		x = this.dCard.y;
		x -= this.dPumpingStation.y;
		x -= this.dPort.y;
		x -= 4 * this.dGapBetweenComponents.y;
		x /= 3;
		this.dWaterCube = new Vector2(x, x);

		// d dike

		this.dDike = this.dWaterCube.clone();

		// d population

		this.dPopulation = this.dWaterCube.clone();

		// d actions remaining

		x = 80;
		this.dActionsRemaining = new Vector2(x, x);

		// c water cubes

		x = this.gapBetweenBorders;
		x += this.dMap.x;
		x += this.dGapBetweenComponents.x;
		x += this.dPort.x / 2;
		y = this.gapBetweenBorders;
		y += this.dWaterCube.y / 2;
		this.cWaterCubes = new Vector2(x, y);

		// c dikes

		this.cDikes = this.cWaterCubes.clone();
		this.cDikes.y += this.dWaterCube.y;
		this.cDikes.y += this.dGapBetweenComponents.y;

		// c water pumps

		this.cPumpingStations = this.cDikes.clone();
		this.cPumpingStations.y += this.dDike.y / 2;
		this.cPumpingStations.y += this.dGapBetweenComponents.y;
		this.cPumpingStations.y += this.dPumpingStation.y / 2;

		// c ports

		this.cPorts = this.cPumpingStations.clone();
		this.cPorts.y += this.dPumpingStation.y / 2;
		this.cPorts.y += this.dGapBetweenComponents.y;
		this.cPorts.y += this.dPort.y / 2;

		// c population

		this.cPopulation = this.cPorts.clone();
		this.cPopulation.y += this.dPort.y / 2;
		this.cPopulation.y += this.dGapBetweenComponents.y;
		this.cPopulation.y += this.dPopulation.y / 2;

		// c action indicators

		x = this.cPumpingStations.x;
		x += this.dPort.x / 2;
		x += this.dGapBetweenComponents.x;
		y = this.gapBetweenBorders;
		this.cActionIndicators = new Vector2(x, y);

		// h token map

		this.hPortWaterPumpMap = 64;
		this.hWaterPopulationCubeMap = 40;

		y = 80;
		x = 54 * y / 100;
		this.dPawn = new Vector2(x, y);

		// h hydraulic structure

		this.hHydraulicStructure = 80;

		// h sea level marker

		this.hSeaLevelMarker = 100;

		// c deck player

		x = 172;
		y = 2089;
		this.cDeckPlayer = new Vector2(x, y);

		// c discard pile player

		x = 436;
		y = 2089;
		this.cDiscardPilePlayer = new Vector2(x, y);

		// c deck dike failure

		x = 225;
		y = 170;
		this.cDeckDikeFailure = new Vector2(x, y);

		// c discard pile dike failure

		x = 225;
		y = 436;
		this.cDiscardPileDikeFailure = new Vector2(x, y);

		// c player top

		x = this.gapBetweenBorders;
		x += this.dMap.x;
		x += this.dGapBetweenComponents.x;
		y = this.gapBetweenBorders;
		y += this.dCard.y;
		y += this.dGapBetweenComponents.y;
		this.cPlayerTop = new Vector2(x, y);

		// c player bottom

		this.cPlayerBottom = this.cPlayerTop.clone();
		this.cPlayerBottom.y += 2 * this.dCard.y;
		this.cPlayerBottom.y += this.dGapBetweenComponents.y;

		// c hydraulic structure map orange

		x = 658;
		y = 2027;
		this.cHydraulicStructureMapOrange = new Vector2(x, y);

		// c hydraulic structure map purple

		x = 818;
		y = 2027;
		this.cHydraulicStructureMapPurple = new Vector2(x, y);

		// c hydraulic structure map yellow

		x = 978;
		y = 2027;
		this.cHydraulicStructureMapYellow = new Vector2(x, y);

		// c hydraulic structure map green

		x = 1138;
		y = 2027;
		this.cHydraulicStructureMapGreen = new Vector2(x, y);

		// c hydraulic structure purple building

		x = 1014;
		y = 432;
		this.cHydraulicStructurePurpleBuilding = new Vector2(x, y);

		// c sea level marker first

		x = 158;
		y = 1324;
		this.cSeaLevelMarkerFirst = new Vector2(x, y);

		// h sea level height

		this.hSeaLevelHeight = 78;

		// c cards deck panel

		this.cCardsDeckPanel = this.cDiscardPilePlayer.clone();
		this.cCardsDeckPanel.addX(this.cDiscardPilePlayer.x - this.cDeckPlayer.x);
		this.cCardsDeckPanel.y -= this.dCard.y - this.dGapBetweenComponents.y;

		// d circle

		this.dCircle = new Vector2(120, 120);

		// c objectives

		x = this.cPorts.x;
		x += this.dPort.x / 2;
		x += this.dGapBetweenComponents.x;
		x += this.dActionIndicator.x;
		x += this.dGapBetweenComponents.x;
		y = this.gapBetweenBorders;
		this.cObjectives = new Vector2(x, y);

		// d objective select

		x = this.dCard.x * 2 / 5;
		y = x;
		this.dObjectiveSelect = new Vector2(x, y);

		// c objective select

		x = this.dGapBetweenComponents.x;
		y = this.dCard.y * 0.22;
		this.cObjectiveSelect = new Vector2(x, y);

		// c population loss

		x = 898;
		y = 1895;
		this.cPopulationLoss = new Vector2(x, y);

	}

}
