package utils;

import javafx.scene.input.KeyCode;

public enum KeyCodeHandler {

	INSTANCE;

	private HashMap<KeyCode, Integer> keyCodesEText = new HashMap<KeyCode, Integer>();
	private HashMap<KeyCode, Integer> keyCodesCameraView = new HashMap<KeyCode, Integer>();

	private KeyCodeHandler() {

		addKeyCodeEText(KeyCode.Q);
		addKeyCodeEText(KeyCode.W);
		addKeyCodeEText(KeyCode.E);
		addKeyCodeEText(KeyCode.R);

		addKeyCodeCameraView(KeyCode.DIGIT1);
		addKeyCodeCameraView(KeyCode.DIGIT2);
		addKeyCodeCameraView(KeyCode.DIGIT3);
		addKeyCodeCameraView(KeyCode.DIGIT4);
		addKeyCodeCameraView(KeyCode.DIGIT5);
		addKeyCodeCameraView(KeyCode.DIGIT6);
		addKeyCodeCameraView(KeyCode.DIGIT7);
		addKeyCodeCameraView(KeyCode.DIGIT8);
		addKeyCodeCameraView(KeyCode.DIGIT9);

	}

	private void addKeyCodeEText(KeyCode keyCode) {
		this.keyCodesEText.put(keyCode, this.keyCodesEText.size());
	}

	private void addKeyCodeCameraView(KeyCode keyCode) {
		this.keyCodesCameraView.put(keyCode, this.keyCodesCameraView.size() + 1);
	}

	public int getKeyCodeETextInt(KeyCode keyCode) {

		if (this.keyCodesEText.containsKey(keyCode))
			return this.keyCodesEText.getValue(keyCode);
		else
			return -1;

	}

	public int getKeyCodeCameraViewInt(KeyCode keyCode) {

		if (this.keyCodesCameraView.containsKey(keyCode))
			return this.keyCodesCameraView.getValue(keyCode);
		else
			return -1;

	}

}
