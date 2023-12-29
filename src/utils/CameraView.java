package utils;

import controller.Credentials;
import utils.Enums.MapImageViews;
import utils.Interfaces.IImageViewAble;

public enum CameraView {

	INSTANCE;

	private double heightUnit;
	private int cameraViewSpotCurrent = 1;

	private CameraView() {

		this.heightUnit = Credentials.INSTANCE.dCameraView.y;
		this.heightUnit -= Credentials.INSTANCE.dFrame.y;
		this.heightUnit += 2 * Credentials.INSTANCE.gapBetweenBorders;
		this.heightUnit /= (Credentials.INSTANCE.cameraViewSpots - 1);

	}

	public void setCameraViewingSpot(int cameraViewSpot) {

		if (cameraViewSpot == this.cameraViewSpotCurrent)
			return;

		Logger.INSTANCE.logNewLine("executing camera view -> " + cameraViewSpot);

		this.cameraViewSpotCurrent = cameraViewSpot;

		for (IImageViewAble imageViewAble : MapImageViews.INSTANCE.getImageViewsMap())
			relocateImageviewAble(imageViewAble);

	}

	public void relocateImageviewAble(IImageViewAble imageViewAble) {

		if (imageViewAble instanceof Background)
			return;

		double imageViewTopLeftX = imageViewAble.getImageView().getCoordinatesTopLeftX();
		double cameraViewTopLeftX = Credentials.INSTANCE.dCameraView.x
				+ Credentials.INSTANCE.gapBetweenBorders;

		Vector2 vector2 = imageViewAble.getImageView().getCoordinatesTopLeft().clone();

		if (imageViewTopLeftX < cameraViewTopLeftX)
			for (int counter = 2; counter <= this.cameraViewSpotCurrent; counter++)
				vector2.y -= this.heightUnit;

		imageViewAble.getImageView().relocateTopLeftCamera(vector2);

	}

}
