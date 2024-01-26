package functions;

import business.Region;
import cards.CardObjective;
import enums.EColor;
import enums.EObjective;
import enums.ERegion;
import model.HydraulicStructures;
import model.Objectives;
import utils.ShutDown;

public enum ObjectivesMarkCompleted {

	INSTANCE;

	public int execute() {

		int objectiveCompleted = 0;
		unmarkObjectives();

		for (EColor eColor : EColor.values()) {

			for (EObjective eObjective : EObjective.values()) {

				if (eColor.equals(EColor.GREEN))
					if (eObjective.equals(EObjective.BASIC))
						if (greenBasic())
							objectiveCompleted++;

				if (eColor.equals(EColor.PURPLE))
					if (eObjective.equals(EObjective.BASIC))
						if (purpleBasic())
							objectiveCompleted++;

				if (eColor.equals(EColor.RED))
					if (eObjective.equals(EObjective.BASIC))
						if (redBasic())
							objectiveCompleted++;

				if (eColor.equals(EColor.YELLOW))
					if (eObjective.equals(EObjective.BASIC))
						if (yellowBasic())
							objectiveCompleted++;

				if (eColor.equals(EColor.GREEN))
					if (eObjective.equals(EObjective.SPECIAL))
						if (greenSpecial())
							objectiveCompleted++;

				if (eColor.equals(EColor.PURPLE))
					if (eObjective.equals(EObjective.SPECIAL))
						if (purpleSpecial())
							objectiveCompleted++;

				if (eColor.equals(EColor.RED))
					if (eObjective.equals(EObjective.SPECIAL))
						if (redSpecial())
							objectiveCompleted++;

				if (eColor.equals(EColor.YELLOW))
					if (eObjective.equals(EObjective.SPECIAL))
						if (yellowSpecial())
							objectiveCompleted++;

				if (eColor.equals(EColor.GREEN))
					if (eObjective.equals(EObjective.POPULATION))
						if (greenPopulation())
							objectiveCompleted++;

				if (eColor.equals(EColor.PURPLE))
					if (eObjective.equals(EObjective.POPULATION))
						if (purplePopulation())
							objectiveCompleted++;

				if (eColor.equals(EColor.RED))
					if (eObjective.equals(EObjective.POPULATION))
						if (redPopulation())
							objectiveCompleted++;

				if (eColor.equals(EColor.YELLOW))
					if (eObjective.equals(EObjective.POPULATION))
						if (yellowPopulation())
							objectiveCompleted++;

			}

		}

		return objectiveCompleted;

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
		return getPopulationOfEColorObjective(EColor.GREEN) >= 7;
	}

	private boolean purplePopulation() {
		return getPopulationOfEColorObjective(EColor.PURPLE) >= 5;
	}

	private boolean redPopulation() {
		return getPopulationOfEColorObjective(EColor.RED) >= 9;
	}

	private boolean yellowPopulation() {
		return getPopulationOfEColorObjective(EColor.YELLOW) >= 7;
	}

	private int getPopulationOfEColorObjective(EColor eColor) {

		int population = 0;

		for (ERegion eRegion : Objectives.INSTANCE.getPopulationERegions(eColor))
			population += getPopulationOfERegion(eRegion);

		return population;

	}

	private int getPopulationOfERegion(ERegion eRegion) {

		for (ERegion eRegionTemp : ERegion.values()) {

			if (!eRegionTemp.equals(eRegion))
				continue;

			Region region = eRegionTemp.getRegion();

			return region.getPopulations().getArrayList().size();

		}

		ShutDown.INSTANCE.execute();

		return -1;

	}

	private void unmarkObjectives() {

		for (CardObjective cardObjective : Objectives.INSTANCE.getObjectives())
			cardObjective.unmark();

	}

}
