package controller;

import utils.Enums.RearrangeTypeEnum;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public String primaryStageTitle = "JavaFX", numbersImageViewColor = "black";
	public boolean colliderVisibility = true;
	public final double stagePixesOnTheLeft = 180, gapBetweenBorders = 10, textHeight = 50,
			selectEventHandlerAbleDimension = 100, imageViewCloneWidth = 200, animationStep = 4,
			cameraViewSpots = 1;
	public Vector2 dFrame, dGapBetweenComponents, dCameraView, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel, cImageViewClone;
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.LINEAR;

	private Credentials() {

		double x = 0, y = 0;

		// frame

		this.dFrame = new Vector2(2560 - 4 - 636, 1368);

		// gaps

		this.dGapBetweenComponents = new Vector2(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		// camera view

		this.dCameraView = new Vector2(1, 1);

		// c text panel

		x = 0;
		y = 0;

		this.cTextPanel = new Vector2(x, y);

		// c image view indicator

		x = this.gapBetweenBorders;
		y = this.gapBetweenBorders;
		this.cImageViewClone = new Vector2(x, y);

	}

}
