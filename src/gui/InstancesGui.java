package gui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public enum InstancesGui {

	INSTANCE;

	private Parent parent = null;
	private Scene scene = null;
	private Stage stage = null;

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Stage getStage() {
		return this.stage;
	}

	public Parent getParent() {
		return this.parent;
	}

	public Scene getScene() {
		return this.scene;
	}

}
