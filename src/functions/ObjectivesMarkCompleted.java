package functions;

import business.Region;
import cards.CardObjective;
import enums.EColor;
import enums.ERegion;
import model.HydraulicStructures;
import model.Objectives;

public enum ObjectivesMarkCompleted {

	INSTANCE;

	private int objectiveCompleted = 0;

	public int execute() {

		this.objectiveCompleted = 0;
		unmarkObjectives();

		return this.objectiveCompleted;

	}

	private boolean greenBasic() {
		return HydraulicStructures.INSTANCE.isBuilt(EColor.GREEN);
	}

	private boolean purpleBasic() {
		return HydraulicStructures.INSTANCE.isBuilt(EColor.PURPLE);
	}

	private boolean redBasic() {
		return HydraulicStructures.INSTANCE.isBuilt(EColor.RED);
	}

	private boolean yellowBasic() {
		return HydraulicStructures.INSTANCE.isBuilt(EColor.YELLOW);
	}

	private boolean greenSpecial() {

		int ports = 0;

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			if (region.isHighElevated())
				continue;

			if (!region.getEColor().equals(EColor.GREEN))
				continue;

			ports += region.getPort().getArrayList().size();

		}

		return ports >= 4;

	}

	private boolean purpleSpecial() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			if (region.isHighElevated())
				continue;

			if (eRegion.equals(ERegion.MARKERWAARD)
					&& !region.getWaterCubes().getArrayList().isEmpty())
				return false;

			else if (eRegion.equals(ERegion.NOORDOOSTPOLDER)
					&& !region.getWaterCubes().getArrayList().isEmpty())
				return false;

			else if (eRegion.equals(ERegion.FLEVOLAND)
					&& !region.getWaterCubes().getArrayList().isEmpty())
				return false;

		}

		return true;

	}

	private boolean redSpecial() {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			if (region.isHighElevated())
				continue;

			if (!region.getEColor().equals(EColor.RED))
				continue;

			if (!region.getWaterCubes().getArrayList().isEmpty())
				return false;

		}

		return true;

	}

	private boolean yellowSpecial() {

		int pumpingStation = 0;

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			if (region.isHighElevated())
				continue;

			if (!region.getEColor().equals(EColor.YELLOW))
				continue;

			pumpingStation += region.getPumpingStation().getArrayList().size();

		}

		return pumpingStation >= 4;

	}

	private boolean greenPopulation() {

		int population = 0;

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.isSea())
				continue;

			if (region.isHighElevated())
				continue;

			if (!region.getEColor().equals(EColor.YELLOW))
				continue;

			population += region.getPopulations().getArrayList().size();

		}

		return population >= 4;

	}

	private boolean redPopulation() {

	}

	private boolean purplePopulation() {

	}

	private boolean yellowPopulation() {

	}

	private void unmarkObjectives() {

		for (CardObjective cardObjective : Objectives.INSTANCE.getList())
			cardObjective.unmark();

	}

}
