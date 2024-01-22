package business;

import cards.CardPlayer;
import cards.CardRole;
import controller.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RelocateTypeEnum;
import utils.ListCredentials;
import utils.ListImageViewAbles;
import utils.ObjectPool;
import utils.Vector2;

public class Player {

	private ListImageViewAbles<CardRole> cardRole = new ListImageViewAbles<>();
	private ListImageViewAbles<CardPlayer> cardsPlayer = new ListImageViewAbles<>();
	private ListImageViewAbles<ActionsRemaining> actionsRemaining = new ListImageViewAbles<>();

	public Player(Vector2 coordinates) {
		createLists(coordinates);
	}

	public ListImageViewAbles<CardRole> getCardRole() {
		return this.cardRole;
	}

	public ListImageViewAbles<CardPlayer> getCardsPlayer() {
		return this.cardsPlayer;
	}

	public int getActionsRemaining() {
		return this.actionsRemaining.getArrayList().size();
	}

	public void resetActionsRemaining() {

		while (!this.actionsRemaining.getArrayList().isEmpty())
			reduceActionsRemaining();

		addActionsRemaining(4);

	}

	public void reduceActionsRemaining() {
		this.actionsRemaining.getArrayList().removeLast().getImageView().setVisible(false);
	}

	public void addActionsRemaining(int amount) {

		for (int counter = 1; counter <= amount; counter++) {

			ActionsRemaining actionsRemaining = ObjectPool.INSTANCE.acquire(ActionsRemaining.class);
			actionsRemaining.getImageView().setVisible(true);
			this.actionsRemaining.getArrayList().addLast(actionsRemaining);

		}

		this.actionsRemaining.relocateImageViews();

	}

	private void createLists(Vector2 coordinates) {

		ListCredentials listCredentials = null;

		// card role

		listCredentials = this.cardRole.getListCredentials();
		listCredentials.coordinatesList = coordinates.clone();

		// cards player

		listCredentials = this.cardsPlayer.getListCredentials();
		listCredentials.coordinatesList = coordinates.clone();
		listCredentials.coordinatesList.y += Credentials.INSTANCE.dCard.y / 2;
		listCredentials.gapBetweenComponents.y = Credentials.INSTANCE.dCard.y / 2;
		listCredentials.layerZListEnum = LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW;
		listCredentials.objectsPerRow = 4;
		this.cardsPlayer.getArrayList().setCapacity(7);

		// actions remaining

		listCredentials = this.actionsRemaining.getListCredentials();
		listCredentials.coordinatesList = coordinates.clone();
		listCredentials.coordinatesList.x += Credentials.INSTANCE.dCard.x;
		listCredentials.coordinatesList.x += Credentials.INSTANCE.dGapBetweenComponents.x;
		listCredentials.coordinatesList.x += Credentials.INSTANCE.dActionsRemaining.x / 2;
		listCredentials.coordinatesList.y += 0.25 * Credentials.INSTANCE.dCard.y;
		listCredentials.relocateTypeEnum = RelocateTypeEnum.CENTER;

	}

}
