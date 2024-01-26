package functions;

import enums.EColor;
import model.HydraulicStructures;

public enum ObjectivesMarkCompleted {

	INSTANCE;

	private int objectiveCompleted = 0;

	public int execute() {

		this.objectiveCompleted = 0;

		return this.objectiveCompleted;

	}

	private boolean greenBasic() {
		return HydraulicStructures.INSTANCE.isBuilt(EColor.GREEN);
	}

	private boolean orangeBasic() {
		return HydraulicStructures.INSTANCE.isBuilt(EColor.ORANGE);
	}

	private boolean purpleBasic() {
		return HydraulicStructures.INSTANCE.isBuilt(EColor.PURPLE);
	}

	private boolean yellowBasic() {
		return HydraulicStructures.INSTANCE.isBuilt(EColor.YELLOW);
	}

	private boolean greenSpecial() {

	}

	private boolean orangeSpecial() {

	}

	private boolean purpleSpecial() {

	}

	private boolean yellowSpecial() {

	}

	private boolean greenPopulation() {

	}

	private void orangePopulation() {

	}

	private void purplePopulation() {

	}

	private void yellowPopulation() {

	}

}
