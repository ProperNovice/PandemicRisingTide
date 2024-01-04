package actions;

import business.Adjacency;
import business.DikeLocation;
import business.Region;
import enums.ERegion;
import model.Adjacencies;
import model.Regions;
import utils.ArrayList;
import utils.Logger;

public enum WaterFlows {

	INSTANCE;

	private ArrayList<ERegion> listSource = new ArrayList<>();
	private ArrayList<ERegion> listTarget = new ArrayList<>();

	private WaterFlows() {

	}

	public void execute() {

		for (int counter = 4; counter >= 2; counter--)
			execute(counter);

	}

	private void execute(int amount) {

		Logger.INSTANCE.logNewLine("amount - " + amount);

		clearLists();
		populateListSource(amount);

		Logger.INSTANCE.log("source regions");
		for (ERegion eRegion : this.listSource)
			Logger.INSTANCE.log(eRegion);

		Logger.INSTANCE.newLine();

		populateListTarget(amount - 1);

		Logger.INSTANCE.log("target regions");
		for (ERegion eRegion : this.listTarget)
			Logger.INSTANCE.log(eRegion);

		Logger.INSTANCE.newLine();

		addWaterToListTarget(amount - 1);

		Logger.INSTANCE.logNewLine("end amount - " + amount);

	}

	private void addWaterToListTarget(int amountTarget) {

		for (ERegion eRegion : this.listTarget) {

			Region region = Regions.INSTANCE.getRegion(eRegion);
			int waterCubesToAdd = amountTarget - region.getWaterCubes().getArrayList().size();

			AddWaterToRegion.INSTANCE.execute(eRegion, waterCubesToAdd);

		}

	}

	private void populateListTarget(int amountTarget) {

		for (ERegion eRegionSource : this.listSource) {

			ArrayList<ERegion> adjacentERegions = Adjacencies.INSTANCE
					.getAdjacentERegions(eRegionSource);

			for (ERegion eRegionTarget : adjacentERegions) {

				Region regionTarget = Regions.INSTANCE.getRegion(eRegionTarget);

				// check if is sea

				if (regionTarget.isSea())
					continue;

				// check if is high elevated

				if (regionTarget.isHighElevated())
					continue;

				// check if already has target amount of cubes

				if (regionTarget.getWaterCubes().getArrayList().size() >= amountTarget)
					continue;

				// check if there is dike in adjacency

				Adjacency adjacency = Adjacencies.INSTANCE.getAdjecencyBetweenRegions(eRegionSource,
						eRegionTarget);

				DikeLocation dikeLocation = adjacency.getDikeLocation();

				if (dikeLocation.dikeSize() > 0)
					continue;

				// check if list already contains region

				if (this.listTarget.contains(eRegionTarget))
					continue;

				this.listTarget.addLast(eRegionTarget);

			}

		}

	}

	private void populateListSource(int amount) {

		for (ERegion eRegion : ERegion.values()) {

			Region region = Regions.INSTANCE.getRegion(eRegion);

			if (region.isHighElevated())
				continue;

			int cubes = region.getWaterCubes().getArrayList().size();

			if (cubes != amount)
				continue;

			this.listSource.addLast(eRegion);

		}

	}

	private void clearLists() {
		this.listSource.clear();
		this.listTarget.clear();
	}

}
