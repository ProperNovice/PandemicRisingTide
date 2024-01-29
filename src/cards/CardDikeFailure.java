package cards;

import enums.ERegion;

public class CardDikeFailure extends Card {

	private ERegion eRegion = null;

	public CardDikeFailure(ERegion eRegion) {

		this.eRegion = eRegion;

		String fileName = getFolder();
		fileName += this.eRegion.toString();
		fileName += ".png";

		super.createCard(fileName);

	}

	public ERegion getERegion() {
		return this.eRegion;
	}

	@Override
	protected String getFolder() {
		return super.getFolder() + "dikeFailure/";
	}

}
