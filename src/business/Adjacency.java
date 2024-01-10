package business;

import enums.ERegion;
import utils.ArrayList;

public class Adjacency {

	private ArrayList<ERegion> eRegions = new ArrayList<>();
	private DikeLocation dikeLocation = null;

	public Adjacency(ERegion eRegionA, ERegion eRegionB, double x, double y) {

		this(eRegionA, eRegionB);
		this.dikeLocation = new DikeLocation(x, y);

	}

	public Adjacency(ERegion eRegionA, ERegion eRegionB) {
		this.eRegions.addAllLast(eRegionA, eRegionB);
	}

	public ArrayList<ERegion> getERegionsClone() {
		return this.eRegions.clone();
	}

	public DikeLocation getDikeLocation() {
		return this.dikeLocation;
	}

}
