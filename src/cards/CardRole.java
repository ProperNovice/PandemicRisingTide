package cards;

import enums.ERole;

public class CardRole extends CardPlayer {

	private ERole eRole = null;

	public CardRole(ERole eRole) {

		this.eRole = eRole;

		String fileName = getFolder();

	}

	public ERole getERole() {
		return this.eRole;
	}

	@Override
	protected String getFolder() {
		return "roles/";
	}

}
