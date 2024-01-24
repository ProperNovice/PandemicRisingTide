package cards;

import enums.EColor;
import enums.EObjective;

public class CardObjective extends Card {

	private EObjective eObjective = null;
	private EColor eColor = null;

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

	public EObjective getEObjective() {
		return this.eObjective;
	}

	public EColor getEColor() {
		return this.eColor;
	}

	@Override
	protected String getStringBack() {
		return "cards/objectives/back.png";
	}

}
