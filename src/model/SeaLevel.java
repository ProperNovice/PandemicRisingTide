package model;

import business.SeaLevelMarker;
import controller.Credentials;
import utils.ArrayList;
import utils.Vector2;

public enum SeaLevel {

	INSTANCE;

	private ArrayList<SeaLevelStep> list = new ArrayList<>();
	private SeaLevelMarker seaLevelMarker = new SeaLevelMarker();

	private SeaLevel() {

		createSeaLevelSteps();
		relocateSeaLevelMarker();

	}

	public void advance() {

		this.list.removeFirst();
		relocateSeaLevelMarker();

	}

	public int getSeaLevel() {
		return this.list.getFirst().seaLevel;
	}

	public void reset() {

		this.list.loadOriginal();
		relocateSeaLevelMarker();

	}

	private void relocateSeaLevelMarker() {
		this.seaLevelMarker.getImageView().relocateCenter(this.list.getFirst().coordinates);
	}

	private void createSeaLevelSteps() {

		Vector2 coordinates = Credentials.INSTANCE.cSeaLevelMarkerFirst;
		coordinates.x += Credentials.INSTANCE.gapBetweenBorders;
		coordinates.y += Credentials.INSTANCE.gapBetweenBorders;

		this.list.addLast(new SeaLevelStep(2, coordinates.clone()));

		coordinates.substractY(Credentials.INSTANCE.hSeaLevelHeight);
		this.list.addLast(new SeaLevelStep(2, coordinates.clone()));

		coordinates.substractY(Credentials.INSTANCE.hSeaLevelHeight);
		this.list.addLast(new SeaLevelStep(2, coordinates.clone()));

		coordinates.substractY(Credentials.INSTANCE.hSeaLevelHeight);
		this.list.addLast(new SeaLevelStep(3, coordinates.clone()));

		coordinates.substractY(Credentials.INSTANCE.hSeaLevelHeight);
		this.list.addLast(new SeaLevelStep(3, coordinates.clone()));

		coordinates.substractY(Credentials.INSTANCE.hSeaLevelHeight);
		this.list.addLast(new SeaLevelStep(3, coordinates.clone()));

		coordinates.substractY(Credentials.INSTANCE.hSeaLevelHeight);
		this.list.addLast(new SeaLevelStep(4, coordinates.clone()));

		coordinates.substractY(Credentials.INSTANCE.hSeaLevelHeight);
		this.list.addLast(new SeaLevelStep(4, coordinates.clone()));

		coordinates.substractY(Credentials.INSTANCE.hSeaLevelHeight);
		this.list.addLast(new SeaLevelStep(4, coordinates.clone()));

		this.list.saveOriginal();

	}

	private class SeaLevelStep {

		private int seaLevel;
		private Vector2 coordinates = null;

		public SeaLevelStep(int seaLevel, Vector2 coordinates) {

			this.seaLevel = seaLevel;
			this.coordinates = coordinates;

		}

	}

}
