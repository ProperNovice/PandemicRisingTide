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

	public Vector2 dCard, dActionIndicator, dWaterCube, dDike, dWaterPump, dPort;
	public Vector2 cMap, cActionIndicators, cWaterCubes, cDikes, cWaterPumps, cPorts;

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

		// d water cube

		x = 40;
		y = 40;
		this.dWaterCube = new Vector2(40, 40);

		// d dike

		this.dDike = this.dWaterCube.clone();

		// d water pump

		y = 60;
		x = 86 * y / 100;
		this.dWaterPump = new Vector2(x, y);

		// d port

		y = 60;
		x = 64 * y / 100;
		this.dPort = new Vector2(x, y);

		// c water cubes

		x = this.gapBetweenBorders;
		x += this.dCameraView.x;
		x += this.dGapBetweenComponents.x;
		y = this.gapBetweenBorders;
		this.cWaterCubes = new Vector2(x, y);

		// c dikes

		this.cDikes = this.cWaterCubes.clone();
		this.cDikes.y += this.dWaterCube.y;
		this.cDikes.y += this.dGapBetweenComponents.y;

		// c water pumps

		this.cWaterPumps = this.cDikes.clone();
		this.cWaterPumps.y += this.dDike.y;
		this.cWaterPumps.y += this.dGapBetweenComponents.y;

		// c ports

		this.cPorts = this.cWaterPumps.clone();
		this.cPorts.x += this.dWaterPump.x / 2;
		this.cPorts.y += this.dWaterPump.y;
		this.cPorts.y += this.dGapBetweenComponents.y;
		this.cPorts.y += this.dPort.y / 2;

		// c action indicators

		this.cActionIndicators = new Vector2(x, y);

	}

}
