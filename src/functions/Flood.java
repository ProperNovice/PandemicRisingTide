package functions;

import enums.ERegion;
import utils.ArrayList;

public enum Flood {

	INSTANCE;

	private ArrayList<ERegion> list = new ArrayList<>();

	public void execute(ERegion eRegion) {

		this.list.addLast(eRegion);

		System.out.println("flood triggered");

	}

	public boolean floodHasAlreadyBeenTriggeredToRegion(ERegion eRegion) {
		return this.list.contains(eRegion);
	}

	public void clearList() {
		this.list.clear();
	}

}
