package business;

import enums.ERegion;
import utils.ArrayList;

public class Adjacency {

	private ArrayList<ERegion> eRegions = new ArrayList<>();
	private DikeLocation dikeLocation = null;

	public Adjacency(ERegion eRegionA, ERegion eRegionB, double x, double y) {

		this.eRegions.addAllLast(eRegionA, eRegionB);

		if (x == -1 && y == -1)
			return;

		this.dikeLocation = new DikeLocation(x, y);

	}

	public Adjacency(ERegion eRegionA, ERegion eRegionB) {
		this(eRegionA, eRegionB, -1, -1);
	}

	public ArrayList<ERegion> getERegions() {
		return this.eRegions.clone();
	}

	public DikeLocation getDikeLocation() {
		return this.dikeLocation;
	}

}
