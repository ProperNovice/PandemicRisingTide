package cards;

import business.ObjectiveSelect;
import controller.Credentials;
import enums.EColor;
import enums.EObjective;
import utils.ObjectPool;
import utils.Vector2;

public class CardObjective extends Card {

	private EObjective eObjective = null;
	private EColor eColor = null;
	private ObjectiveSelect objectiveSelect = null;

	public CardObjective(EObjective eObjective, EColor eColor) {

		this.eObjective = eObjective;
		this.eColor = eColor;

		String fileName = "cards/objectives/";
		fileName += this.eObjective.toString().toLowerCase();
		fileName += "/";
		fileName += this.eColor.toString().toLowerCase();
		fileName += ".png";

		super.createCard(fileName);

	}

	public void mark() {

		this.objectiveSelect = ObjectPool.INSTANCE.acquire(ObjectiveSelect.class);

		Vector2 coordinates = this.getImageView().getCoordinatesTopLeft().clone();

		coordinates.addX(Credentials.INSTANCE.cObjectiveSelect.x);
		coordinates.addY(Credentials.INSTANCE.cObjectiveSelect.y);

		this.objectiveSelect.getImageView().relocateTopLeft(coordinates);
		this.objectiveSelect.getImageView().setVisible(true);

	}

	public void unmark() {

		this.objectiveSelect.getImageView().setVisible(false);
		this.objectiveSelect = null;

	}

	public EObjective getEObjective() {
		return this.eObjective;
	}

	public EColor getEColor() {
		return this.eColor;
	}

}
