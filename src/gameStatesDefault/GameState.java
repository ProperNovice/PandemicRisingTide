package gameStatesDefault;

import controller.Credentials;
import enums.EText;
import javafx.scene.input.KeyCode;
import utils.ArrayList;
import utils.CameraView;
import utils.Flow;
import utils.KeyCodeHandler;
import utils.Logger;
import utils.SelectImageViewManager;
import utils.TextManager;

public abstract class GameState {

	public abstract void execute();

	public final void handleTextOptionPressed(EText textEnum) {

		Logger.INSTANCE.log("text option executing");
		Logger.INSTANCE.logNewLine(textEnum);

		TextManager.INSTANCE.concealText();
		executeTextOption(textEnum);

	}

	public final void executeKeyPressed(KeyCode keyCode) {

		handleKeyPressed(keyCode);

		// e text

		int keyCodeETextID = KeyCodeHandler.INSTANCE.getKeyCodeETextInt(keyCode);

		if (keyCodeETextID != -1) {

			EText textEnumPressed = TextManager.INSTANCE.getTextEnumOptionPressed(keyCodeETextID);

			if (textEnumPressed == null)
				return;

			Logger.INSTANCE.log("executing key pressed -> " + keyCode);
			handleTextOptionPressed(textEnumPressed);

		}

		// camera view

		int cameraViewSpot = KeyCodeHandler.INSTANCE.getKeyCodeCameraViewInt(keyCode);

		if (cameraViewSpot > 0 && cameraViewSpot <= Credentials.INSTANCE.cameraViewSpots)
			CameraView.INSTANCE.setCameraViewingSpot(cameraViewSpot);

	}

	protected void handleKeyPressed(KeyCode keyCode) {

	}

	protected void executeTextOption(EText eText) {

	}

	protected final ArrayList<Class<? extends GameState>> getFlow() {
		return Flow.INSTANCE.getFlow();
	}

	protected final void executeGameState(Class<? extends GameState> gameState) {
		Flow.INSTANCE.executeGameState(gameState);
	}

	protected final void proceedToNextGameState() {
		Flow.INSTANCE.proceed();
	}

	protected final void concealText() {
		TextManager.INSTANCE.concealText();
	}

	protected final SelectImageViewManager getSelectImageViewManager() {
		return SelectImageViewManager.INSTANCE;
	}

}
