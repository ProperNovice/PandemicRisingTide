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

	public Vector2 dCard, dActionIndicator, dWaterCube;
	public Vector2 cMap, cActionIndicators, cWaterCubes;

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

		// d action indicators

		y = this.dCard.y / 5;
		this.dActionIndicator = new Vector2(y, y);

		// c action indicators

		x = this.gapBetweenBorders;
		x += this.dCameraView.x;
		x += this.dGapBetweenComponents.x;
		y = this.gapBetweenBorders;
		this.cActionIndicators = new Vector2(x, y);

		// d water cubes

		this.dWaterCube = this.dActionIndicator.clone();

		// c water cubes

		this.cWaterCubes = this.cActionIndicators.clone();
		this.cWaterCubes.x += this.dActionIndicator.x;
		this.cWaterCubes.x += this.dGapBetweenComponents.x;

	}

}
