package gameStatesDefault;

import business.Adjacency;
import business.Dike;
import business.DikeLocation;
import business.Pawn;
import business.Player;
import business.PopulationCube;
import business.Port;
import business.PumpingStation;
import business.Region;
import business.WaterCube;
import cards.Card;
import cards.CardPlayer;
import cards.CardRole;
import controller.Credentials;
import enums.EAction;
import enums.ERegion;
import enums.EText;
import gui.InstancesGui;
import javafx.scene.input.KeyCode;
import model.Actions;
import model.Adjacencies;
import model.Players;
import utils.Animation;
import utils.ArrayList;
import utils.CameraView;
import utils.Flow;
import utils.KeyCodeHandler;
import utils.Logger;
import utils.SelectImageViewManager;
import utils.TextManager;
import utils.Vector2;

public abstract class GameState {

	public abstract void execute();

	protected final void handleM() {

		InstancesGui.INSTANCE.getStage()
				.setFullScreen(!InstancesGui.INSTANCE.getStage().isFullScreen());

		if (InstancesGui.INSTANCE.getStage().isFullScreen())
			InstancesGui.INSTANCE.getStage().setX(0);
		else
			InstancesGui.INSTANCE.getStage().setX(-510);

	}

	public final void handleTextOptionPressed(EText textEnum) {

		Logger.INSTANCE.log("text option executing");
		Logger.INSTANCE.logNewLine(textEnum);

		TextManager.INSTANCE.concealText();
		executeTextOption(textEnum);

	}

	public final void executeKeyPressed(KeyCode keyCode) {

		if (Animation.INSTANCE.isAnimating())
			return;

		handleKeyPressed(keyCode);

		// e text

		int keyCodeETextID = KeyCodeHandler.INSTANCE.getKeyCodeETextInt(keyCode);

		if (keyCodeETextID != -1) {

			EText textEnumPressed = TextManager.INSTANCE.getTextEnumOptionPressed(keyCodeETextID);

			if (textEnumPressed == null)
				return;

			Logger.INSTANCE.log("executing key pressed -> " + keyCode);
			handleTextOptionPressed(textEnumPressed);

		}

		// camera view

		int cameraViewSpot = KeyCodeHandler.INSTANCE.getKeyCodeCameraViewInt(keyCode);

		if (cameraViewSpot > 0 && cameraViewSpot <= Credentials.INSTANCE.cameraViewSpots)
			CameraView.INSTANCE.setCameraViewingSpot(cameraViewSpot);

	}

	protected void handleKeyPressed(KeyCode keyCode) {

	}

	protected void executeTextOption(EText eText) {

	}

	protected final ArrayList<Class<? extends GameState>> getFlow() {
		return Flow.INSTANCE.getFlow();
	}

	protected final void executeGameState(Class<? extends GameState> gameState) {
		Flow.INSTANCE.executeGameState(gameState);
	}

	protected final void proceedToNextGameState() {
		Flow.INSTANCE.proceed();
	}

	protected final void concealText() {
		TextManager.INSTANCE.concealText();
	}

	protected final SelectImageViewManager getSelectImageViewManager() {
		return SelectImageViewManager.INSTANCE;
	}

	public final void handleBackgroundPressed(Vector2 vector2) {

		EAction eActionPressed = Actions.INSTANCE.getEActionPressed(vector2);

		if (eActionPressed != null)
			handleActionPressed(eActionPressed);

	}

	public final void handleCardEntered(Card card) {

		// check for card in player's hand

		for (Player player : Players.INSTANCE.getList()) {

			if (!player.getCardsPlayer().getArrayList().contains(card))
				continue;

			card.getImageView().toFront();

		}

		// check for card role

		if (card instanceof CardRole)
			card.getImageView().toFront();

	}

	public final void handleCardExited(Card card) {

		// check for card in player's hand

		for (Player player : Players.INSTANCE.getList()) {

			if (!player.getCardsPlayer().getArrayList().contains(card))
				continue;

			player.getCardsPlayer().layerZSort();

		}

		// check for card role

		if (card instanceof CardRole)
			card.getImageView().toBack();

	}

	public final void handleCardPressed(Card card) {

		if (Players.INSTANCE.getActivePlayer().getCardsPlayer().getArrayList().contains(card))
			handleCardPressedActivePlayer((CardPlayer) card);

		if (Players.INSTANCE.getPassivePlayer().getCardsPlayer().getArrayList().contains(card))
			handleCardPressedPassivePlayer(card);

	}

	protected void handleCardPressedActivePlayer(CardPlayer cardPlayer) {

	}

	protected void handleCardPressedPassivePlayer(Card card) {

	}

	public final void handleActionPressed(EAction eAction) {

		if (!Actions.INSTANCE.actionIsSelected(eAction))
			return;

		Actions.INSTANCE.concealActions();

		Logger.INSTANCE.log("action pressed");
		Logger.INSTANCE.log(eAction);
		Logger.INSTANCE.newLine();

		handleActionSelectedPressed(eAction);

	}

	protected void handleActionSelectedPressed(EAction eAction) {

	}

	public final void handleDikeLocationPressed(DikeLocation dikeLocation) {

		if (!dikeLocation.isSelected())
			return;

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		handleDikeLocationSelectedPressed(dikeLocation);

	}

	protected void handleDikeLocationSelectedPressed(DikeLocation dikeLocation) {

	}

	public final void handleDikePressed(Dike dike) {

		for (ERegion eRegion : ERegion.values()) {

			ArrayList<Adjacency> list = Adjacencies.INSTANCE.getAdjacenciesOfRegion(eRegion);

			for (Adjacency adjacency : list) {

				DikeLocation dikeLocation = adjacency.getDikeLocation();

				if (dikeLocation == null)
					continue;

				if (!dikeLocation.containsDike(dike))
					continue;

				handleDikeLocationPressed(dikeLocation);
				return;

			}

		}

	}

	public final void handleRegionPressed(ERegion eRegion, Region region) {

		Logger.INSTANCE.log("selected region pressed");
		Logger.INSTANCE.logNewLine(eRegion);

		if (!region.isSelected())
			return;

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		handleRegionSelectedPressed(eRegion, region);

	}

	protected void handleRegionSelectedPressed(ERegion eRegion, Region region) {

	}

	public final void handleWaterCubePressed(WaterCube waterCube) {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.getWaterCubes().getArrayList().contains(waterCube))
				handleRegionPressed(eRegion, region);

		}

	}

	public final void handlePopulationCubePressed(PopulationCube populationCube) {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.getPopulations().getArrayList().contains(populationCube))
				handleRegionPressed(eRegion, region);

		}

	}

	public final void handleWaterPumpPressed(PumpingStation waterPump) {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.getPumpingStation().getArrayList().contains(waterPump))
				handleRegionPressed(eRegion, region);

		}

	}

	public final void handlePortPressed(Port port) {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.getPort().getArrayList().contains(port))
				handleRegionPressed(eRegion, region);

		}

	}

	public final void handlePawnPressed(Pawn pawn) {

		for (ERegion eRegion : ERegion.values()) {

			Region region = eRegion.getRegion();

			if (region.getPawns().getArrayList().contains(pawn))
				handleRegionPressed(eRegion, region);

		}

	}

}
