package controller;

import utils.Enums.RearrangeTypeEnum;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public String primaryStageTitle = "Pandemic: Rising Tide", numbersImageViewColor = "black";
	public boolean colliderVisibility = true;
	public final double stagePixesOnTheLeft = 180, gapBetweenBorders = 14, textHeight = 50,
			selectEventHandlerAbleDimension = 100, imageViewCloneWidth = 200, animationStep = 4,
			cameraViewSpots = 3;
	public Vector2 dFrame, dGapBetweenComponents, dCameraView, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel, cImageViewClone;
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.LINEAR;

	public double hPortWaterPumpMap, hWaterPopulationCubeMap, hDikeMap;
	public Vector2 dCard, dActionIndicator, dWaterCube, dDike, dWaterPump, dPort, dPopulation,
			dPawn;
	public Vector2 cMap, cActionIndicators, cWaterCubes, cDikes, cWaterPumps, cPorts, cPopulation,
			cDeckPlayer, cDiscardPilePlayer, cDeckDikeFailure, cDiscardPileDikeFailure;

	private Credentials() {

		double x = 0, y = 0;

		// frame

		this.dFrame = new Vector2(2560 - 4 + 4, 1440);

		// gaps

		this.dGapBetweenComponents = new Vector2(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		// camera view

		x = 1696;
		y = 2316;
		this.dCameraView = new Vector2(x, y);

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
		this.dWaterPump = new Vector2(x, y);

		// d port

		y = this.dWaterPump.y;
		x = 64 * y / 100;
		this.dPort = new Vector2(x, y);

		// d water cube

		x = this.dCard.y;
		x -= this.dWaterPump.y;
		x -= this.dPort.y;
		x -= 4 * this.dGapBetweenComponents.y;
		x /= 3;
		this.dWaterCube = new Vector2(x, x);

		// d dike

		this.dDike = this.dWaterCube.clone();

		// d population

		this.dPopulation = this.dWaterCube.clone();

		// c water cubes

		x = this.gapBetweenBorders;
		x += this.dCameraView.x;
		x += this.dGapBetweenComponents.x;
		x += this.dWaterPump.x / 2;
		y = this.gapBetweenBorders;
		y += this.dWaterCube.y / 2;
		this.cWaterCubes = new Vector2(x, y);

		// c dikes

		this.cDikes = this.cWaterCubes.clone();
		this.cDikes.y += this.dWaterCube.y;
		this.cDikes.y += this.dGapBetweenComponents.y;

		// c water pumps

		this.cWaterPumps = this.cDikes.clone();
		this.cWaterPumps.y += this.dDike.y / 2;
		this.cWaterPumps.y += this.dGapBetweenComponents.y;
		this.cWaterPumps.y += this.dWaterPump.y / 2;

		// c ports

		this.cPorts = this.cWaterPumps.clone();
		this.cPorts.y += this.dWaterPump.y / 2;
		this.cPorts.y += this.dGapBetweenComponents.y;
		this.cPorts.y += this.dPort.y / 2;

		// c population

		this.cPopulation = this.cPorts.clone();
		this.cPopulation.y += this.dPort.y / 2;
		this.cPopulation.y += this.dGapBetweenComponents.y;
		this.cPopulation.y += this.dPopulation.y / 2;

		// c action indicators

		this.cActionIndicators = new Vector2(x, y);

		// h token map

		this.hPortWaterPumpMap = 64;
		this.hWaterPopulationCubeMap = 40;

		y = 80;
		x = 54 * y / 100;
		this.dPawn = new Vector2(x, y);

		// c deck player

		x = this.gapBetweenBorders;
		x += this.dCameraView.x;
		x += this.dGapBetweenComponents.x;
		y = this.gapBetweenBorders;
		y += this.dCard.y;
		y += this.dGapBetweenComponents.y;
		this.cDeckPlayer = new Vector2(x, y);

		// c discard pile player

		this.cDiscardPilePlayer = this.cDeckPlayer.clone();
		this.cDiscardPilePlayer.x += this.dCard.x;
		this.cDiscardPilePlayer.x += this.dGapBetweenComponents.x;

	}

}
