package cards;

import enums.EColor;
import enums.ERegion;

public class CardPlayerRegion extends CardPlayer {

	private ERegion eRegion = null;
	private EColor eColor = null;

	public CardPlayerRegion(ERegion eRegion, EColor eColor) {

		this.eRegion = eRegion;
		this.eColor = eColor;

		String fileName = getFolder();
		fileName += this.eColor.toString().toLowerCase();
		fileName += "/";
		fileName += this.eRegion;
		fileName += ".png";

		super.createCard(fileName);

	}

	public ERegion getERegion() {
		return this.eRegion;
	}

	public EColor getEColor() {
		return this.eColor;
	}

	@Override
	protected String getFolder() {
		return super.getFolder() + "regions/";
	}

}
