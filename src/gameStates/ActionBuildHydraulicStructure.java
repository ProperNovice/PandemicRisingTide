package gameStates;

import cards.CardPlayer;
import cards.CardPlayerRegion;
import enums.EAction;
import enums.EColor;
import enums.ERegion;
import functions.BuildHydraulicStructure;
import functions.DiscardCardsSelected;
import functions.GetCardsSelectedActivePlayer;
import functions.GetERegionContainingPlayerPawn;
import functions.SelectCardsForHydraulicStructure;
import gameStatesDefault.GameState;
import model.Actions;
import utils.Flow;
import utils.HashMap;

public class ActionBuildHydraulicStructure extends GameState {

	private HashMap<EColor, Class<? extends GameState>> hashMap = new HashMap<>();
	private EColor eColor = null;

	@Override
	public void execute() {

		createHashMap();
		setEColor();

		SelectCardsForHydraulicStructure.INSTANCE.execute();

		if (GetCardsSelectedActivePlayer.INSTANCE.execute().size() == 5)
			proceed();
		else
			EAction.BUILD_HYDRAULIC_STRUCTURE.show();

	}

	@Override
	protected void handleActionSelectedPressed(EAction eAction) {
		proceed();
	}

	@Override
	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

		if (!(cardPlayer instanceof CardPlayerRegion))
			return;

		CardPlayerRegion cardPlayerRegion = (CardPlayerRegion) cardPlayer;
		EColor eColor = cardPlayerRegion.getEColor();

		if (!eColor.equals(this.eColor))
			return;

		cardPlayerRegion.reverseSelected();

		if (GetCardsSelectedActivePlayer.INSTANCE.execute().size() == 5)
			Actions.INSTANCE.selectAction(EAction.BUILD_HYDRAULIC_STRUCTURE);
		else
			Actions.INSTANCE.deselectAction(EAction.BUILD_HYDRAULIC_STRUCTURE);

	}

	private void proceed() {

		DiscardCardsSelected.INSTANCE.execute();
		BuildHydraulicStructure.INSTANCE.execute();
		Flow.INSTANCE.executeGameState(this.hashMap.getValue(this.eColor));

	}

	private void setEColor() {

		ERegion eRegion = GetERegionContainingPlayerPawn.INSTANCE
				.getERegionContainingPlayerPawnActive();
		this.eColor = eRegion.getRegion().getEColor();

	}

	private void createHashMap() {

		this.hashMap.put(EColor.RED, ResolveHydraulicStructureOrange.class);
		this.hashMap.put(EColor.PURPLE, ResolveHydraulicStructurePurple.class);
		this.hashMap.put(EColor.YELLOW, ResolveHydraulicStructureYellow.class);
		this.hashMap.put(EColor.GREEN, ResolveHydraulicStructureGreen.class);

	}

}
