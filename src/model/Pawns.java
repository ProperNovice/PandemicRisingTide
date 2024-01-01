package model;

import business.Pawn;
import enums.ERole;
import utils.ArrayList;
import utils.ShutDown;

public enum Pawns {

	INSTANCE;

	private ArrayList<Pawn> list = new ArrayList<>();

	private Pawns() {
		createPawns();
	}

	private void createPawns() {

		for (ERole eRole : ERole.values())
			this.list.addLast(new Pawn(eRole));

	}

	public Pawn getPawn(ERole eRole) {

		for (Pawn pawn : this.list)
			if (pawn.getERole().equals(eRole))
				return pawn;

		ShutDown.INSTANCE.execute();
		return null;

	}

}
