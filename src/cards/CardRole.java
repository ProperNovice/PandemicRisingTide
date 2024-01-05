package cards;

import enums.ELayerZ;
import enums.ERole;

public class CardRole extends Card {

	private ERole eRole = null;

	public CardRole(ERole eRole) {

		this.eRole = eRole;

		String fileName = getFolder();
		fileName += this.eRole.toString();
		fileName += ".png";

		super.createCard(fileName);

	}

	public ERole getERole() {
		return this.eRole;
	}

	@Override
	protected String getFolder() {
		return super.getFolder() + "roles/";
	}

	@Override
	protected String getStringBack() {
		return getFolder() + "back.png";
	}

	@Override
	protected ELayerZ eLayerZ() {
		return ELayerZ.CARDS_ROLE;
	}

}
