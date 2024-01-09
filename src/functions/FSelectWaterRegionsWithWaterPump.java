package functions;

import business.Adjacency;
import business.Region;
import enums.ERegion;
import model.Adjacencies;
import model.Regions;
import utils.ArrayList;

public enum FSelectWaterRegionsWithWaterPump {

	INSTANCE;

	private ArrayList<ERegion> past = new ArrayList<>();
	private ERegion present = null;
	private ArrayList<ERegion> future = new ArrayList<>();

	public void execute(ERegion eRegion) {

		this.past.clear();
		this.future.addLast(eRegion);
		recursive();

	}

	private void recursive() {

		moveFromFutureToPresent();
		addERegionsToFuture();
		moveFromPresentToPast();

		if (!this.future.isEmpty())
			recursive();

		else
			for (ERegion eRegion : this.past)
				Regions.INSTANCE.getRegion(eRegion).setSelected();

	}

	private void moveFromPresentToPast() {
		this.past.addLast(this.present);
	}

	private void addERegionsToFuture() {

		for (ERegion eRegion : Adjacencies.INSTANCE.getAdjacentERegions(this.present)) {

			Region region = Regions.INSTANCE.getRegion(eRegion);

			if (region.isSea())
				continue;

			if (region.isHighElevated())
				continue;

			if (region.getWaterCubes().getArrayList().isEmpty())
				continue;

			Adjacency adjacency = Adjacencies.INSTANCE.getAdjecencyBetweenRegions(eRegion,
					this.present);

			if (!adjacency.getDikeLocation().isEmpty())
				continue;

			if (this.past.contains(eRegion))
				continue;

			if (this.future.contains(eRegion))
				continue;

			this.future.addLast(eRegion);

		}

	}

	private void moveFromFutureToPresent() {
		this.present = this.future.removeFirst();
	}

}
